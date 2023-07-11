/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Wedding;
import ejb.UserBeanLocal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@Named(value = "weddingManagedBean")
@ApplicationScoped
public class WeddingManagedBean {
    
     @EJB 
        private UserBeanLocal ejbean;
     String wedding_code;
     int wedding_id;
     Date start_time_planned;
     Date end_time_planned;
     Date start_time;
     Date end_time;

    /**
     * Creates a new instance of WeddingManagedBean
     */
    public WeddingManagedBean() {
    }

    public UserBeanLocal getEjbean() {
        return ejbean;
    }

    public void setEjbean(UserBeanLocal ejbean) {
        this.ejbean = ejbean;
    }

    public String getWedding_code() {
        return wedding_code;
    }

    public void setWedding_code(String wedding_code) {
        this.wedding_code = wedding_code;
    }

    public Date getStart_time_planned() {
        return start_time_planned;
    }

    public void setStart_time_planned(Date start_time_planned) {
        this.start_time_planned = start_time_planned;
    }

    public Date getEnd_time_planned() {
        return end_time_planned;
    }

    public void setEnd_time_planned(Date end_time_planned) {
        this.end_time_planned = end_time_planned;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public int getWedding_id() {
        return wedding_id;
    }

    public void setWedding_id(int wedding_id) {
        this.wedding_id = wedding_id;
    }
    
    
    
    
    
    
     public String addWedding()
     {
         Wedding w=ejbean.getWeddingById(wedding_id);
         ejbean.addWedding(wedding_code, start_time_planned, end_time_planned, start_time_planned, end_time_planned);
        
//          session.setAttribute("weddingId",w.getWeddingId() );
//          System.out.print("wedding"+w.getWeddingId());
         return "UserHome.jsf?faces-redirect=true";
     }
    
     
      public String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate = dtf.format(now);
        return currentdate;
    }
      
      public String AlredySelectDate(){
          return "UserHome.jsf?faces-redirect=true";
      }
       public String goToWeddingDate(){
          return "WeddingDate.jsf?faces-redirect=true";
      }
    
}
