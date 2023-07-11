/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Event;
import Entity.Location;
import Entity.Planner;
import Entity.Selectplanner;
import Entity.User;
import Entity.Wedding;
import ejb.AdminBeanLocal;
import ejb.PlannerBeanLocal;
import ejb.UserBeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
@Named(value = "eventManagedBean")
@ApplicationScoped
public class EventManagedBean {

     @EJB
    AdminBeanLocal aejb;
    @EJB
    UserBeanLocal uejb;
    @EJB
    PlannerBeanLocal pejb;
    
    int event_id,wedding_id,location_id,religion_id,service_id;
    int user_id;
    String event_name;
    Date start_time_plan,end_time_plan;
    Collection<Selectplanner>getselectPlannerByPlannerId;
    Collection<Selectplanner>getselectPlannerByUserId;
    ArrayList<Selectplanner>select;
    /**
     * Creates a new instance of EventManagedBean
     */
    public EventManagedBean() {
//        select=new ArrayList<Selectplanner>(getselectPlannerByUserId);
    }

    public AdminBeanLocal getAejb() {
        return aejb;
    }

    public void setAejb(AdminBeanLocal aejb) {
        this.aejb = aejb;
    }

    public UserBeanLocal getUejb() {
        return uejb;
    }

    public void setUejb(UserBeanLocal uejb) {
        this.uejb = uejb;
    }

    public PlannerBeanLocal getPejb() {
        return pejb;
    }

    public void setPejb(PlannerBeanLocal pejb) {
        this.pejb = pejb;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getWedding_id() {
        return wedding_id;
    }

    public void setWedding_id(int wedding_id) {
        this.wedding_id = wedding_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getReligion_id() {
        return religion_id;
    }

    public void setReligion_id(int religion_id) {
        this.religion_id = religion_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public Date getStart_time_plan() {
        return start_time_plan;
    }

    public void setStart_time_plan(Date start_time_plan) {
        this.start_time_plan = start_time_plan;
    }

    public Date getEnd_time_plan() {
        return end_time_plan;
    }

    public void setEnd_time_plan(Date end_time_plan) {
        this.end_time_plan = end_time_plan;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public ArrayList<Selectplanner> getSelect() {
        return select;
    }

    public void setSelect(ArrayList<Selectplanner> select) {
        this.select = select;
    }

    
    public Collection<Selectplanner> getGetselectPlannerByPlannerId() {
          HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
          
 int pid=Integer.parseInt(session.getAttribute("Planner_Id").toString());
            Planner p=pejb.getPlannerById(pid);
        
        System.out.println("select planner"+pid);
        getselectPlannerByPlannerId=pejb.getselectPlannerByPlannerId(p);
        System.out.println("select planner"+getselectPlannerByPlannerId);
        return getselectPlannerByPlannerId;
    }
    
    

    public void setGetselectPlannerByPlannerId(Collection<Selectplanner> getselectPlannerByPlannerId) {
        this.getselectPlannerByPlannerId = getselectPlannerByPlannerId;
    }

    public Collection<Selectplanner> getGetselectPlannerByUserId() {
         HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        int uid=Integer.parseInt(session.getAttribute("UserId").toString());
        User u=uejb.getUserById(uid);
        getselectPlannerByUserId=pejb.getselectPlannerByUserId(u);
        return getselectPlannerByUserId;
    }

    public void setGetselectPlannerByUserId(Collection<Selectplanner> getselectPlannerByUserId) {
        this.getselectPlannerByUserId = getselectPlannerByUserId;
    }
    
     public float getTotal(){
        float grosstotal=0;
        select=new ArrayList<Selectplanner>(getselectPlannerByUserId);
        for(int i=0;i<getselectPlannerByUserId.size();i++)
        {
             grosstotal+=select.get(i).getServiceId().getPri();
        }
        HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
           
            session.setAttribute("Total", grosstotal);
        return grosstotal;
    }
    
     public void lastAddedWId()
     {
         
         Wedding w=uejb.getLastAddedWedding();
           HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
          session.setAttribute("WeddingId",w.getWeddingId());
         System.out.println("wedding id"+w.getWeddingId());
         //return w.getWeddingId();
     }
     
     public String addEvent(){
         HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//         int wid=Integer.parseInt( session.getAttribute("WeddingId").toString());
         Wedding w=uejb.getLastAddedWedding();
         Event e=uejb.getLastAddedEvent();
         Location l=uejb.getLastAddedLocation();
         int wid=w.getWeddingId();
         int eid=e.getEventId();
          location_id=l.getLocationId();
         System.out.println("wedding"+wid);
         int rid=Integer.parseInt(session.getAttribute("Religion").toString());
         System.out.println("religion"+rid);
         uejb.addEvent(event_name, wid, location_id, start_time_plan, end_time_plan, rid);
//         uejb.addUserEvent(eid,u2 );
        return "pay.jsf?faces-redirect=true";
         
     }
     
     public void RemoveSelectedService(int sid,int pid,int uid,int eid){
         pejb.delSelectPlanner(sid, pid, uid, eid);
     }
     
     public void delSelected(int id)
     {
         pejb.removeSelectService(id);
     }
     
    public void viewSelectedPlannerUser(){
         HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        int pid=Integer.parseInt(session.getAttribute("Planner_Id").toString());
//        getselectPlannerByPlannerId=pejb.getselectPlannerByPlannerId(pid);
    }
    
    public String goToSelectService(){
        return "SelectedServices.jsf?faces-redirect=true";
    }
    
    public String selectMap(){
        return "../Map.jsp";
    }
    
    public String goToEvent(){
        return "Event.jsf?faces-redirect=true";
    }
}
