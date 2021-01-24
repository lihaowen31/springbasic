package demo.pattern.method;

import demo.pattern.entity.DellMouse;
import demo.pattern.entity.Mouse;

public class DellMouseFactory implements MouseFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }
}
