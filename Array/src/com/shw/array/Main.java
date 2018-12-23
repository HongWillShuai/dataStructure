package com.shw.array;

/**
 * @author WillShuai
 * @date 2018/12/23--20:03
 */
public class Main {
    public static void main(String[] args) {
        Array<Integer> array = new Array();
        for (int i = 0; i < 3; i++) {
            array.addLast(i);
        }
        System.err.println(array.toString());
        array.addFrist(100);
        System.err.println(array.toString());
        System.err.println(array.getCapacity());
    }
}
