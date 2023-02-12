public class Tondeuse {
    private int x, y;
    private String instructions;
    private char orientation;

    public Tondeuse(int x, int y, char orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.instructions ="";
    }
    public void insertChar(char c){
        this.instructions = this.instructions + c;
    }
    
    //To execute instructions for Each Tondeuse
    public String ExecuteInstructions(int x_max, int y_max){
        //execute instructions
        for(int k=0; k<this.instructions.length(); k++){
            //if the instruction is A we need to increment either x or y depending on the orientation of Tondeuse
            if(instructions.charAt(k) == 'A'){
                if(this.orientation == 'N' && y<y_max) this.y++;
                else if(this.orientation == 'S' && y>0) this.y--;
                else if(this.orientation == 'E' && x<x_max) this.x++;
                else if(this.orientation == 'W' && x>0) this.x--;
            //else, if it's G or D we need to change the orientation of Tondeuse without changing x and y
            }else if(instructions.charAt(k) == 'G'){
                if(this.orientation == 'N') this.orientation ='W';
                else if(this.orientation == 'W') this.orientation ='S';
                else if(this.orientation == 'S') this.orientation ='E';
                else if(this.orientation == 'E') this.orientation ='N';
            }else if(instructions.charAt(k) == 'D'){
                if(this.orientation == 'N') this.orientation ='E';
                else if(this.orientation == 'E') this.orientation ='S';
                else if(this.orientation == 'S') this.orientation ='W';
                else if(this.orientation == 'W') this.orientation ='N';                
            }
           
        }
        //return the final string for this Tondeuse object
        return this.x + " " + this.y + " " + this.orientation;
    }
}
