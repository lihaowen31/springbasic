package demo.pattern.abstractf;

import demo.pattern.entity.HpKeyboard;
import demo.pattern.entity.HpMouse;
import demo.pattern.entity.KeyBoard;
import demo.pattern.entity.Mouse;

public class HpComputerFactory implements ComputerFactory{
    @Override
    public Mouse createMouse() {
        return new HpMouse();
    }

    @Override
    public KeyBoard createKeyboard() {
        return new HpKeyboard();
    }
}
