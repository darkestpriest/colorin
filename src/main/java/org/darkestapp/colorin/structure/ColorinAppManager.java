package org.darkestapp.colorin.structure;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * This class load the fxml file to the running environment.
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 26/10/16.
 */
public class ColorinAppManager {

    /**
     * Represents the main view
     */
    private final static String MAIN_FXML = "/fxml/Main.fxml";
    /**
     * Main parent from the view
     */
    private final Parent root;

    public ColorinAppManager() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(MAIN_FXML));
        root = loader.load();
    }

    /**
     * This method returns the main parent
     * @return the main parent for the app
     */
    public Parent getParent() {
        return root;
    }
}
