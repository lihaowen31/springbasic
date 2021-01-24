package demo.pattern.method;

import demo.pattern.entity.Mouse;

public class MethodFactoryDemo {
    public static void main(String[] args) {
        MouseFactory mf = new HpMouseFactory();
        Mouse mouse = mf.createMouse();
        mf = new LenovoMouseFactory();
        mouse = mf.createMouse();
        mouse.sayHi();
    }
}
