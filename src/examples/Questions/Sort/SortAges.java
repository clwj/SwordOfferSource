package examples.Questions.Sort;

import java.util.Arrays;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/20 17:53
 */
public class SortAges {
    //按所有员工的年龄进行排序，要求复杂度O(n)。
    //此题特点是所有的数字大小在一个小范围内（年龄在0-99,使用辅助空间）
    private void sortAges(int ages[]){
        if (ages.length ==0){
            System.out.println("数组输入大小为0");
            return;
        }
        int oldestAge = 99;
        int minAge = 0;
        int[] timesAge = new int[oldestAge-minAge];   //创建一个数组用于保存年龄的数量

        for (int j=0; j<timesAge.length; j++){    //数组全部设置为0
            timesAge[j] = 0;
        }

        for (int i=0; i<ages.length; i++){
            if (ages[i]<minAge || ages[i]>oldestAge){
                System.out.println("数组越界");
                return;
            }
            timesAge[ages[i]] ++;
        }

        //年龄排序
        int index = 0;
        for (int i=0; i<oldestAge; i++){
            for (int j=0; j<timesAge[i]; j++){
                ages[index] = i;
                index++;
            }
        }

    }
    public static void main(String[] args) {
        SortAges test = new SortAges();
        int a[] = {14,25,22,44,29,44,88};
        test.sortAges(a);
        System.out.println(Arrays.toString(a));
    }
}
