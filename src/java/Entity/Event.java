/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventId", query = "SELECT e FROM Event e WHERE e.eventId = :eventId"),
    @NamedQuery(name = "Event.findByReligionId", query = "SELECT e FROM Event e WHERE e.religionId = :religionId"),
    @NamedQuery(name = "Event.findByEventName", query = "SELECT e FROM Event e WHERE e.eventName = :eventName"),
    @NamedQuery(name = "Event.findByStartTimePlan", query = "SELECT e FROM Event e WHERE e.startTimePlan = :startTimePlan"),
    @NamedQuery(name = "Event.findByEndTimePlan", query = "SELECT e FROM Event e WHERE e.endTimePlan = :endTimePlan")})
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "event_name")
    private String eventName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time_plan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTimePlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time_plan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTimePlan;
    @JoinTable(name = "user_event", joinColumns = {
        @JoinColumn(name = "event_id", referencedColumnName = "event_id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")})
    @ManyToMany
    private Collection<User> userCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<PlanServiceInvoice> planServiceInvoiceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eventId")
    private Collection<PlanProductInvoice> planProductInvoiceCollection;
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    @ManyToOne(optional = false)
    private Location locationId;
    @JoinColumn(name = "religion_id", referencedColumnName = "religion_id")
    @ManyToOne(optional = false)
    private Religion religionId;
    @JoinColumn(name = "wedding_id", referencedColumnName = "wedding_id")
    @ManyToOne(optional = false)
    private Wedding weddingId;

    public Event() {
    }

    public Event(Integer eventId) {
        this.eventId = eventId;
    }

    public Event(Integer eventId, String eventName, Date startTimePlan, Date endTimePlan) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.startTimePlan = startTimePlan;
        this.endTimePlan = endTimePlan;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getStartTimePlan() {
        return startTimePlan;
    }

    public void setStartTimePlan(Date startTimePlan) {
        this.startTimePlan = startTimePlan;
    }

    public Date getEndTimePlan() {
        return endTimePlan;
    }

    public void setEndTimePlan(Date endTimePlan) {
        this.endTimePlan = endTimePlan;
    }

    @JsonbTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @JsonbTransient
    public Collection<PlanServiceInvoice> getPlanServiceInvoiceCollection() {
        return planServiceInvoiceCollection;
    }

    public void setPlanServiceInvoiceCollection(Collection<PlanServiceInvoice> planServiceInvoiceCollection) {
        this.planServiceInvoiceCollection = planServiceInvoiceCollection;
    }

    @JsonbTransient
    public Collection<PlanProductInvoice> getPlanProductInvoiceCollection() {
        return planProductInvoiceCollection;
    }

    public void setPlanProductInvoiceCollection(Collection<PlanProductInvoice> planProductInvoiceCollection) {
        this.planProductInvoiceCollection = planProductInvoiceCollection;
    }

    public Location getLocationId() {
        return locationId;
    }

    public void setLocationId(Location locationId) {
        this.locationId = locationId;
    }

    public Religion getReligionId() {
        return religionId;
    }

    public void setReligionId(Religion religionId) {
        this.religionId = religionId;
    }

    public Wedding getWeddingId() {
        return weddingId;
    }

    public void setWeddingId(Wedding weddingId) {
        this.weddingId = weddingId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Event[ eventId=" + eventId + " ]";
    }
    
}
