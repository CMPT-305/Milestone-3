package Data;

import java.util.Arrays;
import java.util.List;
/**
 * Contains methods that perform statistical calculations
 * @author ryley
 */
public class Statistics {
    
    /**
     * n - returns the size of the list
     * 
     * @param data double List being counted
     * @return size of data
    */
    public static int n (List<Double> data) {
        return data.size();
    }
    
    /**
     * min - retrieves the first value of data at initialization
     * 
     * @param data double List being searched through
     * @return smallest value in data
     */
    public static double min (List<Double> data) {
        double min = data.get(0);
        for (int idx = 0; idx < data.size(); idx++) {
            if (min > data.get(idx)) {
                min = data.get(idx);
            }
        }
        return min;
    }
    
    /**
     * max - retrieves the first value at initialization and stores it.
     * Then reads through data list and compares each value with stored value.
     * 
     * @param data double List being searched through
     * @return largest value in data
     */
    public static double max (List<Double> data) {
        double max = data.get(0);
        for (int idx = 0; idx < data.size(); idx++) {
            if (max < data.get(idx)) {
                max = data.get(idx);
            }
        }
        return max;
    }
    
    /**
     * range - call max(data) and min(data), then return the difference.
     * 
     * @param data double List being read through
     * @return the difference between max(data) and min(data)
     */
    public static double range (List<Double> data) {
        return (max(data) - min(data));
    }
    
    /**
     * mean - sum all values and divide by amount of values.
     * Read through data and add values onto double total.
     * Divide total by size of data list
     * 
     * @param data double List being read through
     * @return mean value of data
     */
    public static double mean (List<Double> data) {
        double total = 0.0;
        for (int idx = 0; idx < data.size(); idx++) {
            total += data.get(idx);
        }
        return (total / data.size());
    }
   
    /**
     * stdev - return the standard deviation of the list of doubles.
     * Get mean of data, within for loop subtract the indexed item with mean.
     * Square the new value and add onto total value.
     * Divide total value by size of data List and store into num.
     * Square root num to get standard deviation.
     * 
     * @param data double List being read through
     * @return standard deviation of data list
     */
    public static double stdev (List<Double> data) {
        double total = 0;
        double mean = mean(data);
        for (int idx = 0; idx < data.size(); idx++) {
            double x = (data.get(idx) - mean);
            x *= x;
            total += x;
        }
        double num = total / data.size();
        return Math.sqrt(num);
    }
    
    /**
     * median - convert the list into an array and sort the new array.
     * Determine if array is odd or even, then return the mid value
     * - if odd: no additional calculation necessary
     * - if even: sum next index value then divide by 2.
     * 
     * @param data double List
     * @return median value based on if array is even or odd
     *  - if even : return index mid value + index+1, multiply by .5
     *  - if odd  : return index mid value
     */
    public static double median (List<Double> data) {
        Double[] median = new Double[data.size()];
        median = data.toArray(median);
        
        Arrays.sort(median);
        
        // even
        if (median.length % 2 == 0) {
            int mid = median.length / 2;
            return((median[mid] + median[mid+1]) * 0.5);
        }
        // odd
        else {
            int mid = median.length / 2;
            return(median[mid]);
        }
    }
}
