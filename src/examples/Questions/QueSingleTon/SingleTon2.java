package examples.Questions.QueSingleTon;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/16 15:51
 */
public class SingleTon2 {
    private SingleTon2(){}
    private static SingleTon2 singleTon2 = null;
    //用于线程安全
    public static synchronized SingleTon2 getInstance(){
        if (singleTon2 == null)
            singleTon2 = new SingleTon2();
        return singleTon2;
    }

}
