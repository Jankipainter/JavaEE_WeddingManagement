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
@Table(name = "plan_service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlanService.findAll", query = "SELECT p FROM PlanService p"),
    @NamedQuery(name = "PlanService.findByPlannerId", query = "SELECT p FROM PlanService p WHERE p.planner = :planner"),
    @NamedQuery(name = "PlanService.findByServiceId", query = "SELECT p FROM PlanService p WHERE p.service = :service"),
    @NamedQuery(name = "PlanService.findByProvideServiceId", query = "SELECT p FROM PlanService p WHERE p.provideServiceId = :provideServiceId"),
    @NamedQuery(name = "PlanService.findByIsActive", query = "SELECT p FROM PlanService p WHERE p.isActive = :isActive")})
public class PlanService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "provide_service_id")
    private Integer provideServiceId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "details")
    private String details;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive")
    private short isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provideServiceId")
    private Collection<PlanServiceInvoice> planServiceInvoiceCollection;
    @JoinColumn(name = "planner_id", referencedColumnName = "planner_id")
    @ManyToOne(optional = false)
    private Planner planner;
    @JoinColumn(name = "service_id", referencedColumnName = "service_id")
    @ManyToOne(optional = false)
    private Service service;

    public PlanService() {
    }

    public PlanService(Integer provideServiceId) {
        this.provideServiceId = provideServiceId;
    }

    public PlanService(Integer provideServiceId, String details, short isActive) {
        this.provideServiceId = provideServiceId;
        this.details = details;
        this.isActive = isActive;
    }

    public Integer getProvideServiceId() {
        return provideServiceId;
    }

    public void setProvideServiceId(Integer provideServiceId) {
        this.provideServiceId = provideServiceId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    @JsonbTransient
    public Collection<PlanServiceInvoice> getPlanServiceInvoiceCollection() {
        return planServiceInvoiceCollection;
    }

    public void setPlanServiceInvoiceCollection(Collection<PlanServiceInvoice> planServiceInvoiceCollection) {
        this.planServiceInvoiceCollection = planServiceInvoiceCollection;
    }

    public Planner getPlanner() {
        return planner;
    }

    public void setPlanner(Planner planner) {
        this.planner = planner;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

  

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (provideServiceId != null ? provideServiceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanService)) {
            return false;
        }
        PlanService other = (PlanService) object;
        if ((this.provideServiceId == null && other.provideServiceId != null) || (this.provideServiceId != null && !this.provideServiceId.equals(other.provideServiceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PlanService[ provideServiceId=" + provideServiceId + " ]";
    }
    
}
