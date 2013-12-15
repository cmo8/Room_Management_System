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
 *@Class AvalibleRooms: This is NetBeans generated code. This is the object that stores a record 
 * from the available_rooms database. No further commenting in this class at this time(11/29/2013).
 * @author Sean
 */
@Entity
@Table(name = "available_rooms", catalog = "room_management_db", schema = "")
@NamedQueries({
   @NamedQuery(name = "AvalibleRooms.findAll", query = "SELECT a FROM AvalibleRooms a"),
   @NamedQuery(name = "AvalibleRooms.findByIndex", query = "SELECT a FROM AvalibleRooms a WHERE a.index = :index"),
   @NamedQuery(name = "AvalibleRooms.findByRoomNumber", query = "SELECT a FROM AvalibleRooms a WHERE a.roomNumber = :roomNumber")})
public class AvailableRooms implements Serializable {
   @Transient
   private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Basic(optional = false)
   @Column(name = "Index")
   private Integer index;
   @Basic(optional = false)
   @Lob
   @Column(name = "Building")
   private String building;
   @Basic(optional = false)
   @Column(name = "RoomNumber")
   private int roomNumber;
   @Basic(optional = false)
   @Lob
   @Column(name = "RoomType")
   private String roomType;

   public AvailableRooms() {
   }

   public AvailableRooms(Integer index) {
      this.index = index;
   }

   public AvailableRooms(Integer index, String building, int roomNumber, String roomType) {
      this.index = index;
      this.building = building;
      this.roomNumber = roomNumber;
      this.roomType = roomType;
   }

   public Integer getIndex() {
      return index;
   }

   public void setIndex(Integer index) {
      Integer oldIndex = this.index;
      this.index = index;
      changeSupport.firePropertyChange("index", oldIndex, index);
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

   public String getRoomType() {
      return roomType;
   }

   public void setRoomType(String roomType) {
      String oldRoomType = this.roomType;
      this.roomType = roomType;
      changeSupport.firePropertyChange("roomType", oldRoomType, roomType);
   }

   @Override
   public int hashCode() {
      int hash = 0;
      hash += (index != null ? index.hashCode() : 0);
      return hash;
   }

   @Override
   public boolean equals(Object object) {
      // TODO: Warning - this method won't work in the case the id fields are not set
      if (!(object instanceof AvailableRooms)) {
         return false;
      }
      AvailableRooms other = (AvailableRooms) object;
      if ((this.index == null && other.index != null) || (this.index != null && !this.index.equals(other.index))) {
         return false;
      }
      return true;
   }

   @Override
   public String toString() {
      return "urm.AvalibleRooms[ index=" + index + " ]";
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      changeSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      changeSupport.removePropertyChangeListener(listener);
   }
   
}
