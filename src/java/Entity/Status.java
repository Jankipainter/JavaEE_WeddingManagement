/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Status.findAll", query = "SELECT s FROM Status s"),
    @NamedQuery(name = "Status.findByStatusId", query = "SELECT s FROM Status s WHERE s.statusId = :statusId"),
    @NamedQuery(name = "Status.findByStatusName", query = "SELECT s FROM Status s WHERE s.statusName = :statusName"),
    @NamedQuery(name = "Status.findByOffer", query = "SELECT s FROM Status s WHERE s.offer = :offer"),
    @NamedQuery(name = "Status.findByOfferAccepted", query = "SELECT s FROM Status s WHERE s.offerAccepted = :offerAccepted"),
    @NamedQuery(name = "Status.findByOfferRejected", query = "SELECT s FROM Status s WHERE s.offerRejected = :offerRejected")})
public class Status implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "status_id")
    private Integer statusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status_name")
    private String statusName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "offer")
    private boolean offer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "offer_accepted")
    private boolean offerAccepted;
    @Basic(optional = false)
    @NotNull
    @Column(name = "offer_rejected")
    private boolean offerRejected;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
    private Collection<PlanServiceInvoice> planServiceInvoiceCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
    private Collection<PlanProductInvoice> planProductInvoiceCollection;

    public Status() {
    }

    public Status(Integer statusId) {
        this.statusId = statusId;
    }

    public Status(Integer statusId, String statusName, boolean offer, boolean offerAccepted, boolean offerRejected) {
        this.statusId = statusId;
        this.statusName = statusName;
        this.offer = offer;
        this.offerAccepted = offerAccepted;
        this.offerRejected = offerRejected;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public boolean getOffer() {
        return offer;
    }

    public void setOffer(boolean offer) {
        this.offer = offer;
    }

    public boolean getOfferAccepted() {
        return offerAccepted;
    }

    public void setOfferAccepted(boolean offerAccepted) {
        this.offerAccepted = offerAccepted;
    }

    public boolean getOfferRejected() {
        return offerRejected;
    }

    public void setOfferRejected(boolean offerRejected) {
        this.offerRejected = offerRejected;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Status)) {
            return false;
        }
        Status other = (Status) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Status[ statusId=" + statusId + " ]";
    }
    
}
