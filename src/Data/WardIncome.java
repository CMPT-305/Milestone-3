/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 * Class for the income of a ward
 * @author Mario
 */
public class WardIncome {
    
    private Integer lessThan30k;
    private Integer over30kBelow60k;
    private Integer over60kBelow100k;
    private Integer over100kBelow125k;
    private Integer over125kBelow150k;
    private Integer over150kBelow200k;
    private Integer over200kBelow250k;
    private Integer over250kOrMore;
    private Integer noResponse;
    
    /**
     * Initializes the variables for the ward income so it can be added to
     * using the censusData objects
     */
    public WardIncome () {
        this.lessThan30k = 0;
        this.over30kBelow60k = 0;
        this.over60kBelow100k = 0;
        this.over100kBelow125k = 0;
        this.over125kBelow150k = 0;
        this.over150kBelow200k = 0;
        this.over200kBelow250k = 0;
        this.over250kOrMore = 0;
        this.noResponse = 0;
            }

    /**
     * 
     *  @return population making Less than 30k for this ward
     */
    public Integer getLessThan30k() {
        return lessThan30k;
    }
/**
 * @return population making over 30k and below 60k for this ward
 *
 */
    public Integer getOver30kBelow60k() {
        return over30kBelow60k;
    }

    /**
     * 
     * @return population making over 60k and below 100k for this ward
     */
    public Integer getOver60kBelow100k() {
        return over60kBelow100k;
    }
    
    /**
     * 
     * @return population making over 100k and below 125k for this ward
     */
    public Integer getOver100kBelow125k() {
        return over100kBelow125k;
    }
    
    /**
     * 
     * @return population making over 125k and below 150k for this ward
     */
    public Integer getOver125kBelow150k() {
        return over125kBelow150k;
    }

    /**
     * 
     * @return population making over 150k and below 200k for this ward
     */
    public Integer getOver150kBelow200k() {
        return over150kBelow200k;
    }

    /**
     * 
     * @return population making over 200k and below 250k for this ward
     */
    public Integer getOver200kBelow250k() {
        return over200kBelow250k;
    }

    /**
     * 
     * @return population making over 250k for this ward
     */
    public Integer getOver250kOrMore() {
        return over250kOrMore;
    }
    
    /**
     * 
     * @return population that didn't respond to the census for this ward
     */
    public Integer getNoResponse() {
        return noResponse;
    }
    
    /**
     * Add to the population making less than 30k by an int value 
     * @param add 
     */
    public void addToLessThan30k(Integer add) {
        this.lessThan30k += add;
    }

     /**
     * Add to the population making over 30k and below 60k by an int value 
     * @param add 
     */
    public void addToOver30kBelow60k(Integer add) {
        this.over30kBelow60k += add;
    }
     /**
     * Add to the population making over 60k and below 100k by an int value 
     * @param add 
     */
    public void addToOver60kBelow100k(Integer add) {
        this.over60kBelow100k += add;
    }
     /**
     * Add to the population making over 100k and below 125k by an int value 
     * @param add 
     */
    public void addToOver100kBelow125k(Integer add) {
        this.over100kBelow125k += add;
    }
     /**
     * Add to the population making over 125k and below 150k by an int value 
     * @param add 
     */
    public void addToOver125kBelow150k(Integer add) {
        this.over125kBelow150k += add;
    }
     /**
     * Add to the population making over 150k and below 200k by an int value 
     * @param add 
     */
    public void addToOver150kBelow200k(Integer add) {
        this.over150kBelow200k += add;
    }
     /**
     * Add to the population making over 200k and below 250k by an int value 
     * @param add 
     */
    public void addToOver200kBelow250k(Integer add) {
        this.over200kBelow250k += add;
    }
     /**
     * Add to the population making over 250k by an int value 
     * @param add 
     */
    public void addToOver250kOrMore(Integer add) {
        this.over250kOrMore += add;
    }
     /**
     * Add to the population that didn't respond to the census by an int value 
     * @param add 
     */
    public void addToNoResponse(Integer add) {
        this.noResponse += add;
    }
    
}
