package examples.Questions.PrintList;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/16 18:54
 */

import sun.awt.image.ImageWatched;

import java.util.Scanner;
import java.util.Stack;

/**
 * 面试题5：输入一个链表的头结点，从尾到头打印每个节点的值。（打印操作一般不改变链表的结构）
 * 思路1：典型的后进先出，用栈。
 * 思路2：能用栈就能用递归(层数太深容易溢出)，访问到一个节点后，递归输出它后面的节点，再输出该节点自身。
 */
public class PrintListReversingly {

    //创建链表
    public static LinkNode createList(LinkNode head){
        LinkNode p = head;
        if (p == null){
            System.out.println("输入头节点为空，请重新输入");
            return null;
        }
        System.out.println("请输入链表的值，以0结束");
        Scanner scanner = new Scanner(System.in);
        int nData = scanner.nextInt();
        while (nData != 0){
            LinkNode newNode = new LinkNode();
            newNode.data = nData;
            newNode.next = null;
            p.next = newNode;
            p =newNode;
            nData = scanner.nextInt();
        }
        scanner.close();
   //返回头节点
        return head;
    }
    //逆序打印
    public static void printVerse(LinkNode head){
        Stack<LinkNode> stack = new Stack<LinkNode>();
        while(head.next != null && head != null){
            stack.push(head.next);
            head = head.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop().data);
        }
    }

    //顺序打印
    public static void print(LinkNode head){
        while(head.next != null && head != null){
            System.out.println(head.next.data);
            head = head.next;
        }

    }
    public static void printRecursive(LinkNode head){
        if (head != null){
            if (head.next != null){
                printRecursive(head.next);
            }
            System.out.println(head.data);
        }
    }

    public static void main(String[] args){
        LinkNode head = new LinkNode();
      //  printVerse(createList(head));
      //  print(createList(head));
        printRecursive(createList(head));
    }

}
//链表节点
class LinkNode{
    int data;
    LinkNode next = null;
}
