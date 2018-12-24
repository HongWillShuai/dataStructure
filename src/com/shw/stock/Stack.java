package com.shw.stock;

/**
 * @author WillShuai
 * @date 2018/12/24--21:30
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
