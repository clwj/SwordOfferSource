package examples.Questions.QueSingleTon;

/**
 * @Author Wenjian Lu
 * @Date 2018/3/16 15:33
 * 单利模式实现
 */
/**
 * 面试题2：写一个单例模式。
 * 单例模式有以下特点：1，单例类只能有一个实例。
 * 2，单例类必须自己创建自己的唯一实例。
 * 3，单例类必须给所有其它对象提供这一实例。
 * 总之，选择单例模式为了避免不一致状态，如打印机。
 *
 */
//以下是一种饿汉式写法：在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的,缺点是占用内存。
//具体的：1，定义一个类，构造函数是private的。
//2，这个类有一个private static final的该类变量，在类初始化时实例化。
//3，通过一个public static的getInstance方法获取变量的引用，继而调用它的方法。
public class SingleTon {
    private static final SingleTon instance = new SingleTon();
    private SingleTon(){

    }
    public static SingleTon getInstance(){
        return instance;
    }

}
