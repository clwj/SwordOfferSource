package examples.Questions.Problem12;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/22 10:25
 */
/**
 * 面试题12：打印1到最大的n位数
 * 输入数字n,按顺序打印出从1最大的n位十进制数。例如输入3，则打印出1,2,3,...,一直到最大的3位数即999。
 * 注意：没有限定n的范围时，注意大数问题，n可能会超出基本数值类型的表示范围，此时可以用字符串来表示，每一位上都是0-9的遍历，可以用递归。
 * 题外话：Java中有两个类BigInteger和BigDecimal分别表示大整数类和大浮点数类，理论上能表示无限大的数。
 */
public class Print1ToMaxOfNDigits {
    public void Print1toMax(int n){
        if (n<=0){
            System.out.println("输入有误");
            return;
        }
        StringBuffer s = new StringBuffer(n);
        for(int i = 0; i < n; i++){
            s.append('0');
        }
        for(int i = 0; i < 10; i++){

            s.setCharAt(0, (char) (i+'0'));
            Print1ToMaxOfNDigits_3_Recursely(s, n, 0);
        }


    }
    public static void Print1ToMaxOfNDigits_3_Recursely(StringBuffer s, int n , int index){
        if(index == n - 1){
            PrintNumber(s);
            return;
        }

        for(int i = 0; i < 10; i++){
            s.setCharAt(index+1, (char) (i+'0'));
            Print1ToMaxOfNDigits_3_Recursely(s, n, index+1);
        }
    }
    public static void PrintNumber(StringBuffer s){
        boolean isBeginning0 = true;
        for(int i = 0; i < s.length(); i++){
            if(isBeginning0 && s.charAt(i) != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(s.charAt(i));
            }
        }

        System.out.println();
    }
    public static void main(String[] args){
        Print1ToMaxOfNDigits print1ToMaxOfNDigits = new Print1ToMaxOfNDigits();
        print1ToMaxOfNDigits.Print1toMax(3);
    }
}
