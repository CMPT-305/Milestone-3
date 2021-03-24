package Data;

import java.text.NumberFormat;
import java.util.Locale;
//mario
/**
 * Creates Data object and stores information from csv line.
 * @author ryley
 */
public class Data {
    private int accountNumber;
    private String suite;
    private String houseNumber;
    private String streetName;
    private String garage;
    private String neighbourhoodID;
    private String neighbourhood;
    private String ward;
    private double assessedValue;
    private double latitude;
    private double longitude;
    private double[] assessmentPercentage;
    private String[] assessmentClass;
    
    /**
     * Constructor method - Data
     * Takes a string line from a csv file and populates information as new Data object
     * @param csv 
     */
    public Data (String csv) {
        String[] token = csv.split(",", -1);
        
        accountNumber = Integer.parseInt(token[0]);
        suite = token[1];
        houseNumber = token[2];
        streetName = token[3];
        garage = token[4];
        neighbourhoodID = token[5];
        neighbourhood = token[6];
        ward = token[7];
        assessedValue = Double.parseDouble(token[8]);
        latitude = Double.parseDouble(token[9]);
        longitude = Double.parseDouble(token[10]);
        
        assessmentPercentage = new double[3];
        for(int j=0; j<3; j++) {
            if (token[12+j].equals("")) {
                assessmentPercentage[j] = 0.0;
            } else {
                assessmentPercentage[j] = Double.parseDouble(token[12+j]);
            }
        }
        
        assessmentClass = new String[3];
        for (int j=0; j<3; j++) {
            assessmentClass[j] = token[15+j];
        }
    }
    
    /**
     * Constructor method - clones the Data object
     * @param clone 
     */
    public Data(Data clone) {
        accountNumber = clone.accountNumber;
        suite = clone.suite;
        houseNumber = clone.houseNumber;
        streetName = clone.streetName;
        garage = clone.garage;
        neighbourhoodID = clone.neighbourhoodID;
        neighbourhood = clone.neighbourhood;
        ward = clone.ward;
        assessedValue = clone.assessedValue;
        latitude = clone.latitude;
        longitude = clone.longitude;
        
        assessmentPercentage = new double[3];
        for(int j=0;j<3;j++) {
            assessmentPercentage[j] = clone.assessmentPercentage[j];
        }
        
        assessmentClass = new String[3];
        for(int j=0;j<3;j++) {
            assessmentClass[j] = clone.assessmentClass[j];
        }
    }
    
    /**
     * getAccountNumber - gets accountNumber
     * @return accountNumber
     */
    public int getAccountNumber() {return accountNumber;}
    
    /**
     * getSuite - gets suite
     * @return suite
     */
    public String getSuite() {return suite;}
    
    /**
     * getHouseNumber - gets houseNumber
     * @return houseNumber
     */
    public String getHouseNumber() {return houseNumber;}
    
    /**
     * getStreetName - gets streetName
     * @return streetName
     */
    public String getStreetName() {return streetName;}
    
    /**
     * hasGarage - gets bool value if object structure has garage
     * @return Y if has garage
     */
    public boolean hasGarage() {return garage.equals("Y");}
    
    /**
     * getNeighbourhoodID - gets neighbourhoodID
     * @return neighbourhoodID
     */
    public String getNeighbourhoodID() {return neighbourhoodID;}
    
    /**
     * getNeighbourhood - gets name of neighbourhood
     * @return neighbourhood
     */
    public String getNeighbourhood() {return neighbourhood;}
    
    /**
     * getWard - gets ward
     * @return ward
     */
    public String getWard() {return ward;}
    
    /**
     * getAssessedValue
     * @return 
     */
    public String getAssessedValue() {
        int temp = (int)assessedValue;
        return "$" + String.format("%,2d", temp);
    }
    
    /**
     * getAssessedValueDouble - gets assessedValue
     * @return assessedValue
     */
    public double getAssessedValueDouble() {return assessedValue;}
    
    /**
     * getLatitude - gets latitude value
     * @return latitude
     */
    public double getLatitude() {return latitude;}
    
    /**
     * getLongitude - gets longitude value
     * @return double longitude
     */
    public double getLongitude() {return longitude;}
    
    /**
     * getAssessmentClass - returns the assessment classes as strings.
     * If assessmentClass contains multiple values, appends them to string
     * @return str
     */
    public String getAssessmentClass() {
        StringBuilder string = new StringBuilder();
        for(int i=0; i<assessmentClass.length; ++i) {
            string.append(assessmentClass[i]);
            string.append(" ");
        }
        String str = string.toString();
        return str;
    }
    
    /**
     * getAssessmentPercentage - copies assessmentPercentage values into an array
     * @return 
     */
    public Double[] getAssessmentPercentage() {
        Double[] apct = new Double[3];
        for (int i=0; i<3; i++) {
            apct[i] = assessmentPercentage[i];
        }
        return apct;
    }
    
    /**
     * getAssessmentClassArray - copies assessmentClass values into an array
     * @return String array act
     */
    public String[] getAssessmentClassArray() {
        String[] act = new String[3];
        for (int i=0; i<3; i++) {
            act[i] = assessmentClass[i];
        }
        return act;
    }
    
    /**
     * getAddress - returns an address string
     * @return address
     */
    public String getAddress() {
        String address = houseNumber + " " + streetName;
        if (suite.length() > 0) {
            address = suite + "-" + address;
        }
        return address;
    }
    
    /**
     * getNeighbourhoodWard - returns the neighbourhood and ward
     * @return neighbourhood (ward)
     */
    public String getNeighbourhoodWard() {return getNeighbourhood()+" ("+getWard() +")";}
    
    /**
     * getLocation - returns the latitude and longitude
     * @return (latitude, longitude)
     */
    public String getLocation() {return "("+getLatitude()+", "+getLongitude()+")";}
    
    /**
     * toString - Overrides toString to print Data object
     * @return Data object format
     */
    @Override
    public String toString() {
        return "Account Number = " + getAccountNumber() +
        "\nAddress = " + getAddress() +
        "\nAssessed Value = $" + String.format("%,.2f", getAssessedValue()) +
        "\nAssessment Class = " + getAssessmentClass() +
        "\nNeighbourhood = " + getNeighbourhoodWard() +
        "\nLocation = " + getLocation();
    }
    
    /**
     * hashCode - the hashCode
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash=3;
        hash=53*hash+this.accountNumber;
        return hash;
    }
    
    /**
     * equals - overrides default equal function
     * Performs comparison on accountNumber
     * works with integer values and Data object
     * @param o
     * @return True, else False
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Data) {
            Data other = (Data)o;
            return accountNumber == other.accountNumber;
        } else if (o instanceof Integer) {
            Integer other = (Integer)o;
            return accountNumber == other;
        } else {
            return false;
        }
    }
    
    /**
     * equalsAccountNumber - compares a string value with the account value
     * @param o
     * @return true/false
     */
    public boolean equalsAccountNumber(String o) {
        int temp = Integer.parseInt(o);
        return accountNumber == temp;
    }
    
    /**
     * containsAccountNumber - gets a string value and converts the accountNumber
     * value into a string, and compares if any of the inputted string is contained
     * in the accountNumber
     * @param o
     * @return true/false
     */
    public boolean containsAccountNumber(String o) {
        String temp = String.valueOf(getAccountNumber());
        return temp.contains(o);
    }
    
    /**
     * equalsAccountNumber - compares an integer value with the account value
     * @param o
     * @return true/false
     */
    public boolean equalsAccountNumber(Integer o) {
        return accountNumber == o;
    }
    
    /**
     * equalsSuite - checks input and returns true if it matches suite.
     * Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsSuite(String o) {return suite.equalsIgnoreCase(o);}
    
    /**
     * equalsHouseNumber - checks input and returns true if it matches
     * houseNumber. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsHouseNumber(String o) {return houseNumber.equalsIgnoreCase(o);}
    
    /**
     * equalsStreetName - checks input and returns true if it matches
     * streetName. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsStreetName(String o) {return streetName.equalsIgnoreCase(o);}
    
    /**
     * equalsAddress - checks input and returns true if it matches address. Otherwise false.
     * @param o
     * @return true/false
     */
    public boolean equalsAddress(String o) {
        String address = this.getAddress();
        return address.equalsIgnoreCase(o);
    }
    
    /**
     * containsAddress - checks user input and returns true if any of the characters
     * match the component address value.
     * @param o
     * @return  true/false
     */
    public boolean containsAddress(String o) {
        String address = this.getAddress();
        return address.contains(o.toUpperCase());
    }
    
    /**
     * equalsNeighbourhoodID - checks input and returns true if it matches
     * neighbourhoodID in object. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsNeighbourhoodID(String o) {return neighbourhoodID.equalsIgnoreCase(o);}
    
    /**
     * equalsNeighbourhood - checks input and returns true if it matches neighbourhood
     * in object. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsNeighbourhood(String o) {
        return neighbourhood.equalsIgnoreCase(o);
    }
    
    /**
     * containsNeighbourhood - checks input, converts neighbourhood into a string
     * and returns true if it contains [art of the neighbourhood string
     * @param o
     * @return true/false
     */
    public boolean containsNeighbourhood(String o) {
        String temp = this.getNeighbourhood();
        return temp.contains(o.toUpperCase());
    }
    
    /**
     * equalsWard - checks input and returns true if it matches ward in object.
     * Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsWard(String o) {return ward.equalsIgnoreCase(o);}
    
    /**
     * lesserAssessedValue - checks input and returns true if it is less than
     * assessedValue in object. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean lesserAssessedValue(Double o) {return o < assessedValue;}
    
    /**
     * equalAssessedValue - checks input and returns true if it is equal to
     * assessedValue in object. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalAssessedValue(Double o) {return assessedValue == o;}
    
    /**
     * greaterAssessedValue - checks input and returns true if it is greater
     * than assessedValue in object. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean greaterAssessedValue(Double o) {return o > assessedValue;}
    
    /**
     * equalsAssessmentPercentage - checks input and returns true if it matches
     * in the object. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsAssessmentPercentage(Double o) {
        for (int i=0; i<3; i++) {
            if (assessmentPercentage[i]==o) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * equalsAssessmentClass - checks input and returns true if it matches in
     * the object. Otherwise false
     * @param o
     * @return true/false
     */
    public boolean equalsAssessmentClass(String o) {
        for (int i=0; i<3; i++) {
            if (assessmentClass[i].equalsIgnoreCase(o)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * assessmentClass - returns formatted assessmentClass as string
     * @return String
     */
    public String assessmentClass() {
        StringBuilder string = new StringBuilder();
        for(int i=0; i<assessmentClass.length; ++i) {
            string.append(assessmentClass[i]);
            string.append(" ");
        }
        String str = string.toString();
        return str;
    }
    
    /**
     * assessedValue - returns formatted assessedValue as string
     * @return String
     */
    public String assessedValue() {
        int value = (int) assessedValue;
        return "$"+String.format("%,2d", value);
    }
}
