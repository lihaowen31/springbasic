package demo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取构造方法：
 *   1.批量获取
 *     public Constructor[] getConstructors(); 所有“公有的”构造方法
 *     public Constructor[] getDeclaredConstructors(); 获取所有的构造方法
 *   2.单个获取
 *     public Constructor getConstructor(Class...parameterTypes); 获取单个公有的构造方法
 *     public Constructor getDeclaredConstructor(Class...parameterTypes); 获取某个构造方法
 *
 * 调用构造方法
 *     Constructor --> newInstance(Object...initargs)
 */
public class ConstructorCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("demo.reflect.ReflectTarger");
        //1.获取所有的公有构造方法
        System.out.println("******************所有的公有构造方法********************");
        Constructor[] conArray = clazz.getConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        //2.获取所有的构造方法
        System.out.println("******************所有的构造方法(private、public、protected、默认)*****************");
        conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        //3.获取单个带参的公有构造方法
        System.out.println("******************获取公有、有两个参数的构造方法*************************");
        Constructor con = clazz.getConstructor(String.class, int.class);
        System.out.println("con:"+con);

        //4.获取单个私有的构造方法
        System.out.println("******************获取私有的构造方法********************");
        con = clazz.getDeclaredConstructor(int.class);
        System.out.println("private con : " + con);

        //5.创建ReflectTarger实例
        System.out.println("******************通过私有构造方法创建Targer实例***********************");
        con.setAccessible(true);//忽略访问修饰符
        ReflectTarger reflectTarger = (ReflectTarger) con.newInstance(5);

    }
}
