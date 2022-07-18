import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Christopher Kurcz
 */


public class FacultyQueries{
    
    private static Connection connection;
    private static PreparedStatement addFaculty;
    private static PreparedStatement getFacultyList;
    private static PreparedStatement inFacultyList;
    private static ResultSet resultSet;
    
    
    // adds a faculty member's name to the Faculty table in the DB
    public static void addFaculty(String name){
        if (!inFacultyList(name)){
            connection = DBConnection.getConnection();
            try{
                addFaculty = connection.prepareStatement("insert into faculty (name) values (?)");
                addFaculty.setString(1, name);
                addFaculty.executeUpdate();
            } catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        
    }
    
    
    // returns an arrayList of names in the Faculty table in the DB
    public static ArrayList<String> getFacultyList(){
        connection = DBConnection.getConnection();
        ArrayList<String> faculty = new ArrayList<>();
        try{
            getFacultyList = connection.prepareStatement("select name from faculty order by name");
            resultSet = getFacultyList.executeQuery();
            
            while(resultSet.next()){
                faculty.add(resultSet.getString(1));
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return faculty;
        
    }
    
    
    // returns true if (name) is in the faculty table in the DB, false otherwise
    public static boolean inFacultyList(String name){
        connection = DBConnection.getConnection();
        try{
            inFacultyList = connection.prepareStatement("select * from faculty where name = ?");
            inFacultyList.setString(1,name);
            resultSet = inFacultyList.executeQuery();
            
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