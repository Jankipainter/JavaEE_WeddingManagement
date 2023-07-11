/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import Entity.Admin;
import Entity.Event;
import Entity.Invoice;
import Entity.Location;
import Entity.Planner;
import Entity.Religion;
import Entity.Role;
import Entity.Service;
import Entity.User;
import Entity.Wedding;
import HashUtility.HashUtility;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc
 */
@Stateless
public class UserBean implements UserBeanLocal {

    @PersistenceContext(unitName = "PersistenceUnit")
    EntityManager em;
    HashUtility haspass;
    @PostConstruct
    public void init() {
        haspass = new HashUtility();
    }

    @Override
    public String userRegister(String first_name, String last_name, String user_code, int role_id, String user_email, String user_password) {
      
//     String pass= haspass.getHashPassword(user_password);
        try {

            Role r = em.find(Role.class, role_id);
            //Collection<Role>role=em.createNamedQuery("Role.findAll").getResultList();
            Collection<User> u = r.getUserCollection();
//           if(role.contains(1))
//           {
            User user = new User();
            user.setFirstName(first_name);
            user.setLastName(last_name);
            user.setUserCode(user_code);
            user.setUserEmail(user_email);
            user.setUserPassword(user_password);
            user.setRoleId(r);

            u.add(user);
            r.setUserCollection(u);
            em.persist(user);
            em.merge(r);
            return "user registered..";
//           }
//               
//                
//            
//            else{
//                return "this is not user";
//            }
        } catch (Exception e) {
            return null;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Collection<Religion> getAllReligion() {
        return em.createNamedQuery("Religion.findAll").getResultList();
    }

    @Override
    public Religion getReligionById(int religion_id) {
        return em.find(Religion.class, religion_id);
    }

    @Override
    public User getUserById(int user_id) {
        return em.find(User.class, user_id);
    }

    @Override
    public String getByUserEmail(String user_email,String user_pass) {
        System.err.println("user email" + user_email);
        System.err.println("user pass" + user_pass);
        
        Collection<User> u = em.createNamedQuery("User.findByUserEmail").setParameter("userEmail", user_email).getResultList();
        Collection<User> u1 = em.createNamedQuery("User.findByUserPassword").setParameter("userPassword", user_pass).getResultList();
        Collection<Planner> p = em.createNamedQuery("Planner.findByPlannerEmail").setParameter("plannerEmail", user_email).getResultList();
        System.out.println("userssss" + u);
        if (!u.isEmpty() && !u1.isEmpty()) {
            System.out.println("user :" + u+" "+u1);
            for (User a1 : u) {
//                boolean passtohash=haspass.checkPassword(a1.getUserPassword(), user_pass);
////                 String passtohash=haspass.getHashPassword(user_pass);
//                System.out.println("pass has"+passtohash);
//                if(!passtohash)
//                {
//                    a1.setUserPassword(user_pass);
//                }
                return "user," + a1.getUserEmail() + "," + a1.getUserPassword() +","+a1.getUserId()+","+a1.getFirstName()+","+a1.getLastName();
            }
        } else if (!p.isEmpty()) {
            for (Planner a1 : p) {

                return "planner," + a1.getPlannerEmail() + "," + a1.getPlannerPassword()+","+a1.getPlannerId()+","+a1.getPlannerName();
            }
        } else {
//            System.out.println("Adminssss"+a);
            Collection<Admin> a = em.createNamedQuery("Admin.findByAdminEmail").setParameter("adminEmail", user_email).getResultList();
            System.out.println("Adminssss" + a);
            if (a != null) {
                for (Admin a1 : a) {
                    return "admin," + a1.getAdminEmail() + "," + a1.getAdminPassword();
                }
            }
        }
        return null;
    }

    @Override
    public Collection getServiceByReligionId(Religion r) {
        return em.createNamedQuery("Service.findByReligionId").setParameter("religion", r).getResultList();
    }

    @Override
    public Collection getPlannerByServiceId(Service s) {
        return em.createNamedQuery("PlanService.findByServiceId").setParameter("service", s).getResultList();
    }

    @Override
    public String generateCode() {
        int min = 101;
//       String w = null;
        int max = 9999;
        return String.valueOf(Math.random() * Math.floor(min + max - 1));
    }

    @Override
    public String addWedding(String wedding_code, Date start_time_planned, Date end_time_planned, Date start_time, Date end_time) {
        Wedding w = new Wedding();
        wedding_code = this.generateCode();
        w.setWeddingCode(wedding_code);
        w.setStartTimePlanned(start_time_planned);
        w.setEndTimePlanned(end_time_planned);
        w.setStartTime(start_time);
        w.setEndTime(end_time);
        em.persist(w);
        return "added";
    }

    @Override
    public Wedding getWeddingById(int wedding_id) {
        return em.find(Wedding.class, wedding_id);
    }

    @Override
    public String addEvent(String event_name, int wedding_id, int location_id, Date start_time_plan, Date end_time_plan, int religion_id) {
        Wedding w = em.find(Wedding.class, wedding_id);
        Location l = em.find(Location.class, location_id);
        Religion r = em.find(Religion.class, religion_id);
        Event e = new Event();
        e.setEventName(event_name);
        e.setWeddingId(w);
        e.setLocationId(l);
        e.setReligionId(r);
        e.setStartTimePlan(start_time_plan);
        e.setEndTimePlan(end_time_plan);
        em.persist(e);
        return "added";
    }

    @Override
    public Collection<User> getAllUser() {
       return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public Collection getProductByReligionId(Religion r) {
       return em.createNamedQuery("Product.findByReligionId").setParameter("religionId", r).getResultList();
    }

    @Override
    public int generateOTP() {
         int min = 100000;
        int max = 999999;
         return (int) Math.floor(Math.random()*(max-min+1)+min);
    }

    @Override
    public void UserforgetPass(String user_email,String user_password) {
//        int otp=this.generateOTP();
        Collection<User>u =  em.createNamedQuery("User.findByUserEmail").setParameter("userEmail", user_email).getResultList();
       if (!u.isEmpty()) {
            for (User a1 : u) {
               a1.setUserPassword(user_password);
        em.merge(a1);  
            }
       }
       
        
    }

    @Override
    public Wedding getLastAddedWedding() {
       return (Wedding) em.createQuery("SELECT w FROM Wedding w ORDER BY w.weddingId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public void addUserEvent(int event_id,Collection<Integer>uids) {
//       
        Event e=em.find(Event.class, event_id);
        Collection<User>user=e.getUserCollection();
        for(Integer uid:uids)
        {
             User u=em.find(User.class, uid);
             if(!user.contains(u))
             {
                 Collection<Event>events=u.getEventCollection();
                 user.add(u);
                 events.add(e);
                 
                 e.setUserCollection(user);
                 u.setEventCollection(events);
                 em.merge(e);
             }
        }
    }

    @Override
    public Event getLastAddedEvent() {
         return  (Event) em.createQuery("SELECT e FROM Event e ORDER BY e.eventId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public Collection<User> getUserCollection(int uid) {
        Event e=em.find(Event.class, uid);
        return e.getUserCollection();
    }

    @Override
    public String addInvoice(int wedding_id, Date create_date, Date due_date, long amount, boolean paid, Date payment_time) {
        
       Wedding w=em.find(Wedding.class, wedding_id);
       Collection<Invoice>i=w.getInvoiceCollection();
       Invoice i1=new Invoice();
       i1.setWeddingId(w);
       i1.setCreatedTime(create_date);
       i1.setDueDate(due_date);
       i1.setAmount(amount);
       i1.setPaid(paid);
       i1.setPaymentTime(payment_time);
       em.persist(i1);
       return "paid add";
    }

    @Override
    public Invoice getLastAddedInvoice() {
         return  (Invoice) em.createQuery("SELECT i FROM Invoice i ORDER BY i.invoiceId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public Location getLastAddedLocation() {
        return (Location) em.createQuery("SELECT l FROM Location l ORDER BY l.locationId DESC").setMaxResults(1).getSingleResult();
    }

    @Override
    public Event getCountByReligion() {
        return (Event) em.createQuery("SELECT COUNT(e.eventId) FROM Event e where e.religionId=1").setMaxResults(1).getSingleResult();
    }

    @Override
    public Collection<Event> getAllEvent() {
       return em.createNamedQuery("Event.findAll").getResultList();
    }

    @Override
    public Collection getEventByReligionId(Religion r) {
       return em.createNamedQuery("Event.findByReligionId").setParameter("religionId", r).getResultList();
    }

}
