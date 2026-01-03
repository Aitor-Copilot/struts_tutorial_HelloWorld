# Investigation: Why Nested Property Access Doesn't Work in Struts 2.7.1

## Problem
The nested property access `messageStore.message` does not work in Struts 2.7.1, even though:
- The `MessageStore` object exists and is accessible
- The `getMessage()` method exists and works
- Direct property access from the action works

## Test Results

### What Works ✅
1. **Direct property from action**: `<s:property value="message" />` ✅
2. **Accessing the object**: `<s:property value="messageStore" />` ✅ (shows object reference)
3. **Getter method**: `<s:property value="getMessageStore()" />` ✅ (shows object reference)
4. **Using `<s:push>` tag**: 
   ```jsp
   <s:push value="messageStore">
       <s:property value="message" />
   </s:push>
   ```
   ✅ **This works!**

### What Doesn't Work ❌
1. **Nested property access**: `<s:property value="messageStore.message" />` ❌ (empty)
2. **Method call on nested object**: `<s:property value="messageStore.getMessage()" />` ❌ (empty)
3. **Chained method calls**: `<s:property value="getMessageStore().getMessage()" />` ❌ (empty)

## Root Cause Analysis

### OGNL Security Restrictions in Struts 2.7+
Struts 2.5+ introduced stricter OGNL (Object-Graph Navigation Language) security restrictions to prevent security vulnerabilities. These restrictions:

1. **Block method calls on nested objects**: Security feature prevents calling methods on objects accessed through properties
2. **Restrict nested property navigation**: May have limitations on deep property access chains
3. **Value Stack Context**: OGNL works best when objects are on the Value Stack directly

### Why `<s:push>` Works
The `<s:push>` tag pushes the `MessageStore` object onto the top of the Value Stack, making it the current context. When you then access `message`, OGNL finds it directly on the stack without needing to navigate through nested properties.

## Solutions

### Solution 1: Direct Property (Current Implementation) ✅
Expose the message directly from the action:
```java
public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore;
    private String message;

    @Override
    public String execute() {
        messageStore = new MessageStore();
        message = messageStore.getMessage();
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }
}
```
JSP: `<s:property value="message" />`

### Solution 2: Use `<s:push>` Tag ✅
Keep the nested object structure and use push:
```jsp
<s:push value="messageStore">
    <s:property value="message" />
</s:push>
```

### Solution 3: Access via Action Getter
Create a getter that returns the nested value:
```java
public String getMessageStoreMessage() {
    return messageStore != null ? messageStore.getMessage() : null;
}
```
JSP: `<s:property value="messageStoreMessage" />`

## Configuration Options (Not Recommended for Production)

If you need to enable nested property access (security risk), you could try adding to `struts.xml`:
```xml
<constant name="struts.ognl.allowStaticMethodAccess" value="true"/>
```

However, this is **NOT recommended** as it reduces security and may not solve the nested property issue.

## Conclusion

The nested property access `messageStore.message` doesn't work due to OGNL security restrictions in Struts 2.7+. The recommended solutions are:
1. **Use direct properties** (simplest and most secure)
2. **Use `<s:push>` tag** (maintains object structure)
3. **Create helper getters** (explicit and clear)

The current implementation using Solution 1 is the most straightforward and secure approach.
