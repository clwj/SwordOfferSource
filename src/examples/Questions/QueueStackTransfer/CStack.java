package examples.Questions.QueueStackTransfer;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/18 16:40
 */


import java.util.LinkedList;
import java.util.Queue;

/**相关题，两个队列实现栈。
 * *
 */
public class CStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();


    public static void main(String[] args){
         CStack cStack = new CStack();
         cStack.appedTail(1);
         cStack.appedTail(2);
         cStack.appedTail(3);
         cStack.appedTail(4);
         System.out.println(cStack.deleteHead());
         System.out.println(cStack.deleteHead());
         cStack.appedTail(5);
         System.out.println(cStack.deleteHead());
         System.out.println(cStack.deleteHead());
         System.out.println(cStack.deleteHead());
    }

    public void appedTail(int value){
         if (!queue1.isEmpty()){
             queue1.offer(value);
         }
         else{
             queue2.offer(value);
         }
    }
    public int deleteHead(){
        Queue<Integer> emptyQueue = queue1;
        Queue<Integer> notEmptyQueue = queue2;

        if (!emptyQueue.isEmpty()){
            emptyQueue = queue2;
            notEmptyQueue = queue1;
        }
        while (notEmptyQueue.size() != 1){
            emptyQueue.offer(notEmptyQueue.poll());
        }
        //删除刚才剩余的最后一个元素
        return notEmptyQueue.poll();
    }
}
