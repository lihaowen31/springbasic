package demo.pattern.method;

import demo.pattern.entity.HpMouse;
import demo.pattern.entity.Mouse;

public class HpMouseFactory implements MouseFactory {

    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }
}
