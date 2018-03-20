package examples.Questions.Sort;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/18 21:38
 */

import java.util.Arrays;

/**
 * 快速排序
 */
public class QSort {
    //快排
    private void qsort(int a[],int left,int right){
        if(a.length == 0) System.out.println("输入为空");
        if(left >= right) return;//代表快排完成一轮了
        int i  = left;
        int j = right;
        int pivot = a[right];   //用最右边的数据作为枢纽
        while (i < j){
            while (i<j && a[i] <= pivot){
                i++;
            }
            a[j] = a[i];
            while (i<j && a[j] >= pivot){
                j--;
            }
            a[i] = a[j];
        }
        a[j] = pivot;
        qsort(a,left,j-1);
        qsort(a,j+1,right);
        //此时 a[i]为




    }
    public static void main(String[] args) {
        QSort test = new QSort();
        int array[] = {5,4,6,3,1};
        test.qsort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

}
