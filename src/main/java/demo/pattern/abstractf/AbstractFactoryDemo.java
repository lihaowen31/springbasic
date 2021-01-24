package demo.pattern.abstractf;

import demo.pattern.entity.KeyBoard;
import demo.pattern.entity.Mouse;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        ComputerFactory cf = new HpComputerFactory();
        Mouse mouse = cf.createMouse();
        KeyBoard keyBoard = cf.createKeyboard();
        mouse.sayHi();
        keyBoard.sayHello();
    }
}
