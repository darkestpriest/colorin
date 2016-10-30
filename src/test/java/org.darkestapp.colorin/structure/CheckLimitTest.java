package org.darkestapp.colorin.structure;

import javafx.scene.input.MouseEvent;
import org.darkestapp.colorin.mocks.MockMouseEvent;
import org.darkestapp.colorin.structure.controllers.DrawAreaController;
import org.darkestapp.colorin.structure.utils.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/10/16.
 */
public class CheckLimitTest {

    MouseEvent mockMouseEvent;

    @Before
    public void configureMouseEvent() {
        mockMouseEvent = new MockMouseEvent();
    }

    @Ignore
    public void checkValidLimits() {
        DrawAreaController drawAreaController = new DrawAreaController();
        drawAreaController.initialize(null, null);
        Point point = new Point(mockMouseEvent.getX(), mockMouseEvent.getY());
    }
}
