package com.tatelucky.yduts.base;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Stack
 *
 * @author tangsheng
 * @since 2019-10-12
 */
public class StackStudy {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        //压栈
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //可以为null
        stack.push(null);
        stack.push(null);
        //判空
        System.out.println("栈空的？：" + stack.empty());

        //search方法的返回值是:返回最靠近顶端的目标元素到顶端的距离
        System.out.println("顶端的目标元素到顶端的距离" + stack.search(1));


        //返回栈顶端的元素。
        System.out.println("栈顶元素" + stack.peek());

        //先进后出
        //pop前先做判断
        //System.out.println(stack.pop());
        while (!stack.empty()) {
            System.out.println("pop: " + stack.pop());
        }

        System.out.println("栈空的？：" + stack.empty());


        //不过，源码都说了不建议去使用stack, 而是去使用ArrayDeque
        Deque<Integer> deque = new ArrayDeque<Integer>();
    }
}
