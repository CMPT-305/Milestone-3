package TestPackage;

import Data.Searcher;
import static Data.Statistics.mean;
import static Data.Statistics.median;
import static Data.Statistics.n;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ryley
 */
public class MainTestWardFX extends Application {
    
    public void sortPrintedMapData(Map <String, Map<String, List<Double>>> map) {
        for (Map.Entry<String,Map<String, List<Double>>> entry: map.entrySet()) {
            System.out.println("=============================================");
            System.out.println(entry.getKey());
            for (Map.Entry<String, List<Double>> temp: entry.getValue().entrySet()) {
                System.out.println("\t"+temp.getKey());
                System.out.println("\t\t"+n(temp.getValue()));
                System.out.println("\t\t"+ mean(temp.getValue()));
            }
        }
    }
    
    @Override
    public void start(Stage primaryStage) {
        Searcher newSearcher = new Searcher("Property_Assessment_Data.csv");
        Map<String, Map<String, List<Double>>> sortedMap = newSearcher.getSortedMapByWard();
        
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
                /**
                System.out.println(sortedMap.keySet());
                sortedMap.forEach((k,v) -> System.out.println("key: " + k + ", value: " + v));
                */
                sortPrintedMapData(sortedMap);
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
