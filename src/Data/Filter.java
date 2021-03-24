package Data;

import java.util.List;
import java.util.Set;

/**
 * Filter interface
 * @author ryley
 */
public interface Filter {
    /**
     * search - takes a list and string value and returns a new set
     * @param list data list
     * @param value string value
     * @return integer set of accountNumbers
     */
    public Set<Integer> search(List<Data> list, String value);
}