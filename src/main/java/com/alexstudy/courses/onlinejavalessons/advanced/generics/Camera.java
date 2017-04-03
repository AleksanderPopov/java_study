package com.alexstudy.courses.onlinejavalessons.advanced.generics;

import java.awt.*;

/**
 * Created by Alex on 4/1/2017.
 */
public class Camera extends Product<Camera> {
    Dimension dimension;

    @Override
    public int compareTo(Camera o) {
        return dimension.hashCode() | o.dimension.hashCode();
    }
}
