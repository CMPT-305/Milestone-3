package Data;

import java.io.*;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Creates the Data object list and populates it from a csv file
 * Searches through Data list
 * @author ryley
 */
public class Searcher {
    private List<Data> data;
    private List<CensusData> censusData;
    // private String FILENAME = "Test_Data.csv";
    private String FILENAME = "Property_Assessment_Data.csv";
    private String censusFile = "2016_Census_-_Population_by_Household_Income__Neighbourhood_Ward_.csv";
    
    /**
     * Searcher - takes string filename and creates Data object
     * @param filename
     */
    public Searcher(String filename) {
        try (Scanner sc = new Scanner(new File(filename))) {
            data = new ArrayList<>();
            boolean first = true;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (first) {
                    first=false;
                } else {
                    data.add(new Data(line));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read data from file: "+filename);
        }
        
        try (Scanner sc = new Scanner(new File(filename))) {
            censusData = new ArrayList<>();
            boolean first = true;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (first) {
                    first=false;
                } else {
                    censusData.add(new CensusData(line));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot read data from file: "+filename);
        }
    }
    
    /**
     * Searcher - contains the default filename as input and creates the data
     * list
     */
    public Searcher() {
        try (Scanner sc = new Scanner(new File(FILENAME))) {
            data = new ArrayList<>();
            boolean first = true;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (first) {
                    first=false;
                } else {
                    data.add(new Data(line));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't read the file.");
        }
        
        try (Scanner sc = new Scanner(new File(censusFile))) {
            censusData = new ArrayList<>();
            boolean first = true;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (first) {
                    first=false;
                } else {
                    censusData.add(new CensusData(line));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't read the file.");
        }
        
        
    }
    
    //==========================================================================
    // HELPER METHODS
    //==========================================================================
    
    /**
     * checkIfInteger - checks a string if its an integer
     * @param str
     * @return true/false
     */
    public static boolean checkIfInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException fe) {
            return false;
        }
    }
    
    /**
     * checkIfDouble - checks if string input is double
     * @param str
     * @return true/false
     */
    public static boolean checkIfDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException fe) {
            return false;
        }
    }
    
    /**
     * inputInteger - asks for user input and first checks if input is as an
     * integer, if that is true it checks if the inputted integer exists within
     * the given list, and returns the integer if true
     * @param list Integer List
     * @return -1 if not found, otherwise returns the input
     */
    public int inputInteger(List<Integer> list) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int ele = -1;
        System.out.println("Enter an account number id: ");
        input = scanner.nextLine();
        while(!checkIfInteger(input)) {
            System.out.println(input+" is not a valid input.");
            System.out.println("Enter an account number id: ");
            input = scanner.nextLine();
        }
        ele = Integer.parseInt(input);
        if(checkIfInputIsCorrectL(list, ele)) {
            return ele;
        }
        return -1;
    }
    
    /**
     * inputString - continue asking for input until user gives matching input
     * @param set From set of values
     * @param name identifier of string
     * @return string input that will perform calculations
     */
    public static String inputString(Set<String> set, String name) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println("Enter a "+name+" value as input: ");
        input = scanner.nextLine();
        while(!checkIfInputIsCorrect(set, input)) {
            System.out.println(input+": is not a valid input in "+name+".");
            System.out.println("Enter a "+name+" value as input: ");
            input = scanner.nextLine();
        }
        return input;
    }
    
    /**
     * checkIfInputIsCorrect - takes a string set and checks against input
     * if true, then the input is of a correct type, otherwise false
     * @param set String Set
     * @param input String input
     * @return true/false
     */
    public static boolean checkIfInputIsCorrect(Set<String> set, String input) {
        if(set.contains(input.toUpperCase())) {
            return true;
        }
        return false;
    }
    
    /**
     * checkIfInputIsCorrectL - takes an integer set and checks against input
     * if true, then the input exists in the list, otherwise false
     * @param list Integer List
     * @param input int input
     * @return true/false
     */
    public static boolean checkIfInputIsCorrectL(List<Integer> list, int input) {
        return list.contains(input);
    }
    
    /**
     * getAssessment - takes a Data list and returns a double list filled with
     * the assessed values
     * @param data List Data
     * @return dList Double List
     */
    public static List<Double> getAssessment(List<Data> data) {
        List<Double> dList = new ArrayList<>();
        for(Data entry: data) {
            dList.add(entry.getAssessedValueDouble());
        }
        return dList;
    }
    
    /**
     * getStatistics - prints out the assessment list in correct format
     * @param data List Double
     */
    public static void getStatistics(List<Double> data) {
        System.out.println("n = "+Statistics.n(data));
        System.out.println("min = $"+String.format("%,.2f", Statistics.min(data)));
        System.out.println("max = $"+String.format("%,.2f", Statistics.max(data)));
        System.out.println("range = $"+String.format("%,.2f", Statistics.range(data)));
        System.out.println("mean = $"+String.format("%,.2f", Statistics.mean(data)));
        System.out.println("sd = $"+String.format("%,.2f", Statistics.stdev(data)));
        System.out.println("median = $"+String.format("%,.2f", Statistics.median(data)));
    }
    
    //==========================================================================
    // MENU HELPER METHODS
    //==========================================================================
    
    // SHOW CURRENT VALUES IN STREAM
    /**
     * menuUtilShowAccount - displays all account ids
     */
    public void menuUtilShowAccount() {System.out.println(showAccount());}
    /**
     * menuUtilShowSuite - displays all suites
     */
    public void menuUtilShowSuite() {System.out.println(showSuite());}
    /**
     * menuUtilShowNeighbourhood - displays all neighbourhoods
     */
    public void menuUtilShowNeighbourhood() {System.out.println(showNeighbourhood());}
    /**
     * menuUtilShowWard - displays all wards
     */
    public void menuUtilShowWard() {System.out.println(showWard());}
    /**
     * menuUtilShowAssessmentClass - displays all assessment classes
     */
    public void menuUtilShowAssessmentClass() {System.out.println(showAssessmentClass());}
    
    // PRINT ACCOUNT
    /**
     * menuUtilPrintAccount - gets the account number from the data list
     */
    public void menuUtilPrintAccount() {
        List<Integer> tempList = new ArrayList<>();
        tempList = showAccount();
        int acct = inputInteger(tempList);
        if(acct==-1) {
            System.out.println("The input was incorrect.");
        } else {
            System.out.println(getAccount(acct));
        }
    }
    
    // PRINT STATISTICS (String input)
    /**
     * menuUtilPrintNeighbourhoodStats - prints all statistics of neighbourhood
     * entered by user input
     */
    public void menuUtilPrintNeighbourhoodStats() {
        Set<String> tempSet = new HashSet<>();
        tempSet = showNeighbourhood();
        String str = inputString(tempSet, "Neighbourhood");
        List<Data> newData = new ArrayList<>();
        newData = getAccountsInNeighbourhood(str);
        List<Double> assess = new ArrayList<>();
        assess = getAssessment(newData);
        System.out.println("Statistics (Neighbourhood = "+str+")");
        getStatistics(assess);
    }
    /**
     * menuUtilPrintWardStats - prints all statistics of ward from inputted
     * value by a user.
     */
    public void menuUtilPrintWardStats() {
        Set<String> tempSet = new HashSet<>();
        tempSet = showWard();
        String str = inputString(tempSet, "Ward");
        List<Data> newData = new ArrayList<>();
        newData = getAccountsInWard(str);
        List<Double> assess = new ArrayList<>();
        assess = getAssessment(newData);
        System.out.println("Statistics (Ward = "+str+")");
        getStatistics(assess);
    }
    /**
     * menuUtilPrintAssessmentClassStats - prints all statistics of assessment
     * classes from inputted name by user.
     */
    public void menuUtilPrintAssessmentClassStats() {
        Set<String> tempSet = new HashSet<>();
        tempSet = showAssessmentClass();
        String str = inputString(tempSet, "Assessment Class");
        List<Data> newData = new ArrayList<>();
        newData = getAccountsInAssessmentClass(str);
        List<Double> assess = new ArrayList<>();
        assess = getAssessment(newData);
        System.out.println("Statistics (Assessment Class = "+str+")");
        getStatistics(assess);
    }
    
    // ACCEPTS NO USER INPUT
    /**
     * menuUtilPrintWithGarageStats - prints all statistics of assessment value
     * for properties with garages
     */
    public void menuUtilPrintWithGarageStats() {
        List<Data> newData = new ArrayList<>();
        newData = getAccountsWithGarage();
        List<Double> assess = new ArrayList<>();
        assess = getAssessment(newData);
        System.out.println("Statistics (Garage = Yes)");
        getStatistics(assess);
    }
    /**
     * menuUtilPrintWithoutGarageStats - prints all statistics of assessment
     * value for properties without garages
     */
    public void menuUtilPrintWithoutGarageStats() {
        List<Data> newData = new ArrayList<>();
        newData = getAccountsWithoutGarage();
        List<Double> assess = new ArrayList<>();
        assess = getAssessment(newData);
        System.out.println("Statistics (Garage = No)");
        getStatistics(assess);
    }
    /**
     * menuUtilPrintAllStats - prints all statistics of all properties found in
     * data list
     */
    public void menuUtilPrintAllStats() {
        List<Data> newData = new ArrayList<>();
        newData = getAllAccounts();
        List<Double> assess = new ArrayList<>();
        assess = getAssessment(newData);
        System.out.println("Descriptive Statistics of all property assessments");
        getStatistics(assess);
    }
    
    //==========================================================================
    // SEARCHER LIST METHODS
    //==========================================================================
    /**
     * getAccount - takes an account number and returns the matching account
     * if no matching account return null
     * @param acct
     * @return accountNumber, else null
     */
    public Data getAccount(int acct) {
        for (Data entry: data) {
            if (entry.equals(acct))
                return entry;
        }
        return null;
    }
    
    /**
     * showAccount - gets all account numbers stored in data list, and shows them
     * to the user in the menu.
     * @return account - Integer List
     */
    public List<Integer> showAccount() {
        List<Integer> account = new ArrayList<>();
        for (Data entry:data) {
            account.add(entry.getAccountNumber());
        }
        return account;
    }
    
    /**
     * getSetAccounts - gets all set values for the account number and returns it
     * as an integer set
     * @return Set Integer
     */
    public Set<Integer> getSetAccounts() {
        Set<Integer> account = new HashSet<>();
        for (Data entry:data) {
            account.add(entry.getAccountNumber());
        }
        return account;
    }
    
    /**
     * getSetAccounts - gets all set values for the account number and returns it
     * as an integer set
     * @param list - inputted list
     * @return Set Integer
     */
    public Set<Integer> getSetAccounts(List<Data> list) {
        Set<Integer> account = new HashSet<>();
        for (Data entry:list) {
            account.add(entry.getAccountNumber());
        }
        return account;
    }
    
    /**
     * getAccountsInSuite - searches through data and finds all matching Data
     * objects with same suite and adds into new Data List
     * @param suite
     * @return account - Data list
     */
    public List<Data> getAccountsInSuite(String suite) {
        List<Data> account = new ArrayList<>();
        for (Data entry:data) {
            if(entry.equalsSuite(suite))
                account.add(new Data(entry));
        }
        return account;
    }
    
    /**
     * showSuite - stores all suite values from data into a new set containing
     * distinct unique values
     * @return unique - String Set
     */
    public Set<String> showSuite() {
        Set<String> unique = new HashSet<>();
        for (Data entry:data) {
            unique.add(entry.getSuite());
        }
        return unique;
    }
    
    /**
     * getAccountsInNeighbourhood - searches through Data list and creates a new
     * list with matching neighbourhood names
     * @param neighbourhood
     * @return account - Data list
     */
    public List<Data> getAccountsInNeighbourhood(String neighbourhood) {
        List<Data> account = new ArrayList<>();
        for (Data entry:data) {
            if(entry.equalsNeighbourhood(neighbourhood))
                account.add(new Data(entry));
        }
        return account;
    }
    
    /**
     * showNeighbourhood - stores all neighbourhood values from data into a new
     * set containing distinct unique values
     * @return unique - String Set
     */
    public Set<String> showNeighbourhood() {
        Set<String> unique = new HashSet<>();
        for (Data entry:data) {
            unique.add(entry.getNeighbourhood());
        }
        return unique;
    }
    
    /**
     * getAccountsInWard - searches through Data list and creates a new list with
     * matching ward
     * @param ward
     * @return account - Data list
     */
    public List<Data> getAccountsInWard(String ward) {
        List<Data> account = new ArrayList<>();
        for (Data entry:data) {
            if(entry.equalsWard(ward))
                account.add(new Data(entry));
        }
        return account;
    }
    
    /**
     * showWard - store all ward values from data into a new set containing distinct
     * unique ward values, and is ordered
     * @return unique - String Set
     */
    public Set<String> showWard() {
        Set<String> unique = new TreeSet<>(new WardComparator());
        for(Data entry:data) {
            unique.add(entry.getWard());
        }
        return unique;
    }
    
    /**
     * showNeighbourhoodWard - stores all neighbourhood values from data into a new
     * set containing distinct neighbourhood values found within the specified
     * ward
     * @param ward - String
     * @return unique - String Set
     */
    public Set<String> showNeighbourhoodWard(String ward) {
        Set<String> unique = new HashSet<>();
        for (Data entry:data) {
            if (entry.equalsWard(ward)) {
                unique.add(entry.getNeighbourhood());
            }
        }
        return unique;
    }
    
    /**
     * getAccountWithGarage - searches through Data and adds all Data objects to
     * new list that HAVE garages
     * @return account - Data list
     */
    public List<Data> getAccountsWithGarage() {
        List<Data> account = new ArrayList<>();
        for (Data entry:data) {
            if(entry.hasGarage())
                account.add(new Data(entry));
        }
        return account;
    }
    
    /**
     * getAccountWithoutGarage - searches through Data and adds all Data objects
     * to new list that DO NOT HAVE garages
     * @return account - Data list
     */
    public List<Data> getAccountsWithoutGarage() {
        List<Data> account = new ArrayList<>();
        for (Data entry:data) {
            if(!entry.hasGarage())
                account.add(new Data(entry));
        }
        return account;
    }
    
    /**
     * getAccountsInAssessmentPercentage - gets all accounts of specified
     * assessment percentage
     * @param assessmentPercentage - double field
     * @return account - Data List
     */
    public List<Data> getAccountsInAssessmentPercentage(Double assessmentPercentage) {
        List<Data> account = new ArrayList<>();
        for (Data entry:data) {
            if(entry.equalsAssessmentPercentage(assessmentPercentage))
                account.add(new Data(entry));
        }
        return account;
    }
    
    /**
     * showAssessmentPercentage - stores all assessment percentages values into
     * a set containing distinct unique values
     * @return unique - Double Set
     */
    public Set<Double> showAssessmentPercentage() {
        Set<Double> unique = new HashSet<>();
        for(Data entry:data) {
            Double[] temp = entry.getAssessmentPercentage();
            unique.add(temp[0]);
            unique.add(temp[1]);
            unique.add(temp[2]);
        }
        return unique;
    }
    
    /**
     * getAccountsInAssessmentClass - gets all accounts in a specified assessment
     * class
     * @param assessmentClass - string field
     * @return account - Data List
     */
    public List<Data> getAccountsInAssessmentClass(String assessmentClass) {
        List<Data> account = new ArrayList<>();
        for (Data entry:data) {
            if(entry.equalsAssessmentClass(assessmentClass))
                account.add(new Data(entry));
        }
        return account;
    }
    
    /**
     * showAssessmentClass - stores all assessment class values into a set that
     * contains distinct unique values
     * @return unique - String Set
     */
    public Set<String> showAssessmentClass(){
        Set<String> unique = new HashSet<>();
        for(Data entry:data) {
            String[] temp = entry.getAssessmentClassArray();
            unique.add(temp[0]);
            unique.add(temp[1]);
            unique.add(temp[2]);
        }
        return unique;
    }
    
    /**
     * getAllAccounts - gets all accounts from csv file
     * @return account - Data List
     */
    public List<Data> getAllAccounts() {
        List<Data> account = new ArrayList<>();
        for (Data entry:data) {
            account.add(new Data(entry));
        }
        return account;
    }
    
     /**
     * getAllNeighbourhoods - gets all neighbourhood data from census csv file regarding household income
     * @return neighbourhood - CensusData List
     */
        public List<CensusData> getAllNeighbourhoods() {
        List<CensusData> neighbourhood = new ArrayList<>();
        for (CensusData entry:censusData) {
            neighbourhood.add(new CensusData(entry));
        }
        return neighbourhood;
    }
    
    /**
     * getAllAccountsM - gets all accounts and converts it into a map
     * @return map object with account number as key and matching data object as value
     */
    public Map<Integer, Data> getAllAccountsM() {
        Map<Integer, Data> map = new HashMap<>();
        for (Data entry: data) {
            map.put(entry.getAccountNumber(), new Data(entry));
        }
        return map;
    }
    
    /**
     * getAddressT - retrieves the matching row objects from the list and returns
     * a new list
     * - if the suite is matching, and the only input
     * - if the houseNumber is matching, and the only input
     * - if the streetName is matching, and the only input
     * - if the address is matching, combined input
     * @param name
     * @return new List Data oList
     */
    public List<Data> getAddress(String name) {
        List<Data> oList = new ArrayList<>();
        for (Data entry: data) {
            if (entry.equalsSuite(name)) {oList.add(new Data(entry));}
            if (entry.equalsHouseNumber(name)) {oList.add(new Data(entry));}
            if (entry.equalsStreetName(name)) {oList.add(new Data(entry));}
            if (entry.equalsAddress(name)) {oList.add(new Data(entry));}
        }
        return oList;
    }
    
    /**
     * getSortedMap - should only be called once.
     * creates a nested Map, Map, List grouping ward values with neighbourhood values
     * with double Array list for the assessed values of individual propertys
     * @return 
     */
    public Map<String, Map<String, List<Double>>> getSortedMapByWard() {
        Map<String, Map<String, List<Double>>> wardData = new TreeMap<>(new WardComparator());
        // instantiate wards and add them into map
        Set<String> wardName = showWard();
        for (String str: wardName) {
            wardData.put(str, new TreeMap<String, List<Double>>());
        }
        // populate the individual wards of each neighbourhood
        for (Data entry: data) {
            if (wardData.get(entry.getWard()) == null) {
            } else {
                if (wardData.get(entry.getWard()).get(entry.getNeighbourhood()) == null) {
                    wardData.get(entry.getWard()).put(entry.getNeighbourhood(), new ArrayList<Double>());
                    wardData.get(entry.getWard()).get(entry.getNeighbourhood()).add(entry.getAssessedValueDouble());
                } else {
                    wardData.get(entry.getWard()).get(entry.getNeighbourhood()).add(entry.getAssessedValueDouble());
                }
            }
        }
        return wardData;
    }
    
        public Map<String,WardIncome> getPopulationByWard() {
            List<String> wards = new ArrayList<>();
            Map<String,WardIncome> wardData = new HashMap<>();
            for (int i=1;i<13;i++){
                wards.add("WARD "+i);
                wardData.put("WARD "+i,new WardIncome());
            }
            
            for (CensusData entry: censusData){
                if (wardData.containsKey(entry.getWard())) {
                    //wardData.get(entry.getWard()).add(entry;
                    wardData.get(entry.getWard()).addToLessThan30k(entry.getLessThan30k());
                    wardData.get(entry.getWard()).addToOver30kBelow60k(entry.getOver30kBelow60k());
                    wardData.get(entry.getWard()).addToOver60kBelow100k(entry.getOver60kBelow100k());
                    wardData.get(entry.getWard()).addToOver100kBelow125k(entry.getOver100kBelow125k());
                    wardData.get(entry.getWard()).addToOver125kBelow150k(entry.getOver125kBelow150k());
                    wardData.get(entry.getWard()).addToOver150kBelow200k(entry.getOver150kBelow200k());
                    wardData.get(entry.getWard()).addToOver200kBelow250k(entry.getOver200kBelow250k());
                    wardData.get(entry.getWard()).addToOver250kOrMore(entry.getOver250kOrMore());
                    wardData.get(entry.getWard()).addToNoResponse(entry.getNoResponse());
                }
            }
            
            
            for (int i=1;i<13;i++){
                System.out.println("WARD "+i+" INCOME BY POP");
                System.out.println(wardData.get("WARD "+i).getLessThan30k());
                System.out.println(wardData.get("WARD "+i).getLessThan30k());
                System.out.println(wardData.get("WARD "+i).getOver60kBelow100k());
                System.out.println(wardData.get("WARD "+i).getOver100kBelow125k());
                System.out.println(wardData.get("WARD "+i).getOver125kBelow150k());
                System.out.println(wardData.get("WARD "+i).getOver150kBelow200k());
                System.out.println(wardData.get("WARD "+i).getOver200kBelow250k());
                System.out.println(wardData.get("WARD "+i).getOver250kOrMore());
                System.out.println(wardData.get("WARD "+i).getNoResponse());
            }
            //System.out.println(wardData.get("WARD 1").getLessThan30k());
        return wardData;

        }
}
