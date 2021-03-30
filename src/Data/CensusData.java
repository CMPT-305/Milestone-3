/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;



/**
 *
 * @author Mario
 */
public class CensusData {
    private final String ward;
    private final String neighbourhood;
    private final Integer lessThan30k;
    private final Integer over30kBelow60k;
    private final Integer over60kBelow100k;
    private final Integer over100kBelow125k;
    private final Integer over125kBelow150k;
    private final Integer over150kBelow200k;
    private final Integer over200kBelow250k;
    private final Integer over250kOrMore;
    private final Integer noResponse;
    
    /**
     * Constructor method - Data
     * Takes a string line from a csv file and populates information as new Data object
     * @param csv 
     */
    public CensusData (String csv) {
        String[] token = csv.split(",");
        
        ward = token [0];
        neighbourhood = token[2];
        lessThan30k = Integer.parseInt(token[3]);
        over30kBelow60k = Integer.parseInt(token[4]);
        over60kBelow100k = Integer.parseInt(token[5]);
        over100kBelow125k = Integer.parseInt(token[6]);
        over125kBelow150k = Integer.parseInt(token[7]);
        over150kBelow200k = Integer.parseInt(token[8]);
        over200kBelow250k = Integer.parseInt(token[9]);
        over250kOrMore = Integer.parseInt(token[10]);
        noResponse = Integer.parseInt(token[11]);
        
            }
    
    public CensusData(CensusData clone) {
        ward = clone.ward;
        neighbourhood = clone.neighbourhood;
        lessThan30k = clone.lessThan30k;
        over30kBelow60k = clone.over30kBelow60k;
        over60kBelow100k = clone.over60kBelow100k;
        over100kBelow125k = clone.over100kBelow125k;
        over125kBelow150k = clone.over125kBelow150k;
        over150kBelow200k = clone.over150kBelow200k;
        over200kBelow250k = clone.over200kBelow250k;
        over250kOrMore = clone.over250kOrMore;
        noResponse = clone.noResponse;
    }

    public String getWard() {
        String wardClone = ward;
        return wardClone;
    }

    public String getNeighbourhood() {
        String neighbourhoodClone = neighbourhood;
        return neighbourhoodClone;
    }

    public Integer getLessThan30k() {
        Integer lessThan30kClone = lessThan30k;
        return lessThan30kClone;
    }

    public Integer getOver30kBelow60k() {
        Integer over30kBelow60kClone = over30kBelow60k;
        return over30kBelow60kClone;
    }

    public Integer getOver60kBelow100k() {
        Integer over60kBelow100kClone = over60kBelow100k;
        return over60kBelow100kClone;
    }

    public Integer getOver100kBelow125k() {
        Integer over100kBelow125kClone = over100kBelow125k;
        return over100kBelow125kClone;
    }

    public Integer getOver125kBelow150k() {
        Integer over125kBelow150kClone = over125kBelow150k;
        return over125kBelow150kClone;
    }

    public Integer getOver150kBelow200k() {
        Integer over150kBelow200kClone = over150kBelow200k;
        return over150kBelow200kClone;
    }

    public Integer getOver200kBelow250k() {
        Integer over200kBelow250kClone = over200kBelow250k;
        return over200kBelow250kClone;
    }

    public Integer getOver250kOrMore() {
        Integer over250kOrMoreClone = over250kOrMore;
        return over250kOrMoreClone;
    }

    public Integer getNoResponse() {
        Integer noResponseClone = noResponse;
        return noResponseClone;
    }
    
    
        /**
     * equalsStreetName - checks input and returns true if it matches
     * streetName. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsWard(String o) {return ward.equalsIgnoreCase(o);}
    public boolean equalsNeighbourhood(String o) {return neighbourhood.equalsIgnoreCase(o);}
        
    
}
