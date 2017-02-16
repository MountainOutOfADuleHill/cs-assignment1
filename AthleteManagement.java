/**
 * AthleteManagement.java
 * 
 * COMP 1020 A02
 * INSTRUCTOR: Khalad Hasan
 * NAME:       Noah Wilmott
 * ASSIGNMENT: 1
 * QUESTION:   2
 * 
 * PURPOSE: Manage information about Olympic athletes
 */
public class AthleteManagement {
  private Athlete[] athletes;
  private int numOfAthlete;
  
  public AthleteManagement(){
    this.numOfAthlete = 0;
    this.athletes = new Athlete[100];
    
  }
  
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
      }
    }
  }
  
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
  
  public String toString(){
    String theString = "";
    
    for(int i = 0; i < numOfAthlete; i++){
      theString += "\t" + athletes[i].toString() + "\n";
    }
    
    return theString;
  }
}
