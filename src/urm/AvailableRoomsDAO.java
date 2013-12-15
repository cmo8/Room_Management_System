/**
 * @Project Name: Room Management System.
 * @Package Code: urm
 * @Date Project Started: October 1st, 2013
 * @Date Implementation started: November 13th, 2013
 * @Description: The users of the system will be able to login and the user will be able to reserve 
 * a room and delete your room reservation.
 * @TODO: Write a query that gets all the distinct building in the available_rooms database
 * @author: Sean Morgan
 */
package urm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Class AvailableRoomsDAO: This class hands the conversion from the available_rooms SQL database to
 * the object oriented Java Language.
 * @author Sean
 */
public class AvailableRoomsDAO {
   public Statement statement = null;
   public Connection dbConnection = null;
/**
 * @Method: getAllAvailableRooms
 * @Detail: This sends a query to the available_rooms database to get all of the available rooms it 
 * has in it.
 * @return The list of all of the rooms in the database
 * @throws SQLException 
 */
   public List<AvailableRooms> getAllAvailableRooms() throws SQLException {
      List<AvailableRooms> myList = new ArrayList();
      try {
         MyConnection mc = new MyConnection();
         dbConnection = mc.getConnection();
         statement = dbConnection.createStatement();
         String selectTableSQL = "SELECT * FROM available_rooms";
         ResultSet rs = statement.executeQuery(selectTableSQL);
         while (rs.next()) {
            Integer index = rs.getInt("Index");
            String building = rs.getString("Building");
            Integer roomNumber = rs.getInt("RoomNumber");
            String roomType = rs.getString("RoomType");
            AvailableRooms e = new AvailableRooms(index, building, roomNumber, roomType);
            myList.add(e);
         }
      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      } finally {
         if (statement != null) {
            statement.close();
         }
         if (dbConnection != null) {
            dbConnection.close();
         }
      }
      return myList;
   }
   /**
    * @Method: getTypeRoomNumbers
    * @Detail: This sends a query to the available_rooms database to get all of the available rooms 
    * with a specific room type like class room or computer lab
    * @param roomType
    * @return The list of all the rooms for that room type
    * @throws SQLException 
    */
   public List<AvailableRooms> getTypeRoomNumbers(String building, String roomType) throws SQLException {
      List<AvailableRooms> myList = new ArrayList();
      try {
         MyConnection mc = new MyConnection();
         dbConnection = mc.getConnection();
         statement = dbConnection.createStatement();
         String selectTableSQL = "SELECT * FROM available_rooms WHERE Building = '" + building +
                 "' AND RoomType = " + "'" + roomType + "'" + "ORDER BY RoomNumber ASC";
         ResultSet rs = statement.executeQuery(selectTableSQL);
         while (rs.next()) {
            Integer index = rs.getInt("Index");
            Integer roomNumber = rs.getInt("RoomNumber");
            AvailableRooms e = new AvailableRooms(index, building, roomNumber, roomType);
            myList.add(e);
         }
      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      } finally {
         if (statement != null) {
            statement.close();
         }
         if (dbConnection != null) {
            dbConnection.close();
         }
      }
      return myList;
   }
   /**
    * @Method: getRoomNumbers
    * @Detail: This sends a query to the available_rooms database to get all of the available rooms 
    * with a specific building name
    * @param building
    * @return The list of all the rooms that are in that building
    * @throws SQLException 
    */
public List<AvailableRooms> getRoomNumbers(String building) throws SQLException {
      List<AvailableRooms> myList = new ArrayList();
      try {
         MyConnection mc = new MyConnection();
         dbConnection = mc.getConnection();
         statement = dbConnection.createStatement();
         String selectTableSQL = "SELECT * FROM available_rooms WHERE Building = " + "'" + building 
                 + "'" + "ORDER BY RoomNumber ASC";
         ResultSet rs = statement.executeQuery(selectTableSQL);
         while (rs.next()) {
            Integer index = rs.getInt("Index");
            Integer roomNumber = rs.getInt("RoomNumber");
            String roomType = rs.getString("RoomType");
            AvailableRooms e = new AvailableRooms(index, building, roomNumber, roomType);
            myList.add(e);
         }
      } catch (SQLException ex) {
         System.out.println(ex.getMessage());
      } finally {
         if (statement != null) {
            statement.close();
         }
         if (dbConnection != null) {
            dbConnection.close();
         }
      }
      return myList;
   }
/**
 * @Method: insertRoom
 * @Detail: This inserts a room into the available_rooms database with the building name and type of
 * room that it is
 * @param building
 * @param roomNumber
 * @param roomType
 * @return
 * @throws SQLException 
 */
   public boolean insertRoom( String building, int roomNumber, int roomType) throws SQLException {
       String insertTableSQL = "INSERT INTO available_rooms " + "(Building, RoomNumber, RoomType) " 
               + "VALUES" + "('" + building + "','" + roomNumber + "'," + "'" + roomType + "')";
         try {
            MyConnection mc = new MyConnection();
            dbConnection = mc.getConnection();
            statement = dbConnection.createStatement();
            //System.err.println(insertTableSQL);
            // execute insert SQL stetement
            statement.executeUpdate(insertTableSQL);
            System.out.println("Room is inserted into rooms table!");
         } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
         } finally {
            if (statement != null) {
               statement.close();
            }
            if (dbConnection != null) {
               dbConnection.close();
            }
         }
         return true;
   }
   /**
    * @Method: deleteRoom
    * @Detail: This sends a query to delete a room from the available_rooms database.
    * @param roomIDNum
    * @throws SQLException 
    */
   public void deleteRoom(int roomIDNum) throws SQLException {
      String insertTableSQL = "DELETE FROM available_rooms" + " WHERE Index = " + roomIDNum;
         try {
            MyConnection mc = new MyConnection();
            dbConnection = mc.getConnection();
            statement = dbConnection.createStatement();
            //System.err.println(insertTableSQL);
            // execute insert SQL stetement
            statement.executeUpdate(insertTableSQL);
            System.out.println("Room is deleted from Rooms table!");
         } catch (SQLException e) {
            System.out.println(e.getMessage());
         } finally {
            if (statement != null) {
               statement.close();
            }
            if (dbConnection != null) {
               dbConnection.close();
            }
         }
      }   
}
