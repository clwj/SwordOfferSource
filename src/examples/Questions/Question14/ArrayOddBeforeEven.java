package examples.Questions.Question14;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/22 14:48
 */
/**
 * 面试题14：使数组中奇数位于偶数前
 * 输入一个整数数组，实现一个函数来调整数组中的数字的顺序，使得所有奇数位于数组的前半部分，偶数位于后半部分。
 * 思路：前后各一个指针相互靠近，如果前偶后奇，交换位置，直到两个指针相遇。复杂度O(n)。
 * 注意：如果题目换成负数在正数前边，或能被3整除的在不能的前边等，只是判断条件改变，所以我们把判断功能分离出来，每次只修改这个功能就行了。
 */
public class ArrayOddBeforeEven {

    public static void main(String[] args){
        int[] array = {5,6,1,3,9,2,4};
        ArrayOddBeforeEven arrayOddBeforeEven = new ArrayOddBeforeEven();
        arrayOddBeforeEven.reOrder(array);
        for (int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    public void reOrder(int[] array){
        int left = 0;
        int right = array.length-1;
        int temp;
        while (left<right){
            while ((left<right) && (array[left]%2 == 0)){
                left++;
            }
            while ((left<right) && (array[right]%2==1)){
                right--;
            }
            temp = array[right];
            array[right] = array[left];
            array[left] = temp;
        }
    }

}
