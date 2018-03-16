package examples.Questions.QueFind;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/16 16:09
 */

import java.util.Scanner;

/**
 * 面试题3：在一个二维数组中，每一行的数从左到右递增，每一列的数从上到下递增。输入这样的一个数组和一个整数，判断数组中是否含有该整数。
 * 思路：别从左到右一个一个比，先比右上角的或左下角的，如果要找的数比这个数小，剔除这一列，比较前一列的第一个数。如果大，剔除这一行，再比较该列下一个数。
 * 注意如果先比左上角或右下角的是不行的。
 */
public class Find {
    public static void main(String[] args){
        int[][] array = input();
        if (array != null){
            System.out.println("请输入您要查找的数据:");
            Scanner scanner = new Scanner(System.in);
            int target = scanner.nextInt();
            if (find(array,target) == true){
                System.out.println("找到额");
            }
            else
                System.out.println("没有找到");
        }


    }

    private static int[][] input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入二维数组的行数:");
        int nRows = scanner.nextInt();
        System.out.println("请输入二维数组的列数:");
        int nColumn = scanner.nextInt();
        int[][] array = new int[nRows][nColumn];
        if (nRows != 0 && nColumn != 0){
            for (int i=0; i<nRows; i++){
                System.out.println("请输入第"+(i+1)+"行的"+(nColumn)+"个数");
                for (int j=0; j<nColumn; j++){
                    array[i][j] = scanner.nextInt();
                }
            }
            return array;
        }
        else{
            System.out.println("数组大小输入有误，请重新输入");
            return null;
        }

    }
    /**
     * 查找函数
     * 从右上角开始查找
     */
    public static boolean find(int[][] array, int target){
        int row = 0;
        int nColumn = array[0].length - 1;
        while (row < array.length && nColumn >= 0){
            if (array[row][nColumn] == target)
                return true;
            else if (array[row][nColumn] > target)
                nColumn --;
            else
                row++;
        }
        return false;
    }
}
