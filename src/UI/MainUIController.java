package UI;

import Data.Data;
import Data.FilterAccount;
import Data.FilterAddress;
import Data.FilterAssessmentClass;
import Data.FilterNeighbourhood;
import Data.FilterWard;
import Data.FindAccount;
import Data.Searcher;
import Data.Statistics;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import static java.util.Objects.isNull;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * MainUIController - implements javafx fxml file with data
 * @author Ryley and Mario
 */
public class MainUIController implements Initializable {
    Searcher newSearcher = new Searcher();
    @FXML private TableView<Data> tableAssessment;
    @FXML private TableColumn<Data, Integer> accountNumber;
    @FXML private TableColumn<Data, String> address;
    @FXML private TableColumn<Data, String> assessedValue;
    @FXML private TableColumn<Data, String> assessmentClass;
    @FXML private TableColumn<Data, String> neighbourhood;
    @FXML private TableColumn<Data, String> ward;
    @FXML private TableColumn<Data, Double> latitude;
    @FXML private TableColumn<Data, Double> longitude;
    @FXML private TableColumn<Data, Hyperlink> mapButtonCol;
    
    @FXML private TextField inputAccount;
    @FXML private TextField inputAddress;
    @FXML private TextField inputNeighbourhood;
    @FXML private ChoiceBox<String> inputAssessmentClass;
    @FXML private ChoiceBox<String> inputWard;
    @FXML private Button btnSearch;
    @FXML private Button btnReset;
    @FXML private TextArea statText;
    
    public List<Data> masterData = new ArrayList<>(newSearcher.getAllAccounts());
    public Map<Integer, Data> map = new HashMap<>(newSearcher.getAllAccountsM());
    public ObservableList<Data> listData = FXCollections.observableArrayList(masterData);
    
    /**
     * initialize - initializes the tableAssessment for FXML
     * create
     * @param location
     * @param resources
     */
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // ward button search
        inputWard.getItems().removeAll(inputWard.getItems());
        inputWard.getItems().addAll(newSearcher.showWard());
        
        // assessment class button search
        inputAssessmentClass.getItems().removeAll(inputAssessmentClass.getItems());
        inputAssessmentClass.getItems().addAll(newSearcher.showAssessmentClass());
        
        // column data
        accountNumber.setCellValueFactory(new PropertyValueFactory<>("accountNumber"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        assessedValue.setCellValueFactory(new PropertyValueFactory<>("assessedValue"));
        assessmentClass.setCellValueFactory(new PropertyValueFactory<>("assessmentClass"));
        neighbourhood.setCellValueFactory(new PropertyValueFactory<>("neighbourhood"));
        ward.setCellValueFactory(new PropertyValueFactory<>("ward"));
        latitude.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        longitude.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        mapButtonCol.setCellValueFactory(new PropertyValueFactory<>("hyperlink"));

        showStats(masterData);
        tableAssessment.setItems(listData);
    }

    /**
     * listSort - performs button action and sorts the table object.
     * sorts from multiple input sources:
     * - inputAccount = account number
     * - inputAssessmentClass = assessment class
     * - inputNeighbourhood = neighbourhood
     * - inputAddress = address
     * And finds matching account numbers and stores them into set.
     * The searched items are found in a list using the retainedSet and map
     * @param event
     */
    @FXML
    void listSort(ActionEvent event) {
        List<Data> filter = new ArrayList<>(tableAssessment.getItems());
        ObservableList<Data> sortedData = FXCollections.observableArrayList();
        Set<Integer> a, b, c, d, e;
        Set<Integer> acceptedSet;
        
        FindAccount findAccount = new FindAccount();
        
        if (inputAccount.getText().isEmpty()) {
            acceptedSet = new HashSet<>(newSearcher.getSetAccounts(filter));
            String tempAssessmentClass = inputAssessmentClass.getValue();
            String tempWard = inputWard.getValue();
            if (isNull(tempAssessmentClass) || tempAssessmentClass.isEmpty()) {
            } else {
                FilterAssessmentClass filteredAssessmentClass = new FilterAssessmentClass();
                b = new HashSet<>(filteredAssessmentClass.search(filter, tempAssessmentClass));
                acceptedSet.retainAll(b);
            }
            if (isNull(tempWard) || tempWard.isEmpty()) {
            } else {
                FilterWard filteredWard = new FilterWard();
                c = new HashSet<>(filteredWard.search(filter, tempWard));
                acceptedSet.retainAll(c);
            }
            if (inputNeighbourhood.getText().isEmpty()) {
            } else {
                FilterNeighbourhood filteredNeighbourhood = new FilterNeighbourhood();
                d = new HashSet<>(filteredNeighbourhood.search(filter, inputNeighbourhood.getText()));
                acceptedSet.retainAll(d);
            }
            if (inputAddress.getText().isEmpty()) {
            } else {
                FilterAddress filteredAddress = new FilterAddress();
                e = new HashSet<>(filteredAddress.search(filter, inputAddress.getText()));
                acceptedSet.retainAll(e);
            }
        } else {
            acceptedSet = new HashSet<>(newSearcher.getSetAccounts(masterData));
            FilterAccount filteredAccount = new FilterAccount();
            a = new HashSet<>(filteredAccount.search(masterData, inputAccount.getText()));
            acceptedSet.retainAll(a);
            inputAddress.setText("");
            inputNeighbourhood.setText("");
            inputWard.setValue("");
            inputAssessmentClass.setValue("");
        }
        List<Data> tempArray = new ArrayList<>(findAccount.find(map, acceptedSet));
        showStats(tempArray);
        sortedData = FXCollections.observableArrayList(tempArray);
        tableAssessment.setItems(sortedData);
    }

    /**
     * listReset - resets the list
     * @param event
     */
    @FXML
    void listReset(ActionEvent event) {
        inputAccount.setText("");
        inputAddress.setText("");
        inputNeighbourhood.setText("");
        inputWard.setValue("");
        inputAssessmentClass.setValue("");
        showStats(masterData);
        tableAssessment.setItems(listData);
    }

    
   
    
    /**
     * showStats - takes a data list and prints out the statistics.
     * @param data
     */
    public void showStats(List<Data> data) {
        if (data.size() > 1) {
            List<Double> temp = new ArrayList<>(getAssessedValue(data));
            statText.setText(getStatistics(temp));
        } else {
            statText.setText("");
        }
    }

    /**
     * getAssessedValue - takes an ArrayList data and takes the assessed values
     * and stores them into a double list
     * @param data
     * @return double list
     */
    public static List<Double> getAssessedValue(List<Data> data) {
        List<Double> temp = new ArrayList<>();
        for (Data entry : data) {
            temp.add(entry.getAssessedValueDouble());
        }
        return temp;
    }

    /**
     * getStatistics - prints out the assessment list in correct format
     * @param data List Double
     * @return new String of statistics
     */
    public String getStatistics(List<Double> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Statistics of Assessed Values:\n");
        stringBuilder.append("\nNumber of properties: " + Statistics.n(data));
        stringBuilder.append("\nMin: $" + String.format("%,2d", (int) Statistics.min(data)));
        stringBuilder.append("\nMax: $" + String.format("%,2d", (int) Statistics.max(data)));
        stringBuilder.append("\nRange: $" + String.format("%,2d", (int) Statistics.range(data)));
        stringBuilder.append("\nMean: $" + String.format("%,2d", (int) Statistics.mean(data)));
        stringBuilder.append("\nMedian: $" + String.format("%,2d", (int) Statistics.median(data)));
        stringBuilder.append("\nStandard deviation: $" + String.format("%,2d", (int) Statistics.stdev(data)));

        String str = stringBuilder.toString();
        return str;
    }
}
