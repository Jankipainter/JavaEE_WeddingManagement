/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Client.WeddingClient;
import Entity.Event;
import Entity.PlanService;
import Entity.Planner;
import Entity.Product;
import Entity.Religion;
import Entity.Selectplanner;
import Entity.Service;
import Entity.User;
import ejb.AdminBeanLocal;
import ejb.PlannerBeanLocal;
import ejb.UserBeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author pc
 */
@Named(value = "userManageBean")
@ApplicationScoped
public class UserManageBean {

    @EJB
    private UserBeanLocal ejbean;
    @EJB
    private PlannerBeanLocal pbean;
    @EJB
    private AdminBeanLocal abean;
    private WeddingClient client = new WeddingClient();
    int religion_id,product_id;
    String religion_name;
    ArrayList<Religion> selectedReligion;
    Collection<Religion> religions;
    String service_id;
    int planner_id, provideServiceId;
    Service s;
    Collection<PlanService> getPlannerByServiceId;
    Collection<Planner> getallplanner;
    ArrayList<Service> selectedService;
    ArrayList<PlanService> selectedPlanner;
    ArrayList<Selectplanner>selected;
    Collection<User>showAllUser;
    Collection<Product>showAllEvent;
     Collection<Product> getEventByReligionId;
     ArrayList<Planner>getPlannerCount;
     ArrayList<User>getUserCount;
 Religion r;
    
    Collection<Event> getAllEvent;
    ArrayList<Event>Events;
    private Converter conveter;

    /**
     * Creates a new instance of UserManageBean
     */
    public UserManageBean() {
        getPlannerByServiceId = new ArrayList<PlanService>();
        getallplanner = new ArrayList<Planner>();
        selectedService = new ArrayList<Service>();
        selectedPlanner = new ArrayList<PlanService>();
        showAllEvent=new ArrayList<Product>();
    }

    public UserBeanLocal getEjbean() {
        return ejbean;
    }

    public void setEjbean(UserBeanLocal ejbean) {
        this.ejbean = ejbean;
    }

    public WeddingClient getClient() {
        return client;
    }

    public void setClient(WeddingClient client) {
        this.client = client;
    }

    public int getReligion_id() {
        return religion_id;
    }

    public void setReligion_id(int religion_id) {
        this.religion_id = religion_id;
    }

    public String getReligion_name() {
        return religion_name;
    }

    public void setReligion_name(String religion_name) {
        this.religion_name = religion_name;
    }

    public int getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(int planner_id) {
        this.planner_id = planner_id;
    }

    public Collection<Religion> getReligions() {
        religions = ejbean.getAllReligion();
        return religions;
    }

    public void setReligions(Collection<Religion> religions) {
        this.religions = religions;
    }

    public Collection<User> getShowAllUser() {
        showAllUser=ejbean.getAllUser();
        return showAllUser;
    }

    public void setShowAllUser(Collection<User> showAllUser) {
        this.showAllUser = showAllUser;
    }

    public Collection<Product> getShowAllEvent() {
        showAllEvent=pbean.showAllProduct();
        return showAllEvent;
    }

    public void setShowAllEvent(Collection<Product> showAllEvent) {
        this.showAllEvent = showAllEvent;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getGetPlannerCount() {
        getallplanner=abean.plannerShowAll();
        getPlannerCount=new ArrayList<Planner>(getallplanner);
        return getPlannerCount.size();
    }

    public void setGetPlannerCount(ArrayList<Planner> getPlannerCount) {
        this.getPlannerCount = getPlannerCount;
    }

    public int getGetUserCount() {
        showAllUser=ejbean.getAllUser();
        getUserCount=new ArrayList<User>(showAllUser);
        return getUserCount.size();
    }

    public void setGetUserCount(ArrayList<User> getUserCount) {
        this.getUserCount = getUserCount;
    }
    
    

    public ArrayList<Religion> getSelectedReligion() {
        return selectedReligion;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public Service getS() {
        return s;
    }

    public void setS(Service s) {
        this.s = s;
    }

    public Collection<PlanService> getGetPlannerByServiceId() {
        return getPlannerByServiceId;
    }

    public void setGetPlannerByServiceId(Collection<PlanService> getPlannerByServiceId) {
        this.getPlannerByServiceId = getPlannerByServiceId;
    }

    public void setSelectedReligion(ArrayList<Religion> selectedReligion) {
        if (!selectedReligion.isEmpty()) {
            this.selectedReligion.get(religion_id);
        }
    }

    public Collection<Planner> getGetallplanner() {
        getallplanner = abean.plannerShowAll();
        return getallplanner;
    }

    public void setGetallplanner(Collection<Planner> getallplanner) {
        this.getallplanner = getallplanner;
    }

    public ArrayList<Service> getSelectedService() {
        return selectedService;
    }

    public void setSelectedService(ArrayList<Service> selectedService) {
        if (!selectedService.isEmpty()) {
            this.selectedService.add(selectedService.get(0));
        }

    }

    public int getProvideServiceId() {
        return provideServiceId;
    }

    public void setProvideServiceId(int provideServiceId) {
        this.provideServiceId = provideServiceId;
    }

    public Collection<Product> getGetEventByReligionId() {
//         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
////
////                //session.setAttribute("Religion", religion_id);
//                religion_id= (int) session.getAttribute("Religion");
//        getEventByReligionId=ejbean.getProductByReligionId(religion_id);
        return getEventByReligionId;
    }

    public void setGetEventByReligionId(Collection<Product> getEventByReligionId) {
        this.getEventByReligionId = getEventByReligionId;
    }

    public Collection<Event> getGetAllEvent() {
        return getAllEvent;
    }

    public void setGetAllEvent(Collection<Event> getAllEvent) {
        this.getAllEvent = getAllEvent;
    }

    public ArrayList<Event> getEvents() {
        return Events;
    }

    public void setEvents(ArrayList<Event> Events) {
        this.Events = Events;
    }

    
    
    public Religion getR() {
        return r;
    }

    public void setR(Religion r) {
        this.r = r;
    }

    public PlannerBeanLocal getPbean() {
        return pbean;
    }

    public void setPbean(PlannerBeanLocal pbean) {
        this.pbean = pbean;
    }

    public AdminBeanLocal getAbean() {
        return abean;
    }

    public void setAbean(AdminBeanLocal abean) {
        this.abean = abean;
    }

    public ArrayList<Selectplanner> getSelected() {
        return selected;
    }

    public void setSelected(ArrayList<Selectplanner> selected) {
        this.selected = selected;
    }
    
    

    public ArrayList<PlanService> getSelectedPlanner() {
        return selectedPlanner;
    }

    public void setSelectedPlanner(ArrayList<PlanService> selectedPlanner) {
        if (!selectedPlanner.isEmpty()) {
            this.selectedPlanner.add(selectedPlanner.get(0));
        }
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        session.setAttribute("selectPlannerId", getSelectedPlanner().get(0).getPlanner().getPlannerId());
         session.setAttribute("selectPlannerName", getSelectedPlanner().get(0).getPlanner().getPlannerName());
          session.setAttribute("selectServiceId", getSelectedPlanner().get(0).getService().getServiceId());
        System.out.println("selectplanner" + getSelectedPlanner().get(0).getPlanner().getPlannerId());
         session.setAttribute("selectService", getSelectedPlanner().get(0).getService().getServiceName());
        System.out.println("selectServiceName" + getSelectedPlanner().get(0).getService().getServiceName());
        
         int uid=Integer.parseInt(session.getAttribute("UserId").toString());
         int pid=Integer.parseInt(session.getAttribute("selectPlannerId").toString());
         int sid=Integer.parseInt(session.getAttribute("selectServiceId").toString());
         pbean.addSelectPlanner(pid, uid, sid);
    }

    public Converter getConveter() {
        return conveter;
    }

    public void setConveter(Converter conveter) {
        this.conveter = conveter;
    }

    public String afterSelectService() {

        return "plannerSelection.jsf?faces-redirect=true";

    }

    public String gotoselectpage() {
        getSelectedService().clear();
        getSelectedPlanner().clear();
        return "UserHome.jsf?faces-redirect=true";
    }

    public void viewDetail(int service_id) {
        System.out.println("ServiceId" + this.service_id);
        s = pbean.getServiceById(service_id);
        System.out.println("service" + s);
        getPlannerByServiceId = ejbean.getPlannerByServiceId(s);
//         return "UserHome.jsf?";
    }

    public String displayTable(int religion_id) {
        this.religion_id = selectedReligion.size();
        String r = String.valueOf(religion_id);
        return r;
    }
    
   
    
//     public float getTotal(){
//        float grosstotal=0;
//        for(int i=0;i<selectedPlanner.size();i++)
//        {
//             grosstotal+=selectedPlanner.get(i).getService().getPri();
//        }
//        HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//           
//            session.setAttribute("Total", grosstotal);
//        return grosstotal;
//    }
    
    public String goToEvent(){
        return "Event.jsf?faces-redirect=true";
    }

     public void viewEventsByReligion()
     {
//         System.out.println("religion"+religion_id);
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//
//                //session.setAttribute("Religion", religion_id);
                religion_id=(int) session.getAttribute("Religion");
         r=ejbean.getReligionById(religion_id);
          getEventByReligionId=ejbean.getProductByReligionId(r);
         //return "UserHome.jsf";
         
     }
     
          
     public int PlannerCount(){
         
         Response r=client.plannerShowAll(Response.class);
         ArrayList<Planner>plannerCount=new ArrayList<Planner>();
         GenericType<List<Planner>> ugt=new GenericType<List<Planner>>(){};
         plannerCount=(ArrayList<Planner>)r.readEntity(ugt);
         
         return plannerCount.size();
     }
     public String alreadyselected()
     {
         return "SelectedServices.jsf?faces-redirect=true";
     }
     
     public int HinduEventCount(){
        r=ejbean.getReligionById(1);
         getAllEvent=ejbean.getEventByReligionId(r);
         Events=new ArrayList<Event>(getAllEvent);
         return Events.size();
     }
     
      public int MuslimEventCount(){
        r=ejbean.getReligionById(2);
         getAllEvent=ejbean.getEventByReligionId(r);
         Events=new ArrayList<Event>(getAllEvent);
         return Events.size();
     }
      
      public int ChristenEventCount(){
        r=ejbean.getReligionById(3);
         getAllEvent=ejbean.getEventByReligionId(r);
         Events=new ArrayList<Event>(getAllEvent);
         return Events.size();
     } 
     
      public int ParsiEventCount(){
        r=ejbean.getReligionById(4);
         getAllEvent=ejbean.getEventByReligionId(r);
         Events=new ArrayList<Event>(getAllEvent);
         return Events.size();
     } 
     public Event religionCount(){
        return ejbean.getCountByReligion();
         
     }
     
    public String viewuser(){
        return "UserProfile.jsf?faces-redirect=true";
    }
//     public int UserCount(){
//         
//         Response r=client.getAllUser(Response.class);
//         ArrayList<User>userCount=new ArrayList<User>();
//         GenericType<List<User>> ugt=new GenericType<List<User>>(){};
//         userCount=(ArrayList<User>)r.readEntity(ugt);
//         
//         return userCount.size();
//     }
}
