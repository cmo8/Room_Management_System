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
/**
 * @Class URM: The main logic of the System.
 * @author Sean
 */
public class URM {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FrmLogin fl = new FrmLogin();
        fl.setVisible(true);
        fl.pack();
    }
}
