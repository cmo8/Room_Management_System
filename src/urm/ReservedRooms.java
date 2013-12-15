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

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @Class ReservedRooms: This is NetBeans generated code. This is the object that stores a record 
 * from the reserve_room database. No further commenting in this class at this time(11/29/2013).
 * @author Sean
 */
@Entity
@Table(name = "reserved_rooms", catalog = "room_management_db", schema = "")
@NamedQueries({
   @NamedQuery(name = "ReservedRooms.findAll", query = "SELECT r FROM ReservedRooms r"),
   @NamedQuery(name = "ReservedRooms.findByReservationNumber", query = "SELECT r FROM ReservedRooms r WHERE r.reservationNumber = :reservationNumber"),
   @NamedQuery(name = "ReservedRooms.findByRoomNumber", query = "SELECT r FROM ReservedRooms r WHERE r.roomNumber = :roomNumber"),
   @NamedQuery(name = "ReservedRooms.findByDay", query = "SELECT r FROM ReservedRooms r WHERE r.day = :day"),
   @NamedQuery(name = "ReservedRooms.findByMonth", query = "SELECT r FROM ReservedRooms r WHERE r.month = :month"),
   @NamedQuery(name = "ReservedRooms.findByYear", query = "SELECT r FROM ReservedRooms r WHERE r.year = :year"),
   @NamedQuery(name = "ReservedRooms.findByStartTime", query = "SELECT r FROM ReservedRooms r WHERE r.startTime = :startTime"),
   @NamedQuery(name = "ReservedRooms.findByEndTime", query = "SELECT r FROM ReservedRooms r WHERE r.endTime = :endTime")})
public class ReservedRooms implements Serializable {
   @Transient
   private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "ReservationNumber")
   private Integer reservationNumber;
   @Basic(optional = false)
   @Lob
   @Column(name = "Building")
   private String building;
   @Basic(optional = false)
   @Column(name = "RoomNumber")
   private int roomNumber;
   @Basic(optional = false)
   @Column(name = "Day")
   private int day;
   @Basic(optional = false)
   @Column(name = "Month")
   private int month;
   @Basic(optional = false)
   @Column(name = "Year")
   private int year;
   @Basic(optional = false)
   @Column(name = "StartTime")
   private int startTime;
   @Basic(optional = false)
   @Column(name = "EndTime")
   private int endTime;
   @Basic(optional = false)
   @Lob
   @Column(name = "UserName")
   private String userName;

   public ReservedRooms() {
   }

   public ReservedRooms(Integer reservationNumber) {
      this.reservationNumber = reservationNumber;
   }

   public ReservedRooms(Integer reservationNumber, String building, int roomNumber, int day, int month, int year, int startTime, int endTime, String userName) {
      this.reservationNumber = reservationNumber;
      this.building = building;
      this.roomNumber = roomNumber;
      this.day = day;
      this.month = month;
      this.year = year;
      this.startTime = startTime;
      this.endTime = endTime;
      this.userName = userName;
   }

   public Integer getReservationNumber() {
      return reservationNumber;
   }

   public void setReservationNumber(Integer reservationNumber) {
      Integer oldReservationNumber = this.reservationNumber;
      this.reservationNumber = reservationNumber;
      changeSupport.firePropertyChange("reservationNumber", oldReservationNumber, reservationNumber);
   }

   public String getBuilding() {
      return building;
   }

   public void setBuilding(String building) {
      String oldBuilding = this.building;
      this.building = building;
      changeSupport.firePropertyChange("building", oldBuilding, building);
   }

   public int getRoomNumber() {
      return roomNumber;
   }

   public void setRoomNumber(int roomNumber) {
      int oldRoomNumber = this.roomNumber;
      this.roomNumber = roomNumber;
      changeSupport.firePropertyChange("roomNumber", oldRoomNumber, roomNumber);
   }

   public int getDay() {
      return day;
   }

   public void setDay(int day) {
      int oldDay = this.day;
      this.day = day;
      changeSupport.firePropertyChange("day", oldDay, day);
   }

   public int getMonth() {
      return month;
   }

   public void setMonth(int month) {
      int oldMonth = this.month;
      this.month = month;
      changeSupport.firePropertyChange("month", oldMonth, month);
   }

   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      int oldYear = this.year;
      this.year = year;
      changeSupport.firePropertyChange("year", oldYear, year);
   }

   public int getStartTime() {
      return startTime;
   }

   public void setStartTime(int startTime) {
      int oldStartTime = this.startTime;
      this.startTime = startTime;
      changeSupport.firePropertyChange("startTime", oldStartTime, startTime);
   }

   public int getEndTime() {
      return endTime;
   }

   public void setEndTime(int endTime) {
      int oldEndTime = this.endTime;
      this.endTime = endTime;
      changeSupport.firePropertyChange("endTime", oldEndTime, endTime);
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      String oldUserName = this.userName;
      this.userName = userName;
      changeSupport.firePropertyChange("userName", oldUserName, userName);
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (reservationNumber != null ? reservationNumber.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof ReservedRooms)) {
         return false;
      }
      ReservedRooms other = (ReservedRooms) object;
      if ((this.reservationNumber == null && other.reservationNumber != null) || (this.reservationNumber != null && !this.reservationNumber.equals(other.reservationNumber))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "urm.ReservedRooms[ reservationNumber=" + reservationNumber + " ]";
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      changeSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      changeSupport.removePropertyChangeListener(listener);
   }
   
}
