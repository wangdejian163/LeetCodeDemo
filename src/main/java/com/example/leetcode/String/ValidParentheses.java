package com.example.leetcode.String;

import java.util.Stack;

/**
 * <p>
 * 20.Valid Parentheses
 * </p>
 *
 * @author wangdejian
 * @since 2018/3/9
 */
public class ValidParentheses {

    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     *
     * 此题的关键点在于栈的使用；栈是先入后出的特点，像叠积木一样，往栈中添加元素时，从下往上一层层添加；
     * 而将栈中的元素删除时，则从顶往下删除，每次最先删除的肯定栈顶元素；
     */
    public boolean isValid(String s) {
        //如果s为空或者长度为0或者长度为奇数，括号肯定不匹配
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        char[] stack = new char[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack[i] = c;
                    i++;
                    break;
                case '}':
                    if (i == 0 || stack[--i] != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (i == 0 || stack[--i] != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (i == 0 || stack[--i] != '(') {
                        return false;
                    }
                    break;
            }
        }

        return i == 0;
    }

    public static boolean isValid2(String s) {
        //如果s为空或者长度为0或者长度为奇数，括号肯定不匹配
        if (s == null || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        //定义一个装载char类型数据的栈，栈也是属于集合，装载对象，而不能直接装载基本数据类型
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
