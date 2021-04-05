package cmpt305w21rg;

import UI.MainUIController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * NewFXMain - javafx main file that runs program
 * @author ryley
 */
public class NewFXMain extends Application {

    /**
     *
     */
    private AnchorPane anchorPane;

    /**
     * main - launch scene
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * start - main javafx scene
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Edmonton Property Assessments");
        initRootLayout();
        
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/UI/mainUI.css").toExternalForm());
        primaryStage.show();
    }
    
    /**
     * initRootLayout - used in implementation of controller class
     */
    private void initRootLayout() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainUIController.class.getResource("/UI/MainUI.fxml"));
        try {
            anchorPane = (AnchorPane)loader.load();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
