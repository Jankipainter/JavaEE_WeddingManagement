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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "plan_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanProduct.findAll", query = "SELECT p FROM PlanProduct p"),
    @NamedQuery(name = "PlanProduct.findByProvideProductId", query = "SELECT p FROM PlanProduct p WHERE p.provideProductId = :provideProductId"),
    @NamedQuery(name = "PlanProduct.findByIsActive", query = "SELECT p FROM PlanProduct p WHERE p.isActive = :isActive")})
public class PlanProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "provide_product_id")
    private Integer provideProductId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "details")
    private String details;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "planner_id", referencedColumnName = "planner_id")
    @ManyToOne(optional = false)
    private Planner plannerId;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private Product productId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provideProductId")
    private Collection<PlanProductInvoice> planProductInvoiceCollection;

    public PlanProduct() {
    }

    public PlanProduct(Integer provideProductId) {
        this.provideProductId = provideProductId;
    }

    public PlanProduct(Integer provideProductId, String details, boolean isActive) {
        this.provideProductId = provideProductId;
        this.details = details;
        this.isActive = isActive;
    }

    public Integer getProvideProductId() {
        return provideProductId;
    }

    public void setProvideProductId(Integer provideProductId) {
        this.provideProductId = provideProductId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Planner getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(Planner plannerId) {
        this.plannerId = plannerId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
        hash += (provideProductId != null ? provideProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanProduct)) {
            return false;
        }
        PlanProduct other = (PlanProduct) object;
        if ((this.provideProductId == null && other.provideProductId != null) || (this.provideProductId != null && !this.provideProductId.equals(other.provideProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PlanProduct[ provideProductId=" + provideProductId + " ]";
    }
    
}
