package Data;

import java.util.Comparator;

/**
 * WardComparator - compares the ward values given by a data object as a string
 * to be used within the TreeSet
 * @author ryley
 */
public class WardComparator implements Comparator<String>{
    /**
     * compare two string input ward values, retrieves the integer value
     * and compares between the two.
     * @param o1 String
     * @param o2 String
     * @return 1 = o1 greater than o2, -1 = o1 less than o2, 0 otherwise
     */
    @Override
    public int compare(String o1, String o2) {
        // if the account has no ward
        if (o1.isEmpty() || o2.isEmpty()) {
            return 0;
        } else {
            String ward1 = o1.split(" ")[1];
            String ward2 = o2.split(" ")[1];
            int w1 = Integer.parseInt(ward1);
            int w2 = Integer.parseInt(ward2);
            //System.out.println(ward1 + " compare to " + ward2);
            //int value = ward1.compareTo(ward2);
            if (w1 > w2) {return 1;}
            else if (w1 < w2) {return -1;}
            else {return 0;}
            }
    }
}
