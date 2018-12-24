package com.shw.stock.impl;

import com.shw.array.Array;
import com.shw.stock.Stack;

/**
 * @author WillShuai
 * @date 2018/12/24--21:32
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    public ArrayStack(){
        array = new Array<>();
    }
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }


    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stock: ");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i!=array.getSize()-1){
                res.append(", ");
            }
        }
        return  res.append("] top").toString();
    }
}
