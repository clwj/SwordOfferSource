package examples.Questions.FindKthToTail;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/22 15:34
 */

import java.util.Scanner;

/**
 * 面试题15：链表中倒数第K个结点
 * 输入一个单链表，输出该链表中倒数第k个结点。链表的尾结点是倒数第1个结点。例如一个链表有4个结点，依次是1,2,3,4,这个链表的倒数第3个结点是2。
 * 思路1：假设链表有n个结点，那么倒数第k个结点就是从头开始的第n-k+1个结点。所以一种方法是遍历两次链表，第一次得到n，第二次找到k。
 * 思路2：更好的方法是只需遍历一次，我们定义两个指针，第一个指针从头开始走k-1步，从第k步开始，第二个指针也开始从头开始走，两个指针的距离为k-1，当第一个指针到达尾结点时，第二个指针刚好在倒数第k个。
 * 相关题1：求链表的中间结点。如果是结点数是偶数，返回中间两个任意一个。也可以用两个指针，一个指针一次走一步，另一个走两步，走得快的到末尾时，走得慢的刚好在中间结点。
 * 相关题2：判断单链表是否形成环形结构。还是一个指针走一步，一个指针走两步，走得快的指针如果追上走得慢的指针，那么就是环形的。如果走得快的走到了末尾都没有追上，说明不是环形。
 */
public class FindKthToTail {
    public static void main(String[] args){
        FindKthToTail findKthToTail = new FindKthToTail();
        LinkNode head = findKthToTail.insertFirst();
        findKthToTail.print(head);
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查询链表的倒数第几个:");
        int findValue = scanner.nextInt();
        LinkNode find = findKthToTail.find(head,findValue);
        System.out.println("查找的第"+findValue+"个数据为"+find.value);

    }

    public LinkNode insertFirst(){
        Scanner scanner = new Scanner(System.in);
        LinkNode head = null;
        System.out.println("请输入各个链表的值，以0结束");
        int nValue = scanner.nextInt();
        while (nValue != 0){
            LinkNode newNode = new LinkNode(nValue);
            newNode.next = head;
            head = newNode;
            nValue = scanner.nextInt();
        }
        return head;    //返回链表的头节点
    }
    //正序打印链表
    public void print(LinkNode head){
        if (head == null){
            System.out.println("链表为空");
            return;
        }
        LinkNode current = head;
        System.out.println("链表（First->Last）:");
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    //查找到倒数第k个节点
    public LinkNode find(LinkNode head, int k){
        if (head == null){
            System.out.println("链表为空");
            return null;
        }
        if (k<0){
            System.out.println("数据输入有误");
            return null;
        }
        LinkNode p1 = head;
        LinkNode p2 = head;
        for (int i=0; i<k-1; i++){
            if (p1 == null){
                System.out.println("数据K输入有误");
                return null;
            }
            p1 = p1.next;
        }
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


}
class LinkNode{
    int value;
    LinkNode next;
    public LinkNode(int value){
        this.value = value;
        next = null;
    }
}

