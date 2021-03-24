package Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FilterAccount interface of Filter
 * filters data based on account number and returns an integer set of account number
 * @author ryley
 */
public class FilterAccount implements Filter{
    /**
     * search - finds matching account numbers with input text of accountNumber
     * @param list - list to be searched within
     * @param value - string input
     * @return Set Integer list
     */
    @Override
    public Set<Integer> search(List<Data> list, String value) {
        Set<Integer> temp = new HashSet<>();
        for (Data entry: list) {
            if (value.equals("") || entry.containsAccountNumber(value) || entry.equalsAccountNumber(value)) {
                temp.add(entry.getAccountNumber());
            }
        }
        return temp;
    }
}
