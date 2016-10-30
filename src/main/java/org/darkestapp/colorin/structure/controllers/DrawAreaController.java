package org.darkestapp.colorin.structure.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import org.darkestapp.colorin.structure.utils.ColorinLogger;
import org.darkestapp.colorin.structure.utils.Point;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the controller for the draw area
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 26/10/16.
 * @version 1.0
 */
public class DrawAreaController implements Initializable {

    //FXML objects
    /**
     * This is the are where we will build the images
     */
    @FXML
    Canvas canvas;

    //Class objects
    /**
     * This is the graphic context to
     */
    private GraphicsContext graphicsContext;
    private ColorinLogger logger;

    private static final String LOGGER_FILE = "ColorinDAC.log";
    private static double CANVAS_WIDTH;
    private static double CANVAS_HEIGHT;
    private static final double CANVAS_MIN = 0;
    //This values is hardoced in this version
    private static double X_CIRCLE_SIZE = 10;
    private static double Y_CIRCLE_SIZE = 10;

    /**
     * This method initializes the canvas and the graphic object in the DrawArea.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        graphicsContext = canvas.getGraphicsContext2D();
        CANVAS_HEIGHT = canvas.getHeight();
        CANVAS_WIDTH = canvas.getWidth();
        logger = ColorinLogger.getColorinLogger();

    }

    //Events methods
    @FXML
    /**
     * This method handles the MouseEvent on canvas described in {@link fxml.DrawArea}
     */
    private void handleMousePressed(MouseEvent mouseEvent) {
        drawPoint(mouseEvent);
    }

    private void drawPoint(MouseEvent mouseEvent){
        //We only need to proceed if the Primary button is pressed
        if(!mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            return;
        }
        Point mouseCoordinates = getEventPoint(mouseEvent);
        if(!checkPoint(mouseCoordinates)){
            return;
        }
        graphicsContext.fillOval(
                mouseCoordinates.getX(),
                mouseCoordinates.getY(),
                X_CIRCLE_SIZE,
                Y_CIRCLE_SIZE);

    }

    /**
     * This method gets the coordinates from MouseEvent and returns a
     * {@link Point} object.
     * @param mouseEvent
     * @return
     */
    private Point getEventPoint(MouseEvent mouseEvent) {
        return new Point(mouseEvent.getX(), mouseEvent.getY());
    }

    /**
     * This method checks if a coordinate is in the limits allowed by the canvas.
     * @param coordinate
     * @param maxReference
     * @return
     */
    private boolean checkCoordinate(double coordinate, double maxReference) {
        return coordinate >= CANVAS_MIN && coordinate <= maxReference;
    }

    /**
     * This method checks if a point is in the allowed limits.
     * @param point
     * @return
     */
    private boolean checkPoint(Point point) {
        boolean isXAllowed = checkCoordinate(point.getX(), CANVAS_WIDTH);
        boolean isYAllowed = checkCoordinate(point.getY(), CANVAS_HEIGHT);
        return isXAllowed && isYAllowed;
    }

}
