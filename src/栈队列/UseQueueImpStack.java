package 栈队列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName UseQueueImpStack
 * @Author zhaoqin
 * @Date 2020/2/22
 *
 * 和用栈实现队列的原理一样
 */
public class UseQueueImpStack {
    private Queue<Integer> queue = new LinkedList<>();

    /**
     * 进栈
     */
    public void push(int num){
        queue.add(num);
        int size = queue.size();
        while (size-- > 0){
            queue.add(queue.poll());
        }
    }

    /**
     * 出栈
     * @return
     */
    public Integer pop(){
       return queue.poll();
    }



}
