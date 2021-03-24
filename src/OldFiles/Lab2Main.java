package OldFiles;

import Data.Searcher;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *Lab2Main, includes a full statistic search of the data structure,
 * searching for a specific account by account id, and
 * searching for a specific neighbourhood by neighbourhood id
 * @author ryley
 */
public class Lab2Main {

    /**
     * Main program
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {
        Searcher searcher = new Searcher("Property_Assessment_Data.csv");
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            menuPrint();
            input = scanner.nextLine();
            switch(input) {
                case "1": {
                    searcher.menuUtilPrintAllStats();
                    break;}
                case "2": {
                    searcher.menuUtilPrintAccount();
                    break;}
                case "3": {
                    searcher.menuUtilPrintNeighbourhoodStats();
                    break;}
                case "q": {
                    System.out.println("Exiting the program.");
                    break;
                }
                default: {
                    System.out.println("Incorrect input.");
                    break;
                }
            }
        } while(!input.equalsIgnoreCase("q"));
    }
    /**
     * menuPrint - prints the dashboard menu
     */
    public static void menuPrint() {
        System.out.println("1) - Find the statistics of all property assessment.");
        System.out.println("2) - Find the information of an account number.");
        System.out.println("3) - Find the statistics of a specific neighbourhood.");
        System.out.println("q) - Quit the program.");
        System.out.println("Enter a value: ");
    }
    
}
