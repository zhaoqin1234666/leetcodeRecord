package 栈队列;

import netscape.security.UserTarget;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Stack;

/**
 * @ClassName UseStackImpQueue
 * @Author zhaoqin
 * @Date 2020/2/22
 *
 * 使用栈实现队列
 * 栈 先进后出
 *
 * 思路 两个栈  一个栈(in)负责插入元素   一个栈(out)负责拿元素
 * push  in.push
 * pop 会先判断out是不是空的 在判断in是不是空的
 *  如果 out不空 out.pop
 *  如果 out空 in不空 out.push(in.pop) 将in的所有元素反转并插入out 然后out.pop
 *  如果 out空 in空 说明没有元素
 *
 */
public class UseStackImpQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public static void main(String[] args) {
        UseStackImpQueue useStackImpQueue = new UseStackImpQueue();
        //进队列
        useStackImpQueue.push(useStackImpQueue.in, 1);
        useStackImpQueue.push(useStackImpQueue.in, 2);
        useStackImpQueue.push(useStackImpQueue.in, 3);
        useStackImpQueue.push(useStackImpQueue.in, 4);
        useStackImpQueue.push(useStackImpQueue.in, 5);
        System.out.println(useStackImpQueue.in);

        System.out.println();
        //出队
        System.out.println(useStackImpQueue.pop(useStackImpQueue.in, useStackImpQueue.out));
        System.out.println(useStackImpQueue.pop(useStackImpQueue.in, useStackImpQueue.out));
        System.out.println(useStackImpQueue.pop(useStackImpQueue.in, useStackImpQueue.out));
        System.out.println(useStackImpQueue.pop(useStackImpQueue.in, useStackImpQueue.out));
        System.out.println(useStackImpQueue.pop(useStackImpQueue.in, useStackImpQueue.out));

    }

    /**
     * 出队列 并删除元素
     * @return
     */
    public int pop(Stack<Integer> in, Stack<Integer> out){
        if(out.empty()){
            while (!in.empty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * 进队列
     */
    public void push(Stack<Integer> in, int num){
        in.push(num);
    }


}
