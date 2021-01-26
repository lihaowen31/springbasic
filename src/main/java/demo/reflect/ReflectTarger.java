package demo.reflect;

/**
 * 只有JVM才能创建java.lang.Class实例
 * 获取Class对象的三种方式,且三种方式获取的Class对象是完全相同的
 * 在运行期间, 一个类, 只有一个与之对应的Class对象产生
 */
public class ReflectTarger extends ReflectTargetOrigin{
    /**构造函数*/
    //1.默认的带参构造函数
    ReflectTarger(String str){
        System.out.println("默认的带参构造方法：" + str);
    }
    //2.无参构造函数
    public ReflectTarger(){
        System.out.println("公有的无参构造函数");
    }
    //3.公有带参构造函数
    public ReflectTarger(char name){
        System.out.println("公有的带参构造方法, 参数为：" + name);
    }
    //4.公有的多个参数的构造函数
    public ReflectTarger(String name, int index){
        System.out.println("调用了带有多个参数的公有构造方法，参数 name：" + name + ",index:" + index);
    }
    //5.受保护的带参构造函数
    protected ReflectTarger(boolean n){
        System.out.println("受保护的构造方法， n：" + n);
    }
    //6.私有的构造函数
    private ReflectTarger(int index){
        System.out.println("私有构造方法：" + index);
    }

    //字段
    public String name;
    protected int index;
    char type;
    private String targetInfo;

    //成员方法
    public void show1(String s){
        System.out.println("调用了公有的，参数为String的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了默认的，无参的show3()");
    }
    private String show4(int index){
        System.out.println("调用了私有的，并且有返回值的，参数为int类型的show4(), index = " + index);
        return "show4result";
    }

    @Override
    public String toString() {
        return "ReflectTarger{" +
                "name='" + name + '\'' +
                ", index=" + index +
                ", type=" + type +
                ", targetInfo='" + targetInfo + '\'' +
                '}';
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ReflectTarger target = new ReflectTarger();
        //方式一
        Class target1 = target.getClass();
        System.out.println("1st: " + target1.getName());
        //方式二
        Class target2 = ReflectTarger.class;
        System.out.println("2nd: " + target2.getName());
        //判断两种方式获取的class对象是否相同
        System.out.println(target1 == target2);
        //第三种方式获取
        Class target3 = Class.forName("demo.reflect.ReflectTarger");
        System.out.println("3rd: "+ target3.getName());
        System.out.println(target2 == target3);
    }
}
