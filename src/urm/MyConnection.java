/**
 * @Project Name: Room Management System.
 * @Package Code: urm
 * @Date Project Started: October 1st, 2013
 * @Date Implementation started: November 13th, 2013
 * @Description: The users of the system will be able to login and the user will be able to reserve 
 * a room and delete your room reservation.
 *
 * @author: Sean Morgan
 */
package urm;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * @Class MyConnection: This Connects the Room Management System up with the database.
 * @author Sean
 */
class MyConnection {
    public Connection connection = null;
    /**
     * @Method: getConnection
     * @Detail: This tries to connect to the MySQL room_management_db database that is running in
     * the background.
     * @return The connection that it created
     */
    public Connection getConnection(){
        System.out.println("------Mysql Connection Test------");
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Where is MySQL Driver?");
            ex.printStackTrace();
            //return;
        }
        System.out.println("Mysql Driver Registered!");
        //Connection connection = null;
        connection = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/room_management_db","root","");
        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console");
            ex.printStackTrace();
            //return;
        }
        if (connection != null) {
            System.out.println("You made it, take control you database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
        return connection;
    }
}
