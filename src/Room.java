/**
 * @author Christopher Kurcz
 */

public class Room {
    
    private final String name;
    private final int seats;
    
    
    // constructor for Room
    public Room(String name, int seats){
        this.name = name;
        this.seats = seats;
    }
    
    
    // all standard getters
    public String getName(){
        return name;
    }
    
    public int getSeats(){
        return seats;
    }
    
}