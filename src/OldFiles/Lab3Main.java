package OldFiles;

import Data.Searcher;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Lab3Main, only includes statistics for the assessment class within the menu
 * @author ryley
 */
public class Lab3Main {

    /**
     * Main function
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
                    searcher.menuUtilPrintAssessmentClassStats();
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
        System.out.println("1) - Find the statistics of an assessment class.");
        System.out.println("q) - Quit the program.");
        System.out.println("Enter a value: ");
    }
    
}
