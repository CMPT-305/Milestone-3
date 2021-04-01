package TestPackage;

import Data.Searcher;
import java.util.List;
import java.util.Map;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javafx.scene.control.Hyperlink;
import UI.MainUIController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author ryley
 */
public class MainTestWard {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Searcher newSearcher = new Searcher("Property_Assessment_Data.csv");
        Map<String, Map<String, List<Double>>> sortedMap = newSearcher.getSortedMapByWard();
        System.out.println(sortedMap.keySet());
        sortedMap.forEach((k,v) -> System.out.println("key: " + k + ", value: " + v));
    }
}
