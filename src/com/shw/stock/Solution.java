package com.shw.stock;


import com.shw.stock.impl.ArrayStack;

import java.util.Stack;

/**
 * @author WillShuai
 * @date 2018/12/24--22:05
 */
public class Solution {
    public boolean isValid(String s){
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(c==')'&&topChar!='('){
                    return false;
                }
                if(c == ']'&&topChar!='['){
                    return false;
                }
                if(c=='}'&&topChar!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = (new Solution()).isValid("()[]{");
        System.err.println(valid);
    }
}
