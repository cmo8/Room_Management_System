/**
 * @Project Name: Room Management System.
 * @Package Code: urm
 * @Date Project Started: October 1st, 2013
 * @Date Implementation started: November 13th, 2013
 * @Description: The users of the system will be able to login and the user will be able to reserve 
 * a room and delete your room reservation.
 * @TODO: Add a query that finds all the old outdated reservations in the system and deletes them.
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
 * Class ReservedRoomDAO: This class hands the conversion from the reserved_rooms SQL database to
 * the object oriented Java Language.
 *
 * @author Sean
 */
public class ReservedRoomDAO {

   public Statement statement = null;
   public Connection dbConnection = null;

   /**
    * @Method: getAllReservations
    * @Detail: This retrieves all the reservations that are in the database.
    *
    * @return A list of all the reservations
    * @throws SQLException
    */
   public List<ReservedRooms> getAllReservations() throws SQLException {
      List<ReservedRooms> myList = new ArrayList();
      try {
         MyConnection mc = new MyConnection();
         dbConnection = mc.getConnection();
         statement = dbConnection.createStatement();
         String selectTableSQL = "SELECT * FROM reserved_rooms";//the SQL delete script
         ResultSet rs = statement.executeQuery(selectTableSQL);
         while (rs.next()) {
            Integer reservationNumber = rs.getInt("ReservationNumber");
            String building = rs.getString("Building");
            Integer roomNumber = rs.getInt("RoomNumber");
            Integer day = rs.getInt("Day");
            Integer month = rs.getInt("Month");
            Integer year = rs.getInt("Year");
            Integer startTime = rs.getInt("StartTime");
            Integer endTime = rs.getInt("EndTime");
            String user = rs.getString("UserName");
            ReservedRooms e = new ReservedRooms(reservationNumber, building,
                    roomNumber, day, month, year, startTime, endTime, user);
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
    * @Method: getReservation 
    * @Detail: This connects to the database and filters for the reservations that have the same 
    * user name.
    *
    * @param userName
    * @return A list of all the reservations that have the same user name.
    * @throws SQLException
    */
   public List<ReservedRooms> getUsersReservations(String userName) throws SQLException {
      List<ReservedRooms> myList = new ArrayList();
      try {
         MyConnection mc = new MyConnection();
         dbConnection = mc.getConnection();
         statement = dbConnection.createStatement();
         String selectTableSQL = "SELECT * FROM reserved_rooms WHERE UserName = " + "'" + userName + "'";
         ResultSet rs = statement.executeQuery(selectTableSQL);
         while (rs.next()) {
            Integer reservationNumber = rs.getInt("ReservationNumber");
            String building = rs.getString("Building");
            Integer roomNumber = rs.getInt("RoomNumber");
            Integer day = rs.getInt("Day");
            Integer month = rs.getInt("Month");
            Integer year = rs.getInt("Year");
            Integer startTime = rs.getInt("StartTime");
            Integer endTime = rs.getInt("EndTime");
            String user = rs.getString("UserName");
            ReservedRooms e = new ReservedRooms(reservationNumber, building,
                    roomNumber, day, month, year, startTime, endTime, user);
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
    * @Method: getReservation
    * @Detail: This connects to the database and filters for the reservations that have the same
    * building name, room number, day, month, year, start time, end time and user name.
    *
    * @param buildingName
    * @param roomNumber
    * @param day
    * @param month
    * @param year
    * @param startTime
    * @param endTime
    * @param userName
    * @return A list of the filtered reservations. Do to the logic there should only be one
    * reservations with all the same fields.
    * @throws SQLException
    */
   public List<ReservedRooms> getReservation(String buildingName, Integer roomNumber,
           Integer day, Integer month, Integer year, Integer startTime, Integer endTime, String userName) throws SQLException {
      List<ReservedRooms> mylist = new ArrayList();
      try {
         MyConnection mc = new MyConnection();
         dbConnection = mc.getConnection();
         statement = dbConnection.createStatement();
         String selectTableSQL = "SELECT * FROM reserved_rooms" //the SQL delete script
                 + " WHERE Building = " + "'" + buildingName + "'" //the SQL delete script
                 + " AND RoomNumber = " + "'" + roomNumber + "'" + " AND Day = " //the SQL delete script
                 + "'" + day + "'" + " AND Month = " + "'" + month + "'" //the SQL delete script
                 + " AND Year = " + "'" + year + "'" + " AND StartTime = " + "'" + startTime + "'" //the SQL delete script
                 + " AND EndTime = " + "'" + endTime + "'" + " AND UserName = " + "'" + userName //the SQL delete script
                 + "'";                                                                            //the SQL delete script
         ResultSet rs = statement.executeQuery(selectTableSQL);
         while (rs.next()) {
            Integer reservationNumber = rs.getInt("ReservationNumber");
            ReservedRooms e = new ReservedRooms(reservationNumber, buildingName,
                    roomNumber, day, month, year, startTime, endTime, userName);

            System.out.println("Reservation Number: " + reservationNumber);
            System.out.println("Building NAME: " + buildingName + " " + roomNumber);
            System.out.println("Date: " + month + "/" + day + "/" + year);
            System.out.println("Start Time: " + startTime);
            System.out.println("End Time: " + endTime);
            System.out.println("User Name: " + userName);

            mylist.add(e);
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
      return mylist;
   }

   /**
    * @Method: getBRoomDateReservations
    * @Detail: This connects to the database and filters for the reservations that have the same
    * building name, room number, day, month and year
    *
    * @param buildingName
    * @param roomNumber
    * @param day
    * @param month
    * @param year
    * @return An ordered list of the reservations for that day in ascending order.
    * @throws SQLException
    */
   public List<ReservedRooms> getBRoomDateReservations(String buildingName, Integer roomNumber,
           Integer day, Integer month, Integer year) throws SQLException {

      List<ReservedRooms> mylist = new ArrayList();
      try {
         MyConnection mc = new MyConnection();
         dbConnection = mc.getConnection();
         statement = dbConnection.createStatement();
         String selectTableSQL = "SELECT * FROM reserved_rooms" //the SQL delete script
                 + " WHERE Building = " + "'" + buildingName + "'" //the SQL delete script
                 + " AND RoomNumber = " + "'" + roomNumber + "'" + " AND Day = " //the SQL delete script
                 + "'" + day + "'" + " AND Month = " + "'" + month + "'" //the SQL delete script
                 + " AND Year = " + "'" + year + "' ORDER BY StartTime ASC";     //the SQL delete script
         ResultSet rs = statement.executeQuery(selectTableSQL);
         while (rs.next()) {
            Integer reservationNumber = rs.getInt("ReservationNumber");
            Integer startTime = rs.getInt("StartTime");
            Integer endTime = rs.getInt("EndTime");
            String user = rs.getString("UserName");
            ReservedRooms e = new ReservedRooms(reservationNumber, buildingName,
                    roomNumber, day, month, year, startTime, endTime, user);

            System.out.println("Reservation Number: " + reservationNumber);
            System.out.println("Building NAME: " + buildingName + " " + roomNumber);
            System.out.println("Date: " + month + "/" + day + "/" + year);
            System.out.println("Start Time: " + startTime);
            System.out.println("End Time: " + endTime);
            System.out.println("User Name: " + user);

            mylist.add(e);
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
      return mylist;
   }

   /**
    * @Method: insertReservation
    * @Detail: This connects to the database and inserts a reservation into the database
    *
    * @param buildingName
    * @param roomNumber
    * @param day
    * @param month
    * @param year
    * @param startTime
    * @param endTime
    * @param user
    * @throws SQLException
    */
   public void insertReservation(String buildingName, int roomNumber, int day,
           int month, int year, int startTime, int endTime, String user) throws SQLException {
      String insertTableSQL = "INSERT INTO `reserved_rooms`(`Building`, `RoomNumber`, `Day`, `Month" //the SQL delete script
              + "`, `Year`, `StartTime`, `EndTime`, `UserName`) VALUES ( '" //the SQL delete script
              + buildingName + "', " + roomNumber + ", " + day + ", " + month + ", " + year + ", " //the SQL delete script
              + startTime + ", " + endTime + ", '" + user + "' )";                                   //the SQL delete script
      System.out.println(insertTableSQL);
      try {
         MyConnection mc = new MyConnection();
         dbConnection = mc.getConnection();
         statement = dbConnection.createStatement();

         //System.err.println(insertTableSQL);
         // execute insert SQL stetement
         statement.executeUpdate(insertTableSQL);

         System.out.println("Record is inserted into Student table!");

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

   /**
    * @Method: deleteReservation 
    * @Detail: This connects to the database and deletes the record with
    * the corresponding reservation number from the database
    *
    * @param reservationNumber
    * @throws SQLException
    */
   public void deleteReservation(int reservationNumber) throws SQLException {
      String insertTableSQL = "DELETE FROM reserved_rooms" //the SQL delete script
              + " WHERE ReservationNumber = " + reservationNumber;        //the SQL delete script
      try {
         MyConnection mc = new MyConnection();
         dbConnection = mc.getConnection();
         statement = dbConnection.createStatement();
         // execute delete SQL stetement
         statement.executeUpdate(insertTableSQL);
         System.out.println("Record is deleted from reservation table!");
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
