package demo.pattern.abstractf;

import demo.pattern.entity.KeyBoard;
import demo.pattern.entity.LenovoKeyboard;
import demo.pattern.entity.LenovoMouse;
import demo.pattern.entity.Mouse;

public class LenovoComputerFactory implements ComputerFactory{
    @Override
    public Mouse createMouse() {
        return new LenovoMouse();
    }

    @Override
    public KeyBoard createKeyboard() {
        return new LenovoKeyboard();
    }
}
