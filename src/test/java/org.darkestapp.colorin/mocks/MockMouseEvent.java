package org.darkestapp.colorin.mocks;

import javafx.beans.NamedArg;
import javafx.event.EventType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 30/10/16.
 */
public class MockMouseEvent extends MouseEvent {

    //Default class values.
    private static final EventType<MouseEvent> MOCK_EVENT = MouseEvent.DRAG_DETECTED;
    private static final double MOCK_X = 300;
    private static final double MOCK_Y = 200;
    private static final double MOCK_DOUBLE_SCREEN_X = 0;
    private static final double MOCK_DOUBLE_SCREEN_Y = 0;
    private static final MouseButton MOCK_BUTTON = MouseButton.PRIMARY;
    private static final int MOCK_CLICK_COUNT = 1;
    private static final boolean MOCK_SHIFT_DOWN = false;
    private static final boolean MOCK_CONTROL_DOWN = false;
    private static final boolean MOCK_ALT_DOWN = false;
    private static final boolean MOCK_META_DOWN = false;
    private static final boolean MOCK_PRIMARY_BUTTON_DOWN = false;
    private static final boolean MOCK_MIDDLE_BUTTON_DOWN = false;
    private static final boolean MOCK_SECONDARY_BUTTON_DOWN = false;
    private static final boolean MOCK_SYNTHESIZED = false;
    private static final boolean MOCK_POPUP_TRIGGER = false;
    private static final boolean MOCK_STILL_PRESSED = false;
    private static final PickResult MOCK_PICK_RESULT = null;

    /**
     * This constructor constructs a {@link MouseEvent} mock with default values.
     * Please, check the defaults values in the class variables declaration.
     */
    public MockMouseEvent() {
        super(
                MOCK_EVENT,
                MOCK_X,
                MOCK_Y,
                MOCK_DOUBLE_SCREEN_X,
                MOCK_DOUBLE_SCREEN_Y,
                MOCK_BUTTON,
                MOCK_CLICK_COUNT,
                MOCK_SHIFT_DOWN,
                MOCK_CONTROL_DOWN,
                MOCK_ALT_DOWN,
                MOCK_META_DOWN,
                MOCK_PRIMARY_BUTTON_DOWN,
                MOCK_MIDDLE_BUTTON_DOWN,
                MOCK_SECONDARY_BUTTON_DOWN,
                MOCK_SYNTHESIZED,
                MOCK_POPUP_TRIGGER,
                MOCK_STILL_PRESSED,
                MOCK_PICK_RESULT);
    }
}
