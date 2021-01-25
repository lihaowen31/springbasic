package demo.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 获取成员变量并调用：
 * 1.批量
 *   Field[] getFields(); 获取所有公有字段
 *   Field[] getDeclaredFields(); 获取所有字段，不包括继承字段
 * 2.单个
 *   Field getField(String fieldName);
 *   Field getDeclaredField(String fieldName)  获取指定name的字段，但不包括继承字段
 *
 * 设置字段的值
 *  Field --> public void set(Object obj, Object valud)
 *
 */
public class FieldCollector {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取Class对象
        Class clazz = Class.forName("demo.reflect.ReflectTarger");
        //获取所有公有的字段
        System.out.println("**************获取所有的公有字段****************");
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            System.out.println(f);
        }
        //2.获取所有的字段
        System.out.println("**************获取所有的字段****************");
        fields = clazz.getDeclaredFields();
        for (Field f : fields){
            System.out.println(f);
        }
        //3.获取单个特定的公有字段
        System.out.println("*************获取特定公有字段***************");
        Field field = clazz.getField("name");
        //4.为字段设置值，首先要实例化ReflectTarger
        ReflectTarger reflectTarger = (ReflectTarger) clazz.getConstructor().newInstance();
        field.set(reflectTarger,"反射字段");
        //5.验证值
        System.out.println("验证name：" + reflectTarger.name);
        //6.获取单个私有的Field
        System.out.println("*************获取单个私有的Field****************");
        field = clazz.getDeclaredField("targetInfo");
        System.out.println(field);
        field.setAccessible(true);
        field.set(reflectTarger,"私有的字段");
        System.out.println(reflectTarger);
    }
}
