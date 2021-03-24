package Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FilterWard interface of Filter
 * filters data based on was input and produces an integer set of account numbers
 * @author ryley
 */
public class FilterWard implements Filter{
    /**
     * search - finds matching account numbers with input text of ward
     * @param list - list to searched within
     * @param value - string input
     * @return Set Integer list
     */
    @Override
    public Set<Integer> search(List<Data> list, String value) {
        Set<Integer> temp = new HashSet<>();
        for (Data entry: list) {
            if (value.equals("") || entry.equalsWard(value)) {
                temp.add(entry.getAccountNumber());
            }
        }
        return temp;
    }
    
}
