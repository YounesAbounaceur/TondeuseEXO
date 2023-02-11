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
    public void setX(int x){
        this.x = x;
    
    }

    public void setY(int y){
        this.y = y;
    }
    public void setInstructions(String instructions){
        this.instructions = instructions;
    }
    public void setOrientation(char orientation){
        this.orientation = orientation;
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public char getOrientation(){
        return this.orientation;
    }
    public String getInstructions(){
        return this.instructions;
    }

    public String ExecuteInstructions(int x_max, int y_max){
        // y_prev and x_prev is to check if we never go under 0 
        // y_next and x_next is to check if we never go over x_max and y_max
        int y_prev, y_next;
        int x_prev, x_next;
        //execute instructions
        for(int k=0; k<this.instructions.length(); k++){
            y_prev = y--; y_next = y++;
            x_prev = x--; x_next = x++;
            //if the instruction is A we need to increment either x or y depending on the orientation of Tondeuse
            if(instructions.charAt(k) == 'A'){
                if(this.orientation == 'N' && y_next<=y_max) this.y++;
                else if(this.orientation == 'S' && y_prev>=0) this.y--;
                else if(this.orientation == 'E' && x_next<=x_max) this.x++;
                else if(this.orientation == 'W' && x_prev>=0) this.x--;
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
