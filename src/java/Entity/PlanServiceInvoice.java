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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "plan_service_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanServiceInvoice.findAll", query = "SELECT p FROM PlanServiceInvoice p"),
    @NamedQuery(name = "PlanServiceInvoice.findByServiceIncludeId", query = "SELECT p FROM PlanServiceInvoice p WHERE p.serviceIncludeId = :serviceIncludeId"),
    @NamedQuery(name = "PlanServiceInvoice.findByPrice", query = "SELECT p FROM PlanServiceInvoice p WHERE p.price = :price")})
public class PlanServiceInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "service_include_id")
    private Integer serviceIncludeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceIncludeId")
    private Collection<InvoiceItem> invoiceItemCollection;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private Event eventId;
    @JoinColumn(name = "provide_service_id", referencedColumnName = "provide_service_id")
    @ManyToOne(optional = false)
    private PlanService provideServiceId;
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne(optional = false)
    private Status statusId;

    public PlanServiceInvoice() {
    }

    public PlanServiceInvoice(Integer serviceIncludeId) {
        this.serviceIncludeId = serviceIncludeId;
    }

    public PlanServiceInvoice(Integer serviceIncludeId, long price) {
        this.serviceIncludeId = serviceIncludeId;
        this.price = price;
    }

    public Integer getServiceIncludeId() {
        return serviceIncludeId;
    }

    public void setServiceIncludeId(Integer serviceIncludeId) {
        this.serviceIncludeId = serviceIncludeId;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @JsonbTransient
    public Collection<InvoiceItem> getInvoiceItemCollection() {
        return invoiceItemCollection;
    }

    public void setInvoiceItemCollection(Collection<InvoiceItem> invoiceItemCollection) {
        this.invoiceItemCollection = invoiceItemCollection;
    }

    public Event getEventId() {
        return eventId;
    }

    public void setEventId(Event eventId) {
        this.eventId = eventId;
    }

    public PlanService getProvideServiceId() {
        return provideServiceId;
    }

    public void setProvideServiceId(PlanService provideServiceId) {
        this.provideServiceId = provideServiceId;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceIncludeId != null ? serviceIncludeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanServiceInvoice)) {
            return false;
        }
        PlanServiceInvoice other = (PlanServiceInvoice) object;
        if ((this.serviceIncludeId == null && other.serviceIncludeId != null) || (this.serviceIncludeId != null && !this.serviceIncludeId.equals(other.serviceIncludeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PlanServiceInvoice[ serviceIncludeId=" + serviceIncludeId + " ]";
    }
    
}
