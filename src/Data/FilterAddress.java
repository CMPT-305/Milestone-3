package Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FilterAddress interface of Filter
 * filters data based on address input and produces an integer set of account numbers
 * @author ryley
 */
public class FilterAddress implements Filter{
    /**
     * search - finds matching account numbers with input text of address
     * @param list - list to be searched within
     * @param value - string input
     * @return Set Integer list
     */
    @Override
    public Set<Integer> search(List<Data> list, String value) {
        Set<Integer> temp = new HashSet<>();
        for (Data entry: list) {
            if (value.equals("") || entry.containsAddress(value) || entry.equalsAddress(value)) {
                temp.add(entry.getAccountNumber());
            }
        }
        return temp;
    }
}
