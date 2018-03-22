package examples.Questions.Problem12;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/22 11:33
 */
public class PrintToMaxOfDigits {
    public void Print1toMax(int n){
        if (n <= 0){
            System.out.println("输入数据有误");
            return;
        }
        StringBuffer sb = new StringBuffer(n);
        for (int i=0; i<n; i++){
            sb.append('0');
        }
        for (int j=0; j<10; j++){
            sb.setCharAt(0,(char)(j+'0'));
            Print1ToMaxOfNDigits_3_Recursely(sb,n,1);
        }
    }

    private void Print1ToMaxOfNDigits_3_Recursely(StringBuffer sb, int n, int index){
        if (index == n){
          //  System.out.println(sb.toString());
            //
            printNumber(sb);
            return;
        }
        for (int i=0; i<10; i++){
            sb.setCharAt(index,(char)(i+'0'));
            Print1ToMaxOfNDigits_3_Recursely(sb,n,index+1);
        }
    }

    private void printNumber(StringBuffer sb){
        boolean isBegin0 = true;
        for (int i=0; i<sb.length(); i++){
            if (isBegin0 && (sb.charAt(i) != '0')){
                isBegin0 = false;
            }
            if (!isBegin0){
                System.out.print(sb.charAt(i));
            }
        }
        System.out.println("");
    }

    public static void main(String[] args){
        PrintToMaxOfDigits printToMaxOfDigits = new PrintToMaxOfDigits();
        printToMaxOfDigits.Print1toMax(2);
    }
}
