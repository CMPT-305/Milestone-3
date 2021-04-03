/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Mario and Ryan
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
     * Constructor method - CensusData
     * Takes a string line from a csv file and populates information as new CensusData object
     * @param csv 
     */
    public CensusData (String csv) {
        String[] token = csv.split(",");
        
        ward = token [0];
        neighbourhood = token[2];
        //Variables for the amount of people with the following income
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
    
    /**
     * 
     * @param clone 
     */
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

     /**
     * 
     * @return ward
     */
    public String getWard() {
        String wardClone = ward;
        return wardClone;
    }
    
    /**
     * 
     * @return neighbourhood
     */
    public String getNeighbourhood() {
        String neighbourhoodClone = neighbourhood;
        return neighbourhoodClone;
    }

    /**
     * 
     * @return population making Less than 30k
     */
    public Integer getLessThan30k() {
        Integer lessThan30kClone = lessThan30k;
        return lessThan30kClone;
    }

    /**
     * 
     * @return population over 30k and below 60k
     */
    public Integer getOver30kBelow60k() {
        Integer over30kBelow60kClone = over30kBelow60k;
        return over30kBelow60kClone;
    }

    /**
     * 
     * @return population making over 60k and below 100k
     */
    public Integer getOver60kBelow100k() {
        Integer over60kBelow100kClone = over60kBelow100k;
        return over60kBelow100kClone;
    }

    /**
     * 
     * @return population making over 100k and below 125k
     */
    public Integer getOver100kBelow125k() {
        Integer over100kBelow125kClone = over100kBelow125k;
        return over100kBelow125kClone;
    }

    /**
     * 
     * @return population making over 125k and below 150k
     */
    public Integer getOver125kBelow150k() {
        Integer over125kBelow150kClone = over125kBelow150k;
        return over125kBelow150kClone;
    }

    /**
     * 
     * @return population making over 150k and below 200k
     */
    public Integer getOver150kBelow200k() {
        Integer over150kBelow200kClone = over150kBelow200k;
        return over150kBelow200kClone;
    }

    /**
     * 
     * @return population making over 200k and below 250k
     */
    public Integer getOver200kBelow250k() {
        Integer over200kBelow250kClone = over200kBelow250k;
        return over200kBelow250kClone;
    }

    /**
     * 
     * @return population making over 250k
     */
    public Integer getOver250kOrMore() {
        Integer over250kOrMoreClone = over250kOrMore;
        return over250kOrMoreClone;
    }

    /**
     * 
     * @return population that didn't respond to the census
     */
    public Integer getNoResponse() {
        Integer noResponseClone = noResponse;
        return noResponseClone;
    }
    
    /**
     * equalsStreetName - checks input and returns true if it matches
     * ward. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsWard(String o) {return ward.equalsIgnoreCase(o);}
    
     /**
     * equalsStreetName - checks input and returns true if it matches
     * neighbourhood. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsNeighbourhood(String o) {return neighbourhood.equalsIgnoreCase(o);}
}
