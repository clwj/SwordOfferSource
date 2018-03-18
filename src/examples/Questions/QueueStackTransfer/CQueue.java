package examples.Questions.QueueStackTransfer;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/18 16:26
 */

import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列
 * 完成两个函数appendTail和deletedHead，分别是在队列尾部插入节点和在队列头部删除节点的功能。
 * 思路：添加元素即压入一个栈s1，删除元素的话，把s1中的元素按顺序先弹出再压入栈s2中，这是弹出栈s2的元素就能实现先进先出了。
 * 相关题：用两个队列实现栈。
 * 思路：添加元素即向一个队列q1添加元素，删除元素的话，把q1的元素按顺序出队然后入队到q2，最后q1剩下一个元素，就是要出栈的元素。再添加元素的话，向非空的队列添加。
 */
public class CQueue {
    private  Stack<Integer> stack1 = new Stack<Integer>();
    private  Stack<Integer> stack2 = new Stack<Integer>();

    public void appendTail(int ele){
        stack1.push(ele);
    }
    public int deleteHead(){
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        else if (!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
        else{
            System.out.println("两个栈都为空");
            return -1;
        }
    }
    public static void main(String[] args){
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(5);
        System.out.println(cQueue.deleteHead());

    }
}
