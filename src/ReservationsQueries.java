import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author Christopher Kurcz
 */

public class ReservationsQueries {
    
    private static Connection connection;
    private static PreparedStatement addReservationEntry;
    private static PreparedStatement removeReservationEntry;
    private static PreparedStatement getWaitlistByDate;
    private static PreparedStatement getReservationBySingleDate;
    private static PreparedStatement getReservationBySingleFaculty;
    private static PreparedStatement getReservationsList;
    private static PreparedStatement getAllReservationEntriesList;
    private static PreparedStatement giveReservationEntryNewRoom;
    private static ResultSet resultSet;
    
    
    // goes through the Reservations table in the DB, putting any waitlisted ReservationEntries into avialable rooms
    public static void updateReservations(){
        boolean restart = false;
        
        ArrayList<ReservationEntry> allReservations = getAllReservationEntriesList();
        for (ReservationEntry reservationEntry: allReservations){
            if (reservationEntry.getRoom() == null && !reservationEntry.getWaitlisted()){
                String faculty = reservationEntry.getFaculty();
                Room room = new Room("Waitlisted", 0);
                Date date = reservationEntry.getDate();
                int seats = reservationEntry.getSeats();
                Timestamp timestamp = reservationEntry.getTimestamp();
                ReservationEntry newReservedEntry = new ReservationEntry(faculty, room, date, seats, timestamp, true);
                giveReservationEntryNewRoom(reservationEntry, newReservedEntry);
                restart = true;
                break;
            }
        }
        
        if (!restart){
            ArrayList<ReservationEntry> waitlist = getWaitlistByDate();
            for (ReservationEntry waitlistedEntry: waitlist){
                Room availableRoom = roomAvailableForEntry(waitlistedEntry);
                if (availableRoom != null){
                    String faculty = waitlistedEntry.getFaculty();
                    Room room = availableRoom;
                    Date date = waitlistedEntry.getDate();
                    int seats = waitlistedEntry.getSeats();
                    Timestamp timestamp = waitlistedEntry.getTimestamp();
                    ReservationEntry newReservedEntry = new ReservationEntry(faculty, room, date, seats, timestamp, false);
                    giveReservationEntryNewRoom(waitlistedEntry, newReservedEntry);
                }
            }
        } else {
            System.out.println("bruh");
            updateReservations();
        }
    }
    
    
    // returns a Room for the (waitlistedEntry), returns null if none available
    public static Room roomAvailableForEntry(ReservationEntry waitlistedEntry){
        if (waitlistedEntry.getWaitlisted() == false){
            return null;
        }
        
        ArrayList<Room> rooms = RoomQueries.getRoomListBySeats();
        ArrayList<ReservationEntry> reservedEntries = getReservationsBySingleDate(waitlistedEntry.getDate());
        
        for (Room room: rooms){
            if (room.getSeats() >= waitlistedEntry.getSeats()){
                boolean roomAvailable = true;
                for (ReservationEntry reservedEntry: reservedEntries){
                    if(room.getName().equals(reservedEntry.getRoom().getName())){
                        roomAvailable = false;
                    }
                }
                
                if (roomAvailable){
                    return room;
                }
            }
        }
        return null;
            
    }
    
    
    // adds a new ReservationEntry to the Reservations table in the DB
    public static void addReservationEntry(ReservationEntry reservationEntry){
        if (!facultyDateInReservationList(reservationEntry.getFaculty(),reservationEntry.getDate())){
            connection = DBConnection.getConnection();
            try{
                addReservationEntry = connection.prepareStatement("insert into reservations (faculty, room, date, seats, timestamp, waitlisted) values (?,?,?,?,?,?)");
                addReservationEntry.setString(1, reservationEntry.getFaculty());
                addReservationEntry.setString(2, reservationEntry.getRoom().getName());
                addReservationEntry.setDate(3,reservationEntry.getDate());
                addReservationEntry.setInt(4,reservationEntry.getSeats());
                addReservationEntry.setTimestamp(5,reservationEntry.getTimestamp());
                addReservationEntry.setBoolean(6,reservationEntry.getWaitlisted());
                addReservationEntry.executeUpdate();

                updateReservations();
            } catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
    }
    
    
    // removes a ReservationEntry from the Reservations table in the DB
    public static void removeReservationEntry(String faculty, Date date){
        if (facultyDateInReservationList(faculty, date)){
            connection = DBConnection.getConnection();
            try{
                removeReservationEntry = connection.prepareStatement("delete from reservations where faculty = ? and date = ?");
                removeReservationEntry.setString(1, faculty);
                removeReservationEntry.setDate(2, date);
                removeReservationEntry.executeUpdate();

                updateReservations();
            } catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
    }
    
    
    // updates a ReservationEntry in Reservations table in the DB to have a new room (Does not check if new room has enough seats!)
    public static void giveReservationEntryNewRoom(ReservationEntry reservationEntry, ReservationEntry newReservationEntry){
        connection = DBConnection.getConnection();
        try{
            String newRoom = newReservationEntry.getRoom().getName();
            String faculty = reservationEntry.getFaculty();
            Date date = reservationEntry.getDate();
            giveReservationEntryNewRoom = connection.prepareStatement("update reservations set room = ?, waitlisted = false where faculty = ? and date = ?");
            giveReservationEntryNewRoom.setString(1, newRoom);
            giveReservationEntryNewRoom.setString(2, faculty);
            giveReservationEntryNewRoom.setDate(3, date);
            giveReservationEntryNewRoom.executeUpdate();
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    
    // returns arraylist of all ReservationEntries that are waitlisted in Reservations table in the DB
    public static ArrayList<ReservationEntry> getWaitlistByDate(){
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> waitlist = new ArrayList<>();
        try{
            getWaitlistByDate = connection.prepareStatement("select * from reservations where waitlisted = true order by date, timestamp");
            resultSet = getWaitlistByDate.executeQuery();
            
            while(resultSet.next()){
                String faculty = resultSet.getString(1);
                Date date = resultSet.getDate(3);
                int seats = resultSet.getInt(4);
                Timestamp timestamp = resultSet.getTimestamp(5);
                ReservationEntry waitlistEntry = new ReservationEntry(faculty, new Room("Waitlisted",0), date, seats, timestamp, true);
                waitlist.add(waitlistEntry);
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return waitlist;
    }
    
    
    // returns arraylist of all ReservationEntries that have a room in Reservations table in the DB
    public static ArrayList<ReservationEntry> getReservationsList(){
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservations = new ArrayList<>();
        try{
            getReservationsList = connection.prepareStatement("select * from reservations where waitlisted = false order by date, room");
            resultSet = getReservationsList.executeQuery();

            while(resultSet.next()){
                String faculty = resultSet.getString(1);
                Room room = RoomQueries.getRoomByName(resultSet.getString(2));
                Date date = resultSet.getDate(3);
                int seats = resultSet.getInt(4);
                Timestamp timestamp = resultSet.getTimestamp(5);
                ReservationEntry reservationEntry = new ReservationEntry(faculty, room, date, seats, timestamp, false);
                reservations.add(reservationEntry);
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return reservations;
    }
    
    
    // returns arraylist of all ReservationEntries with (date) in Reservations table in the DB
    public static ArrayList<ReservationEntry> getReservationsBySingleDate(Date singleDate){
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservations = new ArrayList<>();
        try{
            getReservationBySingleDate = connection.prepareStatement("select * from reservations where waitlisted = false and date = ? order by timestamp");
            getReservationBySingleDate.setDate(1,singleDate);
            resultSet = getReservationBySingleDate.executeQuery();

            while(resultSet.next()){
                String faculty = resultSet.getString(1);
                Room room = RoomQueries.getRoomByName(resultSet.getString(2));
                Date date = resultSet.getDate(3);
                int seats = resultSet.getInt(4);
                Timestamp timestamp = resultSet.getTimestamp(5);
                ReservationEntry reservationEntry = new ReservationEntry(faculty, room, date, seats, timestamp, false);
                reservations.add(reservationEntry);
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return reservations;
    }
    
    
    // returns arraylist of all ReservationEntries with (faculty) in Reservations table in the DB
    public static ArrayList<ReservationEntry> getReservationsBySingleFaculty(String singleFaculty){
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservations = new ArrayList<>();
        try{
            getReservationBySingleFaculty = connection.prepareStatement("select * from reservations where faculty = ? order by date");
            getReservationBySingleFaculty.setString(1,singleFaculty);
            resultSet = getReservationBySingleFaculty.executeQuery();

            while(resultSet.next()){
                String faculty = resultSet.getString(1);
                Room room = null;
                if (resultSet.getString(2).equals("Waitlisted")){
                    room = new Room("Waitlisted",0);
                } else {
                    room = RoomQueries.getRoomByName(resultSet.getString(2));
                }
                Date date = resultSet.getDate(3);
                int seats = resultSet.getInt(4);
                Timestamp timestamp = resultSet.getTimestamp(5);
                boolean waitlisted = resultSet.getBoolean(6);
                ReservationEntry reservationEntry = new ReservationEntry(faculty, room, date, seats, timestamp, waitlisted);
                reservations.add(reservationEntry);
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return reservations;
    }
    
    
    // returns arraylist of all ReservationEntries in Reservations table in the DB
    public static ArrayList<ReservationEntry> getAllReservationEntriesList(){
        connection = DBConnection.getConnection();
        ArrayList<ReservationEntry> reservations = new ArrayList<>();
        try{
            getAllReservationEntriesList = connection.prepareStatement("select * from reservations order by date, faculty");
            resultSet = getAllReservationEntriesList.executeQuery();

            while(resultSet.next()){
                String faculty = resultSet.getString(1);
                Room room = RoomQueries.getRoomByName(resultSet.getString(2));
                Date date = resultSet.getDate(3);
                int seats = resultSet.getInt(4);
                Timestamp timestamp = resultSet.getTimestamp(5);
                boolean waitlisted = resultSet.getBoolean(6);
                ReservationEntry reservationEntry = new ReservationEntry(faculty, room, date, seats, timestamp, waitlisted);
                reservations.add(reservationEntry);
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return reservations;
    }
    
    
    // returns true if there is a reservation/waitlisted for (faculty) on (date)
    public static boolean facultyDateInReservationList(String faculty, Date date){
        ArrayList<ReservationEntry> reservations = getAllReservationEntriesList();
        for (ReservationEntry reservation: reservations){
            if ((faculty.equals(reservation.getFaculty())) && (date.equals(reservation.getDate()))){
                return true;
            }
        }
        return false;
    }
    
    
    // returns the Room if there is a reservation for (faculty) on (date)
    public static Room getRoomByFacultyDate(String faculty, Date date){
        ArrayList<ReservationEntry> reservations = getReservationsBySingleDate(date);
        for (ReservationEntry reservation: reservations){
            if (faculty.equals(reservation.getFaculty())){
                return reservation.getRoom();
            }
        }
        return null;
    }
    
}