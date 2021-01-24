package demo.pattern.simple;

import demo.pattern.entity.DellMouse;
import demo.pattern.entity.HpMouse;
import demo.pattern.entity.LenovoMouse;
import demo.pattern.entity.Mouse;

public class MouseFactory {
    public static Mouse createMouse(int type){
        switch (type){
            case 1:
                return new HpMouse();
            case 2:
                return new DellMouse();
            case 3:
                return new LenovoMouse();
            default:
                return new DellMouse();
        }
    }

    public static void main(String[] args) {
        Mouse mouse = MouseFactory.createMouse(1);
        mouse.sayHi();
    }
}
