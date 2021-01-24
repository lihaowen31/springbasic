package demo.pattern.abstractf;

import demo.pattern.entity.KeyBoard;
import demo.pattern.entity.Mouse;

public interface ComputerFactory {
    Mouse createMouse();
    KeyBoard createKeyboard();
}
