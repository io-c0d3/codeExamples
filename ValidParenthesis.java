/**
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
*/



// One of my first ones to be in the top 1% first go, by myself! Woooo.
    // This solution validates the 'grammar' of a String of braces, '(, ), [, ], {, }'. Making sure the
    // braces are all in valid pairs that open and then close.
 
 
 class Solution {
    public boolean isValid(String s) {
        // If there is 1 or less braces, there isnt any valid pairs.
        if (s.length() <= 1) return false;
        // Get the length of the String.
        int stringLength = s.length();
        // Create a Stack.
        Stack<Character> stack = new Stack<Character>();
        // Get the first and last characters in the String.
        char k = s.charAt(0);
        char n = s.charAt(s.length() - 1);
        // If the first character is a close brace or the last character is an open brace, return false.
        if (k == ')' || k == ']' || k == ']' || n == '(' || n == '[' || n == '{') return false;

        // For each character in the String.
        for (int i = 0; i < stringLength; i++) {
            // Get the character at the current index.
            char c = s.charAt(i);
            // If the character is an open brace, push it to the Stack.
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            // Otherwise if it is a close brace and the stack isnt empty, check the top item on the Stack. If 
            // the top item is an open brace and the current character is the corresponding close brace, pop the
            // top item off the stack and move on. If they are a non-matching pair, return false.
            else if (!stack.empty()) {
                char peekChar = stack.peek();
                int peek = peekChar;
                int cVal = (int)c;
                if (peek == 40 && cVal == 41) stack.pop();
                else if (peek == 91 && cVal == 93) stack.pop();
                else if (peek == 123 && cVal == 125) stack.pop();
                else return false;
            }
            // If the stack is empty and the current character is a close brace, return false.
            else if (stack.empty() && c == 41 || c == 93 || c == 125) return false;
            
        }
        // If the stack contains one or more braces that didnt get closed, return false.
        if (!stack.empty()) return false;
        // Otherwise, if all requirements have been fulfilled, return true.
        return true;
    }
}
