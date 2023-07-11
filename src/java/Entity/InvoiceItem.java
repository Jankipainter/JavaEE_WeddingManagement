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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "invoice_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvoiceItem.findAll", query = "SELECT i FROM InvoiceItem i"),
    @NamedQuery(name = "InvoiceItem.findByInvoiceItemId", query = "SELECT i FROM InvoiceItem i WHERE i.invoiceItemId = :invoiceItemId"),
    @NamedQuery(name = "InvoiceItem.findByItemName", query = "SELECT i FROM InvoiceItem i WHERE i.itemName = :itemName"),
    @NamedQuery(name = "InvoiceItem.findByItemPrice", query = "SELECT i FROM InvoiceItem i WHERE i.itemPrice = :itemPrice")})
public class InvoiceItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "invoice_item_id")
    private Integer invoiceItemId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "item_name")
    private String itemName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "item_price")
    private long itemPrice;
    @JoinColumn(name = "invoice_id", referencedColumnName = "invoice_id")
    @ManyToOne(optional = false)
    private Invoice invoiceId;
    @JoinColumn(name = "product_include_id", referencedColumnName = "product_Include_id")
    @ManyToOne(optional = false)
    private PlanProductInvoice productIncludeId;
    @JoinColumn(name = "service_include_id", referencedColumnName = "service_include_id")
    @ManyToOne(optional = false)
    private PlanServiceInvoice serviceIncludeId;

    public InvoiceItem() {
    }

    public InvoiceItem(Integer invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public InvoiceItem(Integer invoiceItemId, String itemName, long itemPrice) {
        this.invoiceItemId = invoiceItemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public Integer getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(Integer invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(long itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public PlanProductInvoice getProductIncludeId() {
        return productIncludeId;
    }

    public void setProductIncludeId(PlanProductInvoice productIncludeId) {
        this.productIncludeId = productIncludeId;
    }

    public PlanServiceInvoice getServiceIncludeId() {
        return serviceIncludeId;
    }

    public void setServiceIncludeId(PlanServiceInvoice serviceIncludeId) {
        this.serviceIncludeId = serviceIncludeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (invoiceItemId != null ? invoiceItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvoiceItem)) {
            return false;
        }
        InvoiceItem other = (InvoiceItem) object;
        if ((this.invoiceItemId == null && other.invoiceItemId != null) || (this.invoiceItemId != null && !this.invoiceItemId.equals(other.invoiceItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.InvoiceItem[ invoiceItemId=" + invoiceItemId + " ]";
    }
    
}
