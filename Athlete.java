/**
 * Athlete.java
 * 
 * COMP 1020 A02
 * INSTRUCTOR: Khalad Hasan
 * NAME:       Noah Wilmott
 * ASSIGNMENT: 1
 * QUESTION:   1
 * 
 * PURPOSE: Record information about Olympic athletes
 */
public class Athlete {
  private String serialNo;
  private String name;
  private String country;
  private String sport;
  private boolean summerGames;
  private int medalCount;
  private static int numOfAthlete = 0;
    
  public Athlete(String serial,String name,String country,String sport,boolean summerGames,int medalCount){//the constructor
    this.serialNo = serial;
    this.name = name;
    this.country = country;
    this.sport = sport;
    this.summerGames = summerGames;
    this.medalCount = medalCount;
    numOfAthlete++;
  }
  
  //Get the serialNo
  public String getSerialNo(){return this.serialNo;}
  //Set the serialNo
  public void setSerialNo(String newSerial){this.serialNo = newSerial;}
  //Get the name
  public String getName(){return this.name;}
  //Set the name
  public void setName(String newName){this.name = newName;}
  //Get the country
  public String getCountry(){return this.country;}
  //Set the country
  public void setCountry(String newCountry){this.country = newCountry;}
  //Get the sport
  public String getSport(){return this.sport;}
  //Set the sport
  public void setSport(String newSport){this.sport = newSport;}
  //Get the summerGames
  public boolean getSummerGames(){return this.summerGames;}
  //Set the summerGames
  public void setSummerGames(boolean newSummerGames){this.summerGames = newSummerGames;}
  //Get the medalCount
  public int getMedalCount(){return this.medalCount;}
  //Set the medalCount
  public void setMedalCount(int newMedalCount){this.medalCount = newMedalCount;}
  
  //Return the number of athletes
  public static int athleteCount(){
    return numOfAthlete;
  }
  
  //Check to see if two objects are equal except for serial number
  public boolean equals(Athlete potentialMatch){
    if((this.name).equals(potentialMatch.getName()) && (this.country).equals(potentialMatch.getCountry()) && (this.sport).equals(potentialMatch.getSport()) && this.summerGames == potentialMatch.getSummerGames() && this.medalCount == potentialMatch.getMedalCount()){
      return true;
    }
    else{return false;}
  }
  
  public String toString(){
    String summerWinter;
    if(this.summerGames){summerWinter = "Summer Olympic";}
    else{summerWinter = "Winter Olympic";}
    
    return this.serialNo + ": " + this.name + "(" + this.country + ") " + this.sport + " " + summerWinter + " " + this.medalCount + " medals."; 
  }
  
  
}
