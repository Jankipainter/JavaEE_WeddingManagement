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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "planner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planner.findAll", query = "SELECT p FROM Planner p"),
    @NamedQuery(name = "Planner.findByPlannerId", query = "SELECT p FROM Planner p WHERE p.plannerId = :plannerId"),
    @NamedQuery(name = "Planner.findByPlannerCode", query = "SELECT p FROM Planner p WHERE p.plannerCode = :plannerCode"),
    @NamedQuery(name = "Planner.findByPlannerName", query = "SELECT p FROM Planner p WHERE p.plannerName = :plannerName"),
    @NamedQuery(name = "Planner.findByPlannerEmail", query = "SELECT p FROM Planner p WHERE p.plannerEmail = :plannerEmail"),
    @NamedQuery(name = "Planner.findByPlannerPassword", query = "SELECT p FROM Planner p WHERE p.plannerPassword = :plannerPassword")})
public class Planner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "planner_id")
    private Integer plannerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "planner_code")
    private String plannerCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "planner_name")
    private String plannerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "planner_email")
    private String plannerEmail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "planner_password")
    private String plannerPassword;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plannerId")
    private Collection<Selectplanner> selectplannerCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plannerId")
    private Collection<PlanProduct> planProductCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "planner")
    private Collection<PlanService> planServiceCollection;
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Role roleId;

    public Planner() {
    }

    public Planner(Integer plannerId) {
        this.plannerId = plannerId;
    }

    public Planner(Integer plannerId, String plannerCode, String plannerName, String plannerEmail, String plannerPassword) {
        this.plannerId = plannerId;
        this.plannerCode = plannerCode;
        this.plannerName = plannerName;
        this.plannerEmail = plannerEmail;
        this.plannerPassword = plannerPassword;
    }

    public Integer getPlannerId() {
        return plannerId;
    }

    public void setPlannerId(Integer plannerId) {
        this.plannerId = plannerId;
    }

    public String getPlannerCode() {
        return plannerCode;
    }

    public void setPlannerCode(String plannerCode) {
        this.plannerCode = plannerCode;
    }

    public String getPlannerName() {
        return plannerName;
    }

    public void setPlannerName(String plannerName) {
        this.plannerName = plannerName;
    }

    public String getPlannerEmail() {
        return plannerEmail;
    }

    public void setPlannerEmail(String plannerEmail) {
        this.plannerEmail = plannerEmail;
    }

    public String getPlannerPassword() {
        return plannerPassword;
    }

    public void setPlannerPassword(String plannerPassword) {
        this.plannerPassword = plannerPassword;
    }

    @JsonbTransient
    public Collection<Selectplanner> getSelectplannerCollection() {
        return selectplannerCollection;
    }

    public void setSelectplannerCollection(Collection<Selectplanner> selectplannerCollection) {
        this.selectplannerCollection = selectplannerCollection;
    }

    @JsonbTransient
    public Collection<PlanProduct> getPlanProductCollection() {
        return planProductCollection;
    }

    public void setPlanProductCollection(Collection<PlanProduct> planProductCollection) {
        this.planProductCollection = planProductCollection;
    }

    @JsonbTransient
    public Collection<PlanService> getPlanServiceCollection() {
        return planServiceCollection;
    }

    public void setPlanServiceCollection(Collection<PlanService> planServiceCollection) {
        this.planServiceCollection = planServiceCollection;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plannerId != null ? plannerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planner)) {
            return false;
        }
        Planner other = (Planner) object;
        if ((this.plannerId == null && other.plannerId != null) || (this.plannerId != null && !this.plannerId.equals(other.plannerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Planner[ plannerId=" + plannerId + " ]";
    }
    
}
