package com.acts.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotEqualTo("Cube")
                .isNotEmpty()
                .isEqualTo("Sphere");
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(3, 10);
        String name = box.whatsThis();
        assertThat(name).isNotEmpty()
                .containsWhitespaces()
                .isEqualTo("Unknown object");
    }

    @Test
    void whenVertex4ThenVertices4() {
        Box box = new Box(4, 10);
        int count = box.getNumberOfVertices();
        assertThat(count).isEven()
                .isPositive()
                .isEqualTo(4);
    }

    @Test
    void figureExists() {
        Box box = new Box(4, 10);
        boolean result = box.isExist();
        assertThat(result).isEqualTo(true)
                .isTrue();
    }

    @Test
    void sphereArea() {
        Box box = new Box(4, 10);
        double result = box.getArea();
        assertThat(result).isNotZero()
                .isBetween(100.0, 200.0)
                .isEqualTo(173.205, withPrecision(0.01));
    }

    @Test
    void noFigureArea() {
        Box box = new Box(3, 10);
        double result = box.getArea();
        assertThat(result).isNotNaN()
                .isZero();
    }
}
