/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Client.WeddingClient;
import Entity.PlanService;
import Entity.Planner;
import Entity.Religion;
import Entity.Service;
import ejb.AdminBeanLocal;
import ejb.PlannerBeanLocal;
import ejb.UserBeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pc
 */
@Named(value = "plannerServiceManagedBean")
@ApplicationScoped
public class PlannerServiceManagedBean {
    
    
    
    @EJB 
    private PlannerBeanLocal ejb;
    @EJB
    private AdminBeanLocal abean;
    @EJB
    private UserBeanLocal ubean;
     private WeddingClient client=new WeddingClient();
     Planner p;
    
     Collection<PlanService> getServiceByPlannerId;
     Collection<Service> getServiceByReligionId;
     GenericType<Collection<Planner>> gplanners;
      Service s;
        Collection<PlanService> getPlannerByServiceId;
 Religion r;
     Response res;
     
     public PlannerServiceManagedBean() {
         p=new Planner();
         getServiceByPlannerId=new ArrayList<PlanService>();
         getServiceByReligionId=new ArrayList<Service>();
    }
    public PlannerBeanLocal getEjb() {
        return ejb;
    }

    public void setEjb(PlannerBeanLocal ejb) {
        this.ejb = ejb;
    }

    public WeddingClient getClient() {
        return client;
    }

    public void setClient(WeddingClient client) {
        this.client = client;
    }
     

    int pid,uid;
    int ps;
    private String planner_id,user_name,user_email;
    private String service_id;
    private String religion_id;
    private String provider_service_id;
    private String details;
    private String isActive;
    Collection<Planner> planners;

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }
    
    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
    
    

    public String getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(String planner_id) {
        this.planner_id = planner_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getProvider_service_id() {
        return provider_service_id;
    }

    public void setProvider_service_id(String provider_service_id) {
        this.provider_service_id = provider_service_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public Collection<Planner> getPlanners() {
         res = client.plannerShowAll(Response.class);
        planners = res.readEntity(gplanners);
        return planners;
    }

    public void setPlanners(Collection<Planner> planners) {
        this.planners = planners;
    }

    public Collection<PlanService> getGetServiceByPlannerId() {
        return getServiceByPlannerId;
    }

    public void setGetServiceByPlannerId(Collection<PlanService> getServiceByPlannerId) {
        this.getServiceByPlannerId = getServiceByPlannerId;
    }

    public Collection<Service> getGetServiceByReligionId() {
        return getServiceByReligionId;
    }

    public void setGetServiceByReligionId(Collection<Service> getServiceByReligionId) {
        this.getServiceByReligionId = getServiceByReligionId;
    }

   

    
    public String getReligion_id() {
        return religion_id;
    }

    public void setReligion_id(String religion_id) {
        this.religion_id = religion_id;
    }

    public Service getS() {
        return s;
    }

    public void setS(Service s) {
        this.s = s;
    }

    public Religion getR() {
        return r;
    }

    public void setR(Religion r) {
        this.r = r;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    
    
    
    /**
     * Creates a new instance of PlannerServiceManagedBean
     */
    
    
    public Collection<PlanService> showAllPlannerService(){
       return ejb.showAllPlannerService();
    }
    
     public String toPlannerForm(String planner_id)
     {
         if(!planner_id.isEmpty())
         {
             res=client.getPlannerById(Response.class, planner_id);
            // p = res.readEntity(gplanners);
            
            planner_id = p.getPlannerId().toString();
         }
         return "PlannerDetail.jsf";
     }
     
     public String viewDetail(int planner_id)
     {
         p=abean.getPlannerById(planner_id);
         getServiceByPlannerId=ejb.getServiceByPlannerId(p);
         return "PlannerDetail.jsf";
     }
  
     
     public String viewServiceByReligion(int religion_id)
     {
         System.out.println("religion"+religion_id);
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

                session.setAttribute("Religion", religion_id);
         r=ubean.getReligionById(religion_id);
         getServiceByReligionId=ubean.getServiceByReligionId(r);
         return "UserHome.jsf";
         
     }
     
     
     public void viewSelectedPlanner(){
          HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//         PlanService ps=  (PlanService) session.getAttribute("selectPlanner");
//         ArrayList<PlanService>ps=new ArrayList<PlanService>() session.getAttribute("selectPlanner"));
         ps=Integer.parseInt(session.getAttribute("selectPlanner").toString());
//        PlanService ps=ejb.getProvidedServiceId(ps1);
         System.out.println("PlanService"+ps);
//         pid=ps;
         System.out.println("pid"+pid);
         int login_pid=Integer.parseInt(session.getAttribute("Planner_Id").toString());
         System.out.println("login_pid"+login_pid);
        if(ps==login_pid)
        {
//           uid=Integer.parseInt( session.getAttribute("UserId").toString());
           user_name=session.getAttribute("UserFName").toString();
           user_email=session.getAttribute("UserEmail").toString();
           service_id=session.getAttribute("selectService").toString();
        }
     }
}
