/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "selectplanner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Selectplanner.findAll", query = "SELECT s FROM Selectplanner s"),
    @NamedQuery(name = "Selectplanner.findByPlannerId", query = "SELECT s FROM Selectplanner s WHERE s.plannerId=:plannerId"),
    @NamedQuery(name = "Selectplanner.findByServiceId", query = "SELECT s FROM Selectplanner s WHERE s.serviceId=:serviceId"),
    @NamedQuery(name = "Selectplanner.findByUserId", query = "SELECT s FROM Selectplanner s WHERE s.userId=:userId"),
    @NamedQuery(name = "Selectplanner.findBySid", query = "SELECT s FROM Selectplanner s WHERE s.sid = :sid")})
public class Selectplanner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sid")
    private Integer sid;
    @JoinColumn(name = "planner_id", referencedColumnName = "planner_id")
    @ManyToOne(optional = false)
    private Planner plannerId;
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @ManyToOne(optional = false)
    private Service serviceId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userId;

    public Selectplanner() {
    }

    public Selectplanner(Integer sid) {
        this.sid = sid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Planner getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(Planner plannerId) {
        this.plannerId = plannerId;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Selectplanner)) {
            return false;
        }
        Selectplanner other = (Selectplanner) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Selectplanner[ sid=" + sid + " ]";
    }
    
}
