package TestPackage;

import Data.Searcher;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ryley
 */
public class MainTestWard {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Searcher newSearcher = new Searcher();
        Map<String, Map<String, List<Double>>> sortedMap = newSearcher.getSortedMapByWard();
        
        sortedMap.forEach((k,v) -> System.out.println("key: " + k + ", value: " + v));
    }
}
