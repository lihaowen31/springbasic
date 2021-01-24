package demo.pattern.abstractf;

import demo.pattern.entity.DellKeyboard;
import demo.pattern.entity.DellMouse;
import demo.pattern.entity.KeyBoard;
import demo.pattern.entity.Mouse;

public class DellComputerFactory implements ComputerFactory{
    @Override
    public Mouse createMouse() {
        return new DellMouse();
    }

    @Override
    public KeyBoard createKeyboard() {
        return new DellKeyboard();
    }
}
