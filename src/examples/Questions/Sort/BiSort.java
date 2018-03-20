package examples.Questions.Sort;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/20 16:35
 */

/**
 * 二分查找算法
 */
public class BiSort {
    public static int biSort(int[] array, int x, int start, int end){
        if (start <= end){
            int mid = (start+end)/2;
            if (x == array[mid]){
                return mid;
            }
            if (x < array[mid]){
                return biSort(array, x, start, mid-1);
            }
            else{
                return biSort(array,x,mid+1,end);
            }
        }
        return -1;

    }
    public static void main(String[] args){
        int[] array = {1,3,6,9,11,13,26,45,60};
        int index = biSort(array,45,0,array.length-1);
        System.out.println("下标为"+index);
    }
}
