package examples.Questions.LinkListDelete;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/22 13:42
 */

/**
 * 面试题13：在O(1)时间删除链表结点
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 思路：一般思路是从头开始遍历，这样复杂度是O(n)不合题意。我们的方法是把该节点的值设为该节点下一个节点的值，然后让该节点指向下下一个节点。
 * 这样会有三种情况：1，要删除的节点不是尾节点。2，链表只有一个节点3，要删除的节点是尾节点，只能从头到尾遍历了。最后平均一下复杂度还是O(1)。
 */
public class DeleteNode {
    private LinkNode head = null;

    /**
     * 在链表头插入节点
     * @param value
     */
    public LinkNode addFirst(int value){
        LinkNode linkNode = new LinkNode(value);
        linkNode.next = head;
        head = linkNode;
        return linkNode;
    }

    public void delete(LinkNode toDetele){
        if (head == null || toDetele == null){
            System.out.println("链表头或者删除节点都为空");
            return;
        }
        if (head == toDetele){   //只有一个头节点
            head = null;
            return;
        }
        else if (toDetele.next != null){   //删除的节点不为尾节点
            toDetele.value = toDetele.next.value;
            toDetele.next = toDetele.next.next;
        }
        else{     //删除的节点为尾节点
             while (head.next != toDetele){
                 head = head.next;
             }
             head.next = null;
        }
    }
    public void display(){
        System.out.println("链表（First->Last）：");
        LinkNode current = head;
        while (current != null){
            System.out.println(current.value+"  ");
            current = current.next;
        }
    }
    public static void main(String[] args){
        DeleteNode deleteNode = new DeleteNode();
        deleteNode.addFirst(1);
        LinkNode todelete = deleteNode.addFirst(2);
        deleteNode.addFirst(3);
        deleteNode.display();
        deleteNode.delete(todelete);
        deleteNode.display();
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
