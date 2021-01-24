package demo.pattern.method;

import demo.pattern.entity.IBMMouse;
import demo.pattern.entity.Mouse;

public class IBMMouseFactory extends LenovoMouseFactory{
    @Override
    public Mouse createMouse(){
        return new IBMMouse();
    }
}
