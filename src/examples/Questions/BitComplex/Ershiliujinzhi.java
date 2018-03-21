package examples.Questions.BitComplex;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/21 18:31
 */
/**
 * 相关题目3：进制转换问题，在Excel2003中，用A表示第一列，B表示第二列...Z表示第26列，AA表示第27列，AB表示第28列...依次列推。请写出一个函数，输入用字母表示的列号编码，输出它是第几列。
 * 相关题目4：如果反过来输入列数，求26进制表示呢？
 */
public class Ershiliujinzhi {

    public static void main(String[] args){
        Ershiliujinzhi ershiliujinzhi = new Ershiliujinzhi();
        System.out.println(ershiliujinzhi.countNum("AB"));
        System.out.println(ershiliujinzhi.numToStr(28));

    }

    public int countNum(String str){
        int count = 0;
        int length = str.length();
        int exp = 0;
        for (int i=length-1; i>=0; i--){
            count += (str.charAt(i)-'A'+1)*Math.pow(26,exp);
            exp++;
        }
        return count;
    }

    /**
     *  相关题目4：如果反过来输入列数，表示成字符串 AA AB
     * @param num
     * @return
     */
    public String numToStr(int num){
        StringBuilder sb = new StringBuilder();
        while (num != 0){
            int temp = num % 26;   //求最后一位数
            num = num / 26;     //求取倒数第二位数据
            if (temp == 0){     //如果最后一位数为0  需向前借一位
                num = num -1;
                temp = 26;
            }
            sb.append((char)(temp+'A'-1));
        }
        //字符串为倒叙
        return sb.reverse().toString();
    }
}
