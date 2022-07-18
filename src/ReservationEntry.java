import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author Christopher Kurcz
 */

public class ReservationEntry {
    
    private final String faculty;
    private Room room;
    private final Date date;
    private final int seats;
    private final Timestamp timestamp;
    private boolean waitlisted;
    
    
    // constructor for a ReservationEntry
    public ReservationEntry(String faculty, Room room, Date date, int seats, Timestamp timestamp, boolean waitlisted){
        this.faculty = faculty;
        this.room = room;
        this.date = date;
        this.seats = seats;
        this.timestamp = timestamp;
        this.waitlisted = waitlisted;
    }
    
    
    // all standard getters
    public String getFaculty(){
        return faculty;
    }
    
    public Room getRoom(){
        return room;
    }
    
    public Date getDate(){
        return date;
    }
    
    public int getSeats(){
        return seats;
    }
    
    public Timestamp getTimestamp(){
        return timestamp;
    }
    
    public boolean getWaitlisted(){
        return waitlisted;
    }
    
    
    // setters for room and waitlisted
    public void setRoom(Room room){
        this.room = room;
    }
    
    public void setWaitlisted(boolean waitlisted){
        this.waitlisted = waitlisted;
    }
    
}