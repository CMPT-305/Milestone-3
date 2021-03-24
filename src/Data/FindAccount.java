package Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * FindAccount - find(map, set)
 * gets a new list from filter
 * @author ryley
 */
public class FindAccount {
    /**
     * find - takes a Data map and Integer set and inserts matching account values
     * from set with keys in map, and inserts into a new filtered list
     * @param map Data list (account number key, data object value)
     * @param set Integer set (account numbers)
     * @return newData Data list for filtered list
     */
    public List<Data> find (Map<Integer, Data> map, Set<Integer> set) {
        List<Data> newData = new ArrayList<>();
        for (Integer sets: set) {
            newData.add(new Data(map.get(sets)));
        }
        return newData;
    }
}
