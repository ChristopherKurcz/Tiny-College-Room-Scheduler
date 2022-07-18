import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Christopher Kurcz
 */

public class RoomQueries {
    
    private static Connection connection;
    private static ArrayList<Room> rooms = new ArrayList<Room>();
    private static PreparedStatement addRoom;
    private static PreparedStatement removeRoom;
    private static PreparedStatement getRoomListByName;
    private static PreparedStatement getRoomListBySeats;
    private static PreparedStatement getRoomByName;
    private static PreparedStatement inRoomList;
    private static ResultSet resultSet;
    
    
    // adds a Room to the Rooms table in the DB
    public static void addRoom(Room room){
        if (!inRoomList(room.getName())){
            connection = DBConnection.getConnection();
            try{
                addRoom = connection.prepareStatement("insert into rooms (name, seats) values (?,?)");
                addRoom.setString(1, room.getName());
                addRoom.setInt(2, room.getSeats());
                addRoom.executeUpdate();
            } catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        
        ReservationsQueries.updateReservations();
        
    }
    
    
        // adds a Room to the Rooms table in the DB
    public static void removeRoom(Room room){
        if (inRoomList(room.getName())){
            connection = DBConnection.getConnection();
            try{
                removeRoom = connection.prepareStatement("delete from rooms where name = ? and seats = ?");
                removeRoom.setString(1, room.getName());
                removeRoom.setInt(2, room.getSeats());
                removeRoom.executeUpdate();
            } catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        
        ReservationsQueries.updateReservations();
        
    }
    
    
    // returns an arraylist of Rooms sorted by name
    public static ArrayList<Room> getRoomListByName(){
        connection = DBConnection.getConnection();
        ArrayList<Room> rooms = new ArrayList<Room>();
        try{
            getRoomListByName = connection.prepareStatement("select * from rooms order by name");
            resultSet = getRoomListByName.executeQuery();
            
            while(resultSet.next()){
                rooms.add(new Room(resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return rooms;
        
    }
    
    
    // returns an arraylist of Rooms sorted by number of seats
    public static ArrayList<Room> getRoomListBySeats(){
        connection = DBConnection.getConnection();
        ArrayList<Room> rooms = new ArrayList<Room>();
        try{
            getRoomListBySeats = connection.prepareStatement("select * from rooms order by seats");
            resultSet = getRoomListBySeats.executeQuery();
            
            while(resultSet.next()){
                rooms.add(new Room(resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return rooms;
        
    }
    
    
    // returns a room object from the database with (name)
    public static Room getRoomByName(String name){
        if (!inRoomList(name)){
            return null;
        }
        connection = DBConnection.getConnection();
        Room room = null;
        try{
            getRoomByName = connection.prepareStatement("select * from rooms where name = ?");
            getRoomByName.setString(1,name);
            resultSet = getRoomByName.executeQuery();
            
            while(resultSet.next()){
                room = new Room(resultSet.getString(1), resultSet.getInt(2));
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return room;
    }
    
    
    // returns true if (room) is in the Rooms table in the DB, false otherwise
    public static boolean inRoomList(String name){
        connection = DBConnection.getConnection();
        try{
            inRoomList = connection.prepareStatement("select * from rooms where name = ?");
            inRoomList.setString(1,name);
            resultSet = inRoomList.executeQuery();
            
            while(resultSet.next()){
                if (name.equals(resultSet.getString(1))){
                    return true;
                }
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
            return false;
        }
        return false;
    }
    
}