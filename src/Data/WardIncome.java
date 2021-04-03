package Data;

/**
 *
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
     * WardIncome - initializer for WardIncome
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
     * getLessThan30k
     * @return lessThank30k
     */
    public Integer getLessThan30k() {
        return lessThan30k;
    }
    
    /**
     * getOver30kBelow60k
     * @return over30kBelow60k
     */
    public Integer getOver30kBelow60k() {
        return over30kBelow60k;
    }
    
    /**
     * getOver60kBelow100k
     * @return over60kBelow100k
     */
    public Integer getOver60kBelow100k() {
        return over60kBelow100k;
    }
    
    /**
     * getOver100kBelow125k
     * @return over100kBelow125k
     */
    public Integer getOver100kBelow125k() {
        return over100kBelow125k;
    }
    
    /**
     * getOver125kBelow150k
     * @return over125kBelow150k
     */
    public Integer getOver125kBelow150k() {
        return over125kBelow150k;
    }
    
    /**
     * getOver150kBelow200k
     * @return over150kBelow200k
     */
    public Integer getOver150kBelow200k() {
        return over150kBelow200k;
    }
    
    /**
     * getOver200kBelow250k
     * @return over200kBelow250k
     */
    public Integer getOver200kBelow250k() {
        return over200kBelow250k;
    }
    
    /**
     * getOver250kOrMore
     * @return over250kOrMore
     */
    public Integer getOver250kOrMore() {
        return over250kOrMore;
    }
    
    /**
     * getNoResponse
     * @return noResponse
     */
    public Integer getNoResponse() {
        return noResponse;
    }
    
    /**
     * addToLessThan30k
     * @param add + lessThan30k
     */
    public void addToLessThan30k(Integer add) {
        this.lessThan30k += add;
    }
    
    /**
     * addToOver30kBelow60k
     * @param add + over30kBelow60k
     */
    public void addToOver30kBelow60k(Integer add) {
        this.over30kBelow60k += add;
    }
    
    /**
     * addToOver60kBelow100k
     * @param add + over60kBelow100k
     */
    public void addToOver60kBelow100k(Integer add) {
        this.over60kBelow100k += add;
    }
    
    /**
     * addToOver100kBelow125k
     * @param add + over100kBelow125k
     */
    public void addToOver100kBelow125k(Integer add) {
        this.over100kBelow125k += add;
    }
    
    /**
     * addToOver125kBelow150k
     * @param add + over125kBelow150k
     */
    public void addToOver125kBelow150k(Integer add) {
        this.over125kBelow150k += add;
    }
    
    /**
     * addToOver150kBelow200k
     * @param add + over150kBelow200k
     */
    public void addToOver150kBelow200k(Integer add) {
        this.over150kBelow200k += add;
    }
    
    /**
     * addToOver200kBelow250k
     * @param add + over200kBelow250k
     */
    public void addToOver200kBelow250k(Integer add) {
        this.over200kBelow250k += add;
    }
    
    /**
     * addToOver250kOrMore
     * @param add + over250kOrMore
     */
    public void addToOver250kOrMore(Integer add) {
        this.over250kOrMore += add;
    }
    
    /**
     * addToNoResponse
     * @param add + noResponse
     */
    public void addToNoResponse(Integer add) {
        this.noResponse += add;
    }
}
