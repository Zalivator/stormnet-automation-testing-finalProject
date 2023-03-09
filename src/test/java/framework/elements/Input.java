package framework.elements;

import org.openqa.selenium.By;

public class Input extends BaseElement{
    public Input(By by) {
        super(by);
    }

    public Input(By by, String name) {
        super(by, name);
    }

    @Override
    protected String getElementType() {
        return "Input";
    }
}
