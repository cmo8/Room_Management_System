/**
 * @Project Name: Room Management System.
 * @Package Code: urm
 * @Date Project Started: October 1st, 2013
 * @Date Implementation started: November 13th, 2013
 * @Description: The users of the system will be able to login and the user will be able to reserve
 * a room and delete your room reservation.
 * @TODO: Implement the Add and delete available rooms from the available_rooms database.
 * @author: Sean Morgan
 */
package urm;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @Class FrmReservations: This is the Administrator view. This form shows the administrator all the
 * reservations that are is the database and they can either go to the add reservation form or
 * delete any reservation that they want or need to because of some event that comes up. They can
 * also view all the buildings and rooms that are in the available_rooms database. They can add and
 * remove rooms as they need.
 * @author Sean
 */
public class FrmReservations extends javax.swing.JFrame {

   private FrmMenu frmMenu;
   private String userName;

   /**
    * Creates new form Reservations
    */
   public FrmReservations() {
      initComponents();
   }

   /**
    * This method is called from within the constructor to initialize the form. WARNING: Do NOT
    * modify this code. The content of this method is always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jMenuBar2 = new javax.swing.JMenuBar();
      jMenu2 = new javax.swing.JMenu();
      jMenu3 = new javax.swing.JMenu();
      btnBack = new javax.swing.JButton();
      jTabbedPane1 = new javax.swing.JTabbedPane();
      jPanel1 = new javax.swing.JPanel();
      btnDeleteReservation = new javax.swing.JButton();
      btnAddReservation = new javax.swing.JButton();
      jScrollPane5 = new javax.swing.JScrollPane();
      jTable2 = new javax.swing.JTable();
      jLabel2 = new javax.swing.JLabel();
      jPanel2 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      btnAddRoom = new javax.swing.JButton();
      btnDeleteRoom = new javax.swing.JButton();
      jScrollPane4 = new javax.swing.JScrollPane();
      jTable4 = new javax.swing.JTable();
      jMenuBar1 = new javax.swing.JMenuBar();
      jMenu1 = new javax.swing.JMenu();
      mbnExit = new javax.swing.JMenuItem();

      jMenu2.setText("File");
      jMenuBar2.add(jMenu2);

      jMenu3.setText("Edit");
      jMenuBar2.add(jMenu3);

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      btnBack.setText("Back");
      btnBack.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBackActionPerformed(evt);
         }
      });

      btnDeleteReservation.setText("Delete Reservation");
      btnDeleteReservation.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteReservationActionPerformed(evt);
         }
      });

      btnAddReservation.setText("Add Reservation");
      btnAddReservation.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddReservationActionPerformed(evt);
         }
      });

      jTable2.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Reservation Number", "Building Name", "Room Number", "Day", "Month", "Year", "Start Time", "End Time", "Reserved For"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }
      });
      jScrollPane5.setViewportView(jTable2);

      jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      jLabel2.setText("All Reservations");

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(jLabel2)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addGap(10, 10, 10)
                  .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(btnDeleteReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(btnAddReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGap(20, 20, 20))
      );
      jPanel1Layout.setVerticalGroup(
         jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel1Layout.createSequentialGroup()
                  .addComponent(btnAddReservation)
                  .addGap(15, 15, 15)
                  .addComponent(btnDeleteReservation))
               .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(31, Short.MAX_VALUE))
      );

      jTabbedPane1.addTab("All Reservations", jPanel1);

      jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      jLabel1.setText("Rooms");

      btnAddRoom.setText("Add Room");
      btnAddRoom.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddRoomActionPerformed(evt);
         }
      });

      btnDeleteRoom.setText("Delete Room");
      btnDeleteRoom.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnDeleteRoomActionPerformed(evt);
         }
      });

      jTable4.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {

         },
         new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
         }
      ) {
         Class[] types = new Class [] {
            java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
         };

         public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
         }
      });
      jScrollPane4.setViewportView(jTable4);
      if (jTable4.getColumnModel().getColumnCount() > 0) {
         jTable4.getColumnModel().getColumn(0).setPreferredWidth(20);
         jTable4.getColumnModel().getColumn(1).setPreferredWidth(60);
         jTable4.getColumnModel().getColumn(2).setResizable(false);
         jTable4.getColumnModel().getColumn(2).setPreferredWidth(20);
         jTable4.getColumnModel().getColumn(3).setPreferredWidth(60);
      }

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(btnAddRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(btnDeleteRoom, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
               .addComponent(jLabel1))
            .addContainerGap(31, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addGroup(jPanel2Layout.createSequentialGroup()
                  .addComponent(btnAddRoom)
                  .addGap(15, 15, 15)
                  .addComponent(btnDeleteRoom)))
            .addContainerGap(57, Short.MAX_VALUE))
      );

      jTabbedPane1.addTab("All Rooms", jPanel2);

      jMenu1.setText("File");

      mbnExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
      mbnExit.setText("Exit");
      mbnExit.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            mbnExitActionPerformed(evt);
         }
      });
      jMenu1.add(mbnExit);

      jMenuBar1.add(jMenu1);

      setJMenuBar(jMenuBar1);

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(551, 551, 551)
                  .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(23, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(btnBack)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents
/**
    * @Method: btnAddReservationActionPerformed
    * @Detail: This button takes the administrator to the reserve room form and finds this form.
    * @param evt
    */
   private void btnAddReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddReservationActionPerformed
      FrmReserveRoom frmReserveRoom = new FrmReserveRoom();
      frmReserveRoom.pack();
      frmReserveRoom.getCreds(userName, frmMenu);
      frmReserveRoom.setVisible(true);
      this.setVisible(false);
   }//GEN-LAST:event_btnAddReservationActionPerformed
   /**
    * @Method: btnBackActionPerformed
    * @Detail: This button hides the current form and shows the Menu form
    * @param evt
    */
   private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
      this.setVisible(false);
      frmMenu.setVisible(true);
   }//GEN-LAST:event_btnBackActionPerformed
   /**
    * @Method: btnAddRoomActionPerformed
    * @Detail: This button adds a building and room to the available_rooms database and reloads the
    * table
    * @param evt
    */
   private void btnAddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRoomActionPerformed
      JOptionPane.showMessageDialog(null, "Not implemented yet" + '\n' + "To add a room go to phpMyAdmin.", "Sorry", JOptionPane.INFORMATION_MESSAGE);
   }//GEN-LAST:event_btnAddRoomActionPerformed
   /**
    * @Method: btnDeleteReservationActionPerformed
    * @Detail: This button deletes the selected reservation and reloads the table
    * @param evt
    */
   private void btnDeleteReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteReservationActionPerformed
      int row = jTable2.getSelectedRow();
      if (row != -1) {
         int d = (int) jTable2.getValueAt(row, 0);
         ReservedRoomDAO stu = new ReservedRoomDAO();
         try {
            stu.deleteReservation(d);
         } catch (SQLException ex) {
            //Logger.getLogger(this.class.getName()).log(Level.SERVER, null, ex);
         }
      }
      jTable2.removeAll();
      LoadReservedRooms();
   }//GEN-LAST:event_btnDeleteReservationActionPerformed
   /**
    * @Method: btnDeleteRoomActionPerformed
    * @Detail: This deletes the selected room from the available_room reservation
    * @param evt
    */
   private void btnDeleteRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRoomActionPerformed
      JOptionPane.showMessageDialog(null, "Not implemented yet" + '\n' + "To delete a room go to phpMyAdmin.", "Sorry", JOptionPane.INFORMATION_MESSAGE);
   }//GEN-LAST:event_btnDeleteRoomActionPerformed
   /**
    * @Method: mbnExitActionPerformed
    * @Detail: Closes the application
    * @param evt
    */
   private void mbnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbnExitActionPerformed
      System.exit(0);
   }//GEN-LAST:event_mbnExitActionPerformed

   /**
    * @param args the command line arguments
    */
   public static void main(String args[]) {
      /* Set the Nimbus look and feel */
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
       * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
       */
      try {
         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               javax.swing.UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException ex) {
         java.util.logging.Logger.getLogger(FrmReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(FrmReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(FrmReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(FrmReservations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
         public void run() {
            new FrmReservations().setVisible(true);
         }
      });
   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAddReservation;
   private javax.swing.JButton btnAddRoom;
   private javax.swing.JButton btnBack;
   private javax.swing.JButton btnDeleteReservation;
   private javax.swing.JButton btnDeleteRoom;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JMenu jMenu1;
   private javax.swing.JMenu jMenu2;
   private javax.swing.JMenu jMenu3;
   private javax.swing.JMenuBar jMenuBar1;
   private javax.swing.JMenuBar jMenuBar2;
   private javax.swing.JPanel jPanel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JScrollPane jScrollPane4;
   private javax.swing.JScrollPane jScrollPane5;
   private javax.swing.JTabbedPane jTabbedPane1;
   private javax.swing.JTable jTable2;
   private javax.swing.JTable jTable4;
   private javax.swing.JMenuItem mbnExit;
   // End of variables declaration//GEN-END:variables
   /**
    * @Method: getCreds
    * @Detail: This is called from the Menu to pass the current user information and the Menu form
    * reference. Then it loads the two tables
    * @param inUser
    * @param inFrmMenu
    */
   void getCreds(String inUser, FrmMenu inFrmMenu) {
      userName = inUser;
      frmMenu = inFrmMenu;
      LoadReservedRooms();
      LoadAvailableRooms();
   }

   /**
    * @Method: LoadReservedRooms
    * @Detail: This loads the table with all the reservations from the reserved_rooms_db.
    */
   private void LoadReservedRooms() {
      ReservedRoomDAO stu = new ReservedRoomDAO();
      ArrayList<ReservedRooms> myList = new ArrayList<ReservedRooms>();
      try {
         for (Object em : (ArrayList) stu.getAllReservations()) {
            myList.add((ReservedRooms) em);
         }
      } catch (SQLException ex) {
         //Logger.getLogger(this.class.getName()).log(Level.SERVER, null, ex);
      }
      DefaultTableModel amod = new DefaultTableModel();
      Object[] tableColumnNames = new Object[9];
      tableColumnNames[0] = "Reservation Number";
      tableColumnNames[1] = "Building Name";
      tableColumnNames[2] = "Room Number";
      tableColumnNames[3] = "Day";
      tableColumnNames[4] = "Month";
      tableColumnNames[5] = "Year";
      tableColumnNames[6] = "Start Time";
      tableColumnNames[7] = "End Time";
      tableColumnNames[8] = "UserName";
      amod.setColumnIdentifiers(tableColumnNames);
      Object[] obj = new Object[9];
      if (myList.size() > 0) {
         for (int i = 0; i < myList.size(); i++) {
            ReservedRooms hashmap = myList.get(i);
            obj[0] = hashmap.getReservationNumber().intValue();
            obj[1] = hashmap.getBuilding().toString();
            obj[2] = hashmap.getRoomNumber();
            obj[3] = hashmap.getDay();
            obj[4] = hashmap.getMonth();
            obj[5] = hashmap.getYear();
            obj[6] = hashmap.getStartTime();
            obj[7] = hashmap.getEndTime();
            obj[8] = hashmap.getUserName().toString();
            amod.addRow(obj);
         }
         this.jTable2.setModel(amod);
      }
   }

   /**
    * @Method: LoadAvailableRooms
    * @Detail: This loads the table with all the available rooms from the available_rooms_db.
    */
   private void LoadAvailableRooms() {
      AvailableRoomsDAO stu = new AvailableRoomsDAO();
      ArrayList<AvailableRooms> myList = new ArrayList<AvailableRooms>();
      try {
         for (Object em : (ArrayList) stu.getAllAvailableRooms()) {
            myList.add((AvailableRooms) em);
         }
      } catch (SQLException ex) {
         //Logger.getLogger(this.class.getName()).log(Level.SERVER, null, ex);
      }
      DefaultTableModel amod = new DefaultTableModel();
      Object[] tableColumnNames = new Object[4];
      tableColumnNames[0] = "Room ID";
      tableColumnNames[1] = "Building Name";
      tableColumnNames[2] = "Room Number";
      tableColumnNames[3] = "Room Type";
      amod.setColumnIdentifiers(tableColumnNames);
      Object[] obj = new Object[9];
      if (myList.size() > 0) {
         for (int i = 0; i < myList.size(); i++) {
            AvailableRooms hashmap = myList.get(i);
            obj[0] = hashmap.getIndex().intValue();
            obj[1] = hashmap.getBuilding().toString();
            obj[2] = hashmap.getRoomNumber();
            obj[3] = hashmap.getRoomType().toString();
            amod.addRow(obj);
         }
         this.jTable4.setModel(amod);
      }
   }
}