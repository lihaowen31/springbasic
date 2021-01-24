package demo.pattern.method;

import demo.pattern.entity.LenovoMouse;
import demo.pattern.entity.Mouse;

public class LenovoMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }
}
