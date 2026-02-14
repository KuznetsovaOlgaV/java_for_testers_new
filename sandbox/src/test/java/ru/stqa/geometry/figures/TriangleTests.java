package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea(){
        var result = Triangle.area(5.0,7.0,11.0);
        Assertions.assertEquals(12.968712349342937, result);

    }
    @Test
    void canCalculatePerimetr(){
        Assertions.assertEquals(23, Triangle.perimetr(5.0,7.0,11.0));
    }

}
