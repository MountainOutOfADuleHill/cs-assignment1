/**
 * AthleteQuery.java
 * 
 * COMP 1020 A02
 * INSTRUCTOR: Khalad Hasan
 * NAME:       Noah Wilmott
 * ASSIGNMENT: 1
 * QUESTION:   3
 * 
 * PURPOSE: Query information about Olympic athletes
 */
public class AthleteQuery {
  private Athlete[] athletes;
  private int numOfAthlete;
  
  public AthleteQuery(){
    this.numOfAthlete = 0;
    this.athletes = new Athlete[100];
    
  }
  //Find the index of an object based on its serial number
  public int indexOf(String serial){
    int returnValue = -1; //default to not finding the index
    for(int i = 0; i < numOfAthlete; i++){
      if((athletes[i].getSerialNo()).equals(serial)){
        returnValue = i;
        break;
      }
    }
    return returnValue;
  }
  
  //Add an athlete to the list of athlete objects
  public void addAthlete(Athlete theAthlete){
    int indexValue = indexOf(theAthlete.getSerialNo());
    if(indexValue == -1){
      //wasn't found in the array
      this.athletes[this.numOfAthlete] = theAthlete;
      numOfAthlete++;
    }
    else{
      //it was found in the array
      //gotta check to see if it is completely identical with the match
      if(theAthlete.equals(athletes[indexValue])){//they are a match
        System.out.println("That athlete is already in the system.");
      }
      else{
        //info needs updating
        athletes[indexValue] = theAthlete;
        System.out.println("Athlete info updated.");
      }
    }
  }
  
  //remove an athlete object from the athlete list
  public Athlete deleteAthlete(String serialNo){
    int indexValue = indexOf(serialNo);
    int offset = 0;
    if(indexValue == -1){return null;}
    else{
      Athlete returnAthlete = athletes[indexValue];

      Athlete[] oneLessAthlete = new Athlete[100];//make an array the same size as athletes
      for(int i = 0; i < athletes.length; i++){
        if(i != indexValue){
          oneLessAthlete[i - offset] = athletes[i];
          offset = 1;//keep the one array shorter than the other because it no longer has that item
        }
      }
      this.athletes = oneLessAthlete;
      
      numOfAthlete--;
      return returnAthlete;
    }
  }
  
  //Determine the athletes who participated in either the summer or winter olympics
  public AthleteQuery getByOlympicType(boolean summerWinter){
    //return an AthleteQuery object containing a list of athlete objects who participated in either the summer or winter olympics
    //first cycle through all the athlete objects to compare them to the summerWinter boolean value to determine who goes in the list
    Athlete[] summerWinterAthletes = new Athlete[this.numOfAthlete];
    int sizeOfSeason = 0;
    for(int i = 0; i < this.numOfAthlete; i++){
      if((this.athletes[i]).getSummerGames() == summerWinter){//object has to go into our array 
        summerWinterAthletes[sizeOfSeason] = this.athletes[i];
        sizeOfSeason++;
      }
    }
    
    //we now have an array filled with objects, we now have to make a new object 
    AthleteQuery seasonAthletes = new AthleteQuery();
    for(int i = 0; i < sizeOfSeason; i++){//loop through our array of objects and add them as athletes to our new seasonAthletes object
      seasonAthletes.addAthlete(new Athlete(summerWinterAthletes[i].getSerialNo(), summerWinterAthletes[i].getName(), summerWinterAthletes[i].getCountry(), summerWinterAthletes[i].getSport(), summerWinterAthletes[i].getSummerGames(), summerWinterAthletes[i].getMedalCount()));
    }
    
    return seasonAthletes;
  }
  
  //Determine how many medals were scored by a certain country
  public int getTotalMedals(String country){
    //Loop through all of the athletes and for every country match we add to the medals total
    int medalCount = 0;
    
    for(int i = 0; i < this.numOfAthlete; i++){
      if((this.athletes[i].getCountry()).equals(country)){
        medalCount += this.athletes[i].getMedalCount();
      }
    }
    
    return medalCount;
  }
  
  //Determine the max medal scorer from the country being passed to the function
  public String getMaxMedals(String country){
    String athlete = "";//name of the athlete who has the most medals for the country
    int maxMedsSoFar = 0;
    
    for(int i = 0; i < this.numOfAthlete; i++){
      if(athletes[i].getCountry().equals(country)){
        if(maxMedsSoFar < athletes[i].getMedalCount()){
          maxMedsSoFar = athletes[i].getMedalCount();
          athlete = athletes[i].getName();
        }
      }
    }
    if(athlete.equals("")){athlete = "None";}//if unchanged, change to None
    
    return athlete;
  }
  
  //make the actions of this class readable
  public String toString(){
    String theString = "";
    
    for(int i = 0; i < numOfAthlete; i++){
      theString += "\t" + athletes[i].toString() + "\n";
    }
    
    return theString;
  }
}
