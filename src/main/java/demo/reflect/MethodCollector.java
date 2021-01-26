package demo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 获取成员方法并调用：
 * 1.批量的：
 *   public Method[] getMethods(); 获取所有“公有方法”（包含了父类的方法也包含Object类）
 *   public Method[] getDeclaredMethods(); 获取所有的成员方法，包括私有的（不包括继承的）
 * 2.获取单个的
 *   public Method getMethod(String name,Class<?>...parameterTypes);
 *       name: 方法名
 *       Class...:形参的Class类型对象
 *   public Method getDeclaredMethod(String name,Class<?>...parameterTypes)
 *
 * 调用方法：
 *   Method --> public Object invoke(Object obj, Object... args):
 *       obj: 方法所在的二类
 *       args:实参
 *
 *
 */
public class MethodCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class clazz = Class.forName("demo.reflect.ReflectTarger");
        System.out.println("获取所有公有方法");
        Method[] methodArr = clazz.getMethods();
        for (Method m : methodArr){
            System.out.println(m);
        }
        //获取该类的所有方法
        System.out.println("获取该类的所有方法");
        methodArr = clazz.getDeclaredMethods();
        for(Method m : methodArr){
            System.out.println(m);
        }
        //获取单个公有方法
        System.out.println("获取单个公有方法");
        Method method1 = clazz.getMethod("show1", String.class);
        System.out.println(method1);
        //调用show1并执行
        ReflectTarger reflectTarger = (ReflectTarger) clazz.getConstructor().newInstance();
        method1.invoke(reflectTarger, "方法一");
        //获取私有的成员方法
        System.out.println("获取私有的成员方法");
        method1 = clazz.getDeclaredMethod("show4", int.class);
        System.out.println(method1);
        method1.setAccessible(true);
        String result = (String) method1.invoke(reflectTarger, 4);
        System.out.println(result);
    }
}
