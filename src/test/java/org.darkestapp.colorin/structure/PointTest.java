package org.darkestapp.colorin.structure;

import javafx.scene.input.MouseEvent;

import org.darkestapp.colorin.mocks.MockMouseEvent;
import org.darkestapp.colorin.structure.utils.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 29/10/16.
 */
public class PointTest {

    MouseEvent mockMouseEvent;

    @Before
    public void configureMouseEvent() {
        mockMouseEvent = new MockMouseEvent();
    }

    /**
     * This test looks to test the equals method in Point Object
     */
    @Test
    public void equalsMethodPointTest() {
        Point expectedPoint = new Point(300, 200);
        Point eventPoint = new Point(mockMouseEvent.getX(), mockMouseEvent.getY());
        Assert.assertEquals(expectedPoint, eventPoint);
    }

    /**
     * This test looks to test the equals method in Point Object
     */
    @Test
    public void notEqualsMethodTest() {
        Point expectedPoint = new Point(300, 300);
        Point eventPoint = new Point(mockMouseEvent.getX(), mockMouseEvent.getY());
        Assert.assertNotEquals(expectedPoint, eventPoint);
    }
}
