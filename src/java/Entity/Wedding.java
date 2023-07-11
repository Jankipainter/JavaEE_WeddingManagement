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
@Table(name = "wedding")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wedding.findAll", query = "SELECT w FROM Wedding w"),
    @NamedQuery(name = "Wedding.findByWeddingId", query = "SELECT w FROM Wedding w WHERE w.weddingId = :weddingId"),
    @NamedQuery(name = "Wedding.findByWeddingCode", query = "SELECT w FROM Wedding w WHERE w.weddingCode = :weddingCode"),
    @NamedQuery(name = "Wedding.findByStartTimePlanned", query = "SELECT w FROM Wedding w WHERE w.startTimePlanned = :startTimePlanned"),
    @NamedQuery(name = "Wedding.findByEndTimePlanned", query = "SELECT w FROM Wedding w WHERE w.endTimePlanned = :endTimePlanned"),
    @NamedQuery(name = "Wedding.findByStartTime", query = "SELECT w FROM Wedding w WHERE w.startTime = :startTime"),
    @NamedQuery(name = "Wedding.findByEndTime", query = "SELECT w FROM Wedding w WHERE w.endTime = :endTime")})
public class Wedding implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wedding_id")
    private Integer weddingId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "wedding_code")
    private String weddingCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time_planned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTimePlanned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time_planned")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTimePlanned;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weddingId")
    private Collection<Invoice> invoiceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weddingId")
    private Collection<Event> eventCollection;

    public Wedding() {
    }

    public Wedding(Integer weddingId) {
        this.weddingId = weddingId;
    }

    public Wedding(Integer weddingId, String weddingCode, Date startTimePlanned, Date endTimePlanned, Date startTime, Date endTime) {
        this.weddingId = weddingId;
        this.weddingCode = weddingCode;
        this.startTimePlanned = startTimePlanned;
        this.endTimePlanned = endTimePlanned;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getWeddingId() {
        return weddingId;
    }

    public void setWeddingId(Integer weddingId) {
        this.weddingId = weddingId;
    }

    public String getWeddingCode() {
        return weddingCode;
    }

    public void setWeddingCode(String weddingCode) {
        this.weddingCode = weddingCode;
    }

    public Date getStartTimePlanned() {
        return startTimePlanned;
    }

    public void setStartTimePlanned(Date startTimePlanned) {
        this.startTimePlanned = startTimePlanned;
    }

    public Date getEndTimePlanned() {
        return endTimePlanned;
    }

    public void setEndTimePlanned(Date endTimePlanned) {
        this.endTimePlanned = endTimePlanned;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @JsonbTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    @JsonbTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (weddingId != null ? weddingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wedding)) {
            return false;
        }
        Wedding other = (Wedding) object;
        if ((this.weddingId == null && other.weddingId != null) || (this.weddingId != null && !this.weddingId.equals(other.weddingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Wedding[ weddingId=" + weddingId + " ]";
    }
    
}
