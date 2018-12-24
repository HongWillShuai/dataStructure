package com.shw.stock;

import com.shw.stock.impl.ArrayStack;

/**
 * @author WillShuai
 * @date 2018/12/24--21:50
 */
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> stock = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stock.push(i);
            System.err.println(stock);
        }
    }
}
