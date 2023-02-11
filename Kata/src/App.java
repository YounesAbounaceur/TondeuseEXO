import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws Exception {
       
        int x_max, y_max;
        int cnt = 0, index = -1;
        ArrayList<Tondeuse> tondeuses = new ArrayList<Tondeuse>();
        //Handle the unexisting File exception
        try {   
            File file = new File("C:\\Users\\youne\\Documents\\Projects\\Kata\\src\\files\\SourceFile.txt");
            //read the source file in files folder
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            
                //read the file
                String msg="",st;
                
                while ((st = br.readLine()) != null)
                    msg += st;
                
                //get rid of spaces to make it easier to manipulate data
                msg=msg.replaceAll(" ", "");
    
                //verify if the data in the valid is valid using Regex
                if(!isRegexValid(msg)) System.out.println("Unvalide File information !!!");
                //if it's valid we can carry on
                else{
                    //get the maximum of both X and Y
                    x_max = Character.getNumericValue(msg.charAt(0));
                    y_max = Character.getNumericValue(msg.charAt(1));
              
                    // instanciate the Tondeuse objects
                    for(int i=2; i<msg.length(); i++){
                        //if it's a digit we increase the counter
                        if(Character.isDigit(msg.charAt(i))){
                            cnt++;
                            //if it's two consecutive digits then it's a new Tondeuse object
                            if(cnt == 2){
                                //reset the count for the next Tondeuse
                                cnt = 0;
                                //instanciate Tondeuse
                                tondeuses.add(new Tondeuse(Character.getNumericValue(msg.charAt(i-1)),Character.getNumericValue(msg.charAt(i)), msg.charAt(i+1)));
                                //index to help us get the instructions laters, increase it when we have filled all instructions and we have a new tondeuse
                                index++;
                                i++;
                            }
                        }
                        //if it's not a digit it's an instruction (set of instructions)
                        else{
                            //we set all the instructions in our Tondeuse
                            tondeuses.get(index).insertChar(msg.charAt(i));
                        }
                    }
                    //Display the final result   
                    System.out.println(getFinalResult(tondeuses, x_max, y_max));            
                }
            
               
    
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("This File doesn't exist !!");
        }
        
        
        
    }
    //this method help us check if the data in our File is valid using Regex
    public static boolean isRegexValid(String msg){
        return Pattern.matches("[0-9][0-9]([0-9][0-9][NESW][GDA]*)+", msg);
    }

    //this method returns the final String displayed in Main
    public static String getFinalResult(ArrayList<Tondeuse> tondeuses, int x_max, int y_max){
        String resFinal = "(position finale des tondeuses) : ";
        //we use the Execute method of Tondeuse to get the final positions of each Tondeuse object
        for(int j = 0; j<tondeuses.size(); j++){
            resFinal = resFinal+ " "+tondeuses.get(j).ExecuteInstructions(x_max, y_max);
        }
        return resFinal;

    }


}
