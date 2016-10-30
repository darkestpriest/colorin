package org.darkestapp.colorin.structure.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import org.darkestapp.colorin.structure.exceptions.ColorinLoggerException;
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

    /**
     * This method initializes the canvas and the graphic object in the DrawArea.
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        graphicsContext = canvas.getGraphicsContext2D();
        try{
            logger = new ColorinLogger("ColorinDAC.log");
        } catch (ColorinLoggerException e){
            e.printStackTrace();
            logger = new ColorinLogger();
        }

    }

    //Events methods
    @FXML
    /**
     * This method handles the MouseEvent on canvas described in {@link fxml.DrawArea}
     */
    private void handleMousePressed(MouseEvent mouseEvent) {
        System.out.println(mouseEvent);
        //TODO: improve the event to avoid drag over another object
    }

    /**
     * This method gets the coordinates from MouseEvent and returns a
     * {@link Point} object.
     * @param mouseEvent
     * @return
     */
    private Point getEventPoint(MouseEvent mouseEvent){
        return new Point(mouseEvent.getX(), mouseEvent.getY());
    }

}
