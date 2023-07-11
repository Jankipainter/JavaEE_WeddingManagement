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
@Table(name = "plan_product_invoice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanProductInvoice.findAll", query = "SELECT p FROM PlanProductInvoice p"),
    @NamedQuery(name = "PlanProductInvoice.findByProductIncludeid", query = "SELECT p FROM PlanProductInvoice p WHERE p.productIncludeid = :productIncludeid"),
    @NamedQuery(name = "PlanProductInvoice.findByPrice", query = "SELECT p FROM PlanProductInvoice p WHERE p.price = :price")})
public class PlanProductInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_Include_id")
    private Integer productIncludeid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private long price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productIncludeId")
    private Collection<InvoiceItem> invoiceItemCollection;
    @JoinColumn(name = "event_id", referencedColumnName = "event_id")
    @ManyToOne(optional = false)
    private Event eventId;
    @JoinColumn(name = "provide_product_id", referencedColumnName = "provide_product_id")
    @ManyToOne(optional = false)
    private PlanProduct provideProductId;
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    @ManyToOne(optional = false)
    private Status statusId;

    public PlanProductInvoice() {
    }

    public PlanProductInvoice(Integer productIncludeid) {
        this.productIncludeid = productIncludeid;
    }

    public PlanProductInvoice(Integer productIncludeid, long price) {
        this.productIncludeid = productIncludeid;
        this.price = price;
    }

    public Integer getProductIncludeid() {
        return productIncludeid;
    }

    public void setProductIncludeid(Integer productIncludeid) {
        this.productIncludeid = productIncludeid;
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

    public PlanProduct getProvideProductId() {
        return provideProductId;
    }

    public void setProvideProductId(PlanProduct provideProductId) {
        this.provideProductId = provideProductId;
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
        hash += (productIncludeid != null ? productIncludeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanProductInvoice)) {
            return false;
        }
        PlanProductInvoice other = (PlanProductInvoice) object;
        if ((this.productIncludeid == null && other.productIncludeid != null) || (this.productIncludeid != null && !this.productIncludeid.equals(other.productIncludeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PlanProductInvoice[ productIncludeid=" + productIncludeid + " ]";
    }
    
}
