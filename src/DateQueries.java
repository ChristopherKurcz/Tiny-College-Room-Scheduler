import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Christopher Kurcz
 */


public class DateQueries{
    
    private static Connection connection;
    private static PreparedStatement addDate;
    private static PreparedStatement getDateList;
    private static PreparedStatement inDateList;
    private static ResultSet resultSet;
    
    
    // adds a date to the dates table in the DB
    public static void addDate(Date date){
        if (!inDateList(date)){
            connection = DBConnection.getConnection();
            try{
                addDate = connection.prepareStatement("insert into dates (date) values (?)");
                addDate.setDate(1, date);
                addDate.executeUpdate();
            } catch(SQLException sqlException){
                sqlException.printStackTrace();
            }
        }
        
    }
    
    
    // returns an arrayList of Dates in the Dates table in the DB
    public static ArrayList<Date> getDateList(){
        connection = DBConnection.getConnection();
        ArrayList<Date> dates = new ArrayList<>();
        try{
            getDateList = connection.prepareStatement("select date from dates order by date");
            resultSet = getDateList.executeQuery();
            
            while(resultSet.next()){
                dates.add(resultSet.getDate(1));
            }
        } catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return dates;
        
    }
    
    
    // returns true if (date) is in the dates table in the DB, false otherwise
    public static boolean inDateList(Date date){
        connection = DBConnection.getConnection();
        try{
            inDateList = connection.prepareStatement("select * from dates where date = ?");
            inDateList.setDate(1,date);
            resultSet = inDateList.executeQuery();
            
            while(resultSet.next()){
                if (date.equals(resultSet.getDate(1))){
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