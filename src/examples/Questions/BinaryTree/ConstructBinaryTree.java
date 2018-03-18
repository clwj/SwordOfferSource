package examples.Questions.BinaryTree;


/**
 * @Author Wenjian Lu
 * @Date 2018/3/18 9:57
 * 构建二叉树
 */
/**
 * 面试题6：重建二叉树。
 * 输入二叉树的前序遍历和中序遍历结果,重建二叉树。假设输入的前序和中序结果都不含重复的数，例如:前序12473568,中序47215386,输出后序遍历结果。
 * 思路：所谓前中后序即根节点的访问顺序。前序的第一个数肯定是根节点，而根节点在中序里的中间位置，其左为左子树，右边是右子树。
 * 假设中序的根节点左边有3个数，可知根节点的左子树有3个节点，此时这三个数的顺序即是左子树的中序。那么前序的第一个数的后边三个数肯定也是左子树，并且是该左子树的前序。
 * 那么左右子树的前序和中序都有了，就可以递归了。
 */

public class ConstructBinaryTree {
    public static void main(String[] args){
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] inorder = {4,7,2,1,5,3,8,6};
        postOrder(rebuild(preorder,inorder));

    }

    public static TreeNode rebuild(int[] preOrder, int[] inOrder){
        TreeNode root = rebuild(preOrder,0,preOrder.length-1, inOrder,0,inOrder.length-1);
        return root;
    }
    public static TreeNode rebuild(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd || preOrder.length != inOrder.length){
            return null;
        }
        //前序第一个为根节点
        TreeNode root = new TreeNode();
        for (int i=inStart; i<=inEnd; i++){
            if (preOrder[preStart] == inOrder[i]){    //找到根节点
                root.nData = preOrder[preStart];
                root.leftNode = rebuild(preOrder,preStart+1,preStart+1+(i-inStart),inOrder,inStart,i-1);
                root.rightNode = rebuild(preOrder,i-inStart+1+preStart,preEnd,inOrder,i+1,inEnd);
            }
        }
        return root;

    }
    public static void postOrder(TreeNode root){
        if (root == null)
            return;
        if (root.leftNode != null){
            postOrder(root.leftNode);
        }
        if (root.rightNode != null){
            postOrder(root.rightNode);
        }
        System.out.println(root.nData);
    }




}
