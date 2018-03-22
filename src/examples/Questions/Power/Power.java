package examples.Questions.Power;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/22 9:10
 */
/**
 * 面试题11：数值的整数次方
 * 实现函数double Power(double base,int exponent)，求base的exponent次方，不得使用库函数，不用考虑大数问题。
 * 注意：判断两个小数是否相等不能用==，因为计算机表示小数有误差，我们只能判断它们差的绝对值是否在一个很小的范围内。
 * 题外话：程序错误处理的三种方法：返回值、全局变量、异常。返回值好处是根据返回值判断错误原因，缺点是函数只能返回一个值，使用不便。全局变量不会占用函数返回结果。异常更清晰明了，但有些语言不支持。
 */
public class Power {
    public double power(double base, int exponent) throws Exception{
        double result = 1.0;
        if (equal(base,0.0) && (exponent<0)){
            throw new Exception("0的负数次方无意思");
        }
        if (exponent == 0){    // 1或者0 的零次方 为0或者为1
            return 1.0;
        }
        if (exponent > 0){
            for (int i=0; i<exponent; i++){
                result  = result * base;
            }
            return result;
        }else{
            for (int i=0; i<-exponent; i++){
                result  = result * base;
            }
            return 1.0/result;
        }

    }
    private boolean equal(double dValue1, double dValue2){
        if (((dValue1-dValue2)<0.0000001) || ((dValue1-dValue2)>-0.0000001)){
            return true;
        }
        else return false;
    }
    public static void main(String[] args) throws Exception{
        Power power = new Power();
        System.out.println(power.power(2.0,4));
    }
}
