package org.darkestapp.colorin;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.darkestapp.colorin.structure.ColorinAppManager;
import org.darkestapp.colorin.structure.utils.ColorinVersion;

/**
 * This is the main class to launch the app.
 * This app is a JavaFx app and uses Java 1.8, please, review the build.gradle
 * to see the dependencies.
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 26/10/16.
 * @version 1.0
 */
public class Main extends Application {

    private static String VERSION;

    public Main(){
        try {
            VERSION = ColorinVersion.getVersion();
        } catch (Exception e){
            VERSION = "";
        }

    }
    /**
     * This method must implements all the logic to launch the colorin app
     * using JavaFx software model.
     * @param primaryStage is the main stage when the app is working.
     * @throws Exception if any problem is happen when the start method is working.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Set the FXML file
        ColorinAppManager stressAppManager = new ColorinAppManager();
        Scene scene = new Scene(stressAppManager.getParent(), 500, 320);

        primaryStage.setTitle("Colorin App "+VERSION);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();
    }

    /**
     * Main method
     * @param args arguments to start the app
     */
    public static void main(String[] args) {
        System.out.println("* Colorin App "+VERSION+" - 2016 *");
        System.out.println("* Source code at http://github.com/darkestpriest/colorin *");
        //Launch the app
        launch(args);
    }
}
