package com.alexstudy.courses.golovatch.java_core_october_2013.oop.examples.callback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 3/26/2017.
 */
public class Example {
}

class Mouse {
    static void addListener(MouseListener listener) {}
}
interface MouseListener {
    void mouseMoved(int newX, int newY);

}
class Menu implements MouseListener {

    public Menu() {
        Mouse.addListener(this);
    }
    @Override
    public void mouseMoved(int newX, int newY) {
        // do something...
    }
}

class Menu2 {
    public Menu2() {
        Mouse.addListener(new MouseListener() {
            @Override
            public void mouseMoved(int newX, int newY) {
                mouseEventX(newX);
                mouseEventY(newY);
            }
        });
    }

    public void mouseEventX(int newX) {
        // do something...
    }
    public void mouseEventY(int newY) {
        // do something...
    }
}
