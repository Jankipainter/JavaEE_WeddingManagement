/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Client.WeddingClient;
import Entity.PlanService;
import Entity.Planner;
import ejb.AdminBeanLocal;
import ejb.PlannerBeanLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pc
 */
@Named(value = "providedPlannerServiceManagedBean")
@ApplicationScoped
public class ProvidedPlannerServiceManagedBean {
    
    @EJB PlannerBeanLocal pejb;
    @EJB AdminBeanLocal aejb;
     WeddingClient client =new WeddingClient();
     int provide_service_id;
     String details;
     Short isActivea;
      short isActive;
     int planner_id;
     int service_id;
     Collection<PlanService>getAllPlannerService;
     Collection<PlanService>getServiceByPlanner;
     Planner p; 
     Response res;
     int pid;
     GenericType<PlanService> gplanobj = new GenericType<PlanService>() {};

    /**
     * Creates a new instance of ProvidedPlannerServiceManagedBean
     */
    public ProvidedPlannerServiceManagedBean() {
        getServiceByPlanner=new ArrayList<PlanService>();
    }

    public PlannerBeanLocal getPejb() {
        return pejb;
    }

    public void setPejb(PlannerBeanLocal pejb) {
        this.pejb = pejb;
    }

    public WeddingClient getClient() {
        return client;
    }

    public void setClient(WeddingClient client) {
        this.client = client;
    }

    public int getProvide_service_id() {
        return provide_service_id;
    }

    public void setProvide_service_id(int provide_service_id) {
        this.provide_service_id = provide_service_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Short getIsActivea() {
        return isActivea;
    }

    public void setIsActivea(Short isActivea) {
        this.isActivea = isActivea;
    }

    public short getIsActive() {
        return isActive;
    }

    public void setIsActive(short isActive) {
        this.isActive = isActive;
    }

    

    public int getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(int planner_id) {
        this.planner_id = planner_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public AdminBeanLocal getAejb() {
        return aejb;
    }

    public void setAejb(AdminBeanLocal aejb) {
        this.aejb = aejb;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public GenericType<PlanService> getGplanobj() {
        return gplanobj;
    }

    public void setGplanobj(GenericType<PlanService> gplanobj) {
        this.gplanobj = gplanobj;
    }
    
    

    public Collection<PlanService> getGetServiceByPlanner() {
           HttpServletRequest req=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session=req.getSession();
        int Planner_id= Integer.parseInt( session.getAttribute("Planner_Id").toString());
        System.out.println("planner"+Planner_id);
        p=aejb.getPlannerById(Planner_id);
        getServiceByPlanner=pejb.getServiceByPlannerId(p);
        return getServiceByPlanner;
    }

    public void setGetServiceByPlanner(Collection<PlanService> getServiceByPlanner) {
        this.getServiceByPlanner = getServiceByPlanner;
    }

    public Planner getP() {
        return p;
    }

    public void setP(Planner p) {
        this.p = p;
    }
    
    

    public Collection<PlanService> getGetAllPlannerService() {
         HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//        this.planner_id=(int) session.getAttribute("PlannerId");
        getAllPlannerService=pejb.showAllPlannerService();
        return getAllPlannerService;
    }

    public void setGetAllPlannerService(Collection<PlanService> getAllPlannerService) {
        this.getAllPlannerService = getAllPlannerService;
    }
    
    public String goToPSAdd()
    {
        return "AddPlannerService.jsf?faces-redirect=true";
    }
    
    public String providedServiceAdd() {
        HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        //String s=session.getAttribute('Email');
        String s=(String) session.getAttribute("PlannerId");
//int s=Integer.parseInt(session.getAttribute("PlannerId").toString());
//        pejb.providedServiceAdd(s, service_id, details, Integer.parseInt(1));
        client.providedServiceAdd(s, String.valueOf(service_id), details, String.valueOf(1));
        return "PlannerHome.jsf";
    }
    
    public String providedServiceEdit(int id)
    {
         String id1 = String.valueOf(id);
        res = client.getProvidedServiceId(Response.class, id1);
        PlanService p=new PlanService();
        p = res.readEntity(gplanobj);
        pid = p.getProvideServiceId();
        service_id=p.getService().getServiceId();
        planner_id=p.getPlanner().getPlannerId();
        details=p.getDetails();
        isActive=p.getIsActive();
        return "EditPlannerService.jsf?faces-redirect=true";
        
    }
    
    public String psEdit()
    {
        client.providedServiceEdit(String.valueOf(pid), String.valueOf(planner_id), String.valueOf(service_id), details, String.valueOf(isActive));
        return "PlannerHome.jsf?faces-redirect=true";
    }
    
    
    public String psDel(int psid,int pid,int sid){
        client.providedServiceRemove(String.valueOf(psid), String.valueOf(pid), String.valueOf(sid));
         return "PlannerHome.jsf?faces-redirect=true";
    }
    
    public String viewPlannerProfile(){
        return "PlannerProfile.jsf?faces-redirect=true";
    }
    
    public void plannerLogout(){
         FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
         try{
             //setFalse();
             FacesContext.getCurrentInstance().getExternalContext().redirect("../loginpage.jsf");
         }catch(IOException e)
         {
             System.out.println(e.getMessage());
         }
//         return "loginpage.jsf?faces-redirect=true";
    }
}
