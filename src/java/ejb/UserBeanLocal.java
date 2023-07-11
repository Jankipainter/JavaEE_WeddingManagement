/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import Entity.Event;
import Entity.Invoice;
import Entity.Location;
import Entity.Religion;
import Entity.Role;
import Entity.Service;
import Entity.User;
import Entity.Wedding;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author pc
 */
@Local
public interface UserBeanLocal {
    
    public String getByUserEmail(String user_email,String user_pass);
    //All Religion option
    public Collection<Religion> getAllReligion();
    
    public Religion getReligionById(int religion_id);
    
    //Register
    public String userRegister(String first_name,String last_name,String user_code,int role_id,String user_email,String user_password);
    
    public User getUserById(int user_id);
    
    public Collection<User>getAllUser();
    
    public Collection getServiceByReligionId(Religion r);
    
    public Collection getProductByReligionId(Religion r);
    
    public Collection getPlannerByServiceId(Service s);
    
    public Collection getEventByReligionId(Religion r);
    
    public String generateCode();
    
    public String addWedding(String wedding_code,Date start_time_planned,Date end_time_planned,Date start_time,Date end_time);
    
    public Wedding getWeddingById(int wedding_id);
    
    public String addEvent(String event_name,int wedding_id,int location_id,Date start_time_plan,Date end_time_plan,int religion_id);
    
    public Collection<Event>getAllEvent();
    public int generateOTP();
    public void UserforgetPass(String user_email,String user_password);
    
    public Wedding getLastAddedWedding();
    
    public void addUserEvent(int event_id,Collection<Integer>uids);
    
    public Event getLastAddedEvent();
    
    public Collection<User> getUserCollection(int uid);
    
    public String addInvoice(int wedding_id,Date create_date,Date due_date,long amount,boolean paid,Date payment_time);
    
    public Invoice getLastAddedInvoice();
    
    public Location getLastAddedLocation();
    
    public Event getCountByReligion(); 
    //View Profile
    
    //Edit Profile
    
}
