/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import Entity.Admin;
import Entity.City;
import Entity.Country;
import Entity.Planner;
import Entity.Role;
import Entity.User;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc
 */
@DeclareRoles({"admin","user","planner"})
@Stateless
public class AdminBean implements AdminBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(unitName = "PersistenceUnit")
    EntityManager em;

    @Override
    public Collection<Role> getRole() {
        
        return  em.createNamedQuery("Role.findAll").getResultList();
    }

    @Override
    public String countryInsert(String country_name) {
        Country c = new Country();
        c.setCountryName(country_name);
        em.persist(c);
        return "Country Inserted";
    }

    @Override
    public String countryUpdate(int country_id, String country_name) {
        Country c = (Country) em.find(Country.class, country_id);
        c.setCountryName(country_name);
        em.merge(c);
        return "Country Updated";
    }

    @Override
    public String countryDelete(int country_id) {
        Country c = (Country) em.find(Country.class, country_id);
        em.remove(c);
        return "Country Deleted";
    }

    @Override
    public Country countryFindById(int country_id) {
        return em.find(Country.class, country_id);
    }

    @Override
    public Country countryFindByName(String country_name) {
        Collection<Country> c = em.createNamedQuery("Country.findByCountryName").setParameter("country_name", country_name).getResultList();
        return (Country) c;
    }

    @Override
    public Collection<Country> countryShowAll() {
        //return em.createNamedQuery("Country.findAll").getResultList();
        Collection<Country> c = em.createNamedQuery("Country.findAll").getResultList();
        return c;
    }

    @Override
    public String cityInsert(String city_name, int country_id) {
        Country c = em.find(Country.class, country_id);
        Collection<City> city = c.getCityCollection();
        City c1 = new City();
        c1.setCityName(city_name);
        c1.setCountryId(c);
        city.add(c1);
        c.setCityCollection(city);
        em.persist(city);
        em.merge(c);
        return "City Inserted";
    }

    @Override
    public String cityUpdate(int city_id, String city_name, int country_id) {
        Country country = (Country) em.find(Country.class, country_id);
        Collection<City> city = country.getCityCollection();

        City c = (City) em.find(City.class, city_id);
        city.remove(c);

        c.setCityName(city_name);
        c.setCountryId(country);

        city.add(c);
        country.setCityCollection(city);

        em.merge(c);
        return "City Updayted";

    }

    @Override
    public String cityDelete(int city_id, int country_id) {
        City city = (City) em.find(City.class, city_id);
        Country country = (Country) em.find(Country.class, country_id);
        Collection<City> c = country.getCityCollection();
        if (c.contains(city)) {
            c.remove(city);
            country.setCityCollection(c);
            em.remove(city);
        }
        return "City Deleted";
    }

    @Override
    public City cityFindById(int city_id) {
        return em.find(City.class, city_id);
    }

    @Override
    public City cityFindByName(String city_name) {
        Collection<City> c = em.createNamedQuery("City.findByCityName").setParameter("city_name", city_name).getResultList();
        return (City) c;
    }

    @Override
    public Collection<City> cityShowAll() {
        return em.createNamedQuery("City.findAll").getResultList();
    }

    @Override
    public String plannerInsert(String planner_code, String planner_name, int role_id, String planner_email) {
        try {
            String pass=autoPass(planner_name);
            Role role = em.find(Role.class, role_id);
            Collection<Planner> p = role.getPlannerCollection();
            Planner planner = new Planner();
            planner.setPlannerCode(planner_code);
            planner.setPlannerName(planner_name);
            planner.setRoleId(role);
            planner.setPlannerEmail(planner_email);
            planner.setPlannerPassword(pass);
            p.add(planner);
            role.setPlannerCollection(p);
            em.persist(planner);
            em.merge(role);

            return "planner added";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    
  

    @Override
    public String plannerEdit(int planner_id, String planner_code, String planner_name, int role_id, String planner_email, String planner_password) {
        try {
            Role r = em.find(Role.class, role_id);
            Planner p = (Planner) em.find(Planner.class, planner_id);
            Collection<Planner> planner = r.getPlannerCollection();
//            planner.remove(p);
            p.setPlannerCode(planner_code);
            p.setPlannerName(planner_name);
            p.setPlannerEmail(planner_email);
            p.setPlannerPassword(planner_password);
            p.setRoleId(r);
//            planner.add(p);
            r.setPlannerCollection(planner);
            em.merge(p);
            return "edited Planner";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void plannerRemove(int planner_id, int role_id) {
        try {
            Planner p = (Planner) em.find(Planner.class, planner_id);
            Role r = (Role) em.find(Role.class, role_id);
            Collection<Planner> planner = r.getPlannerCollection();
            if (planner.contains(p)) {
                planner.remove(p);
                r.setPlannerCollection(planner);
                em.remove(p);
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
 
    @Override
    public Boolean SendMail(String planner_email,String planner_password) {
        Planner p=(Planner) em.createNamedQuery("Planner.findByPlannerEmail").setParameter("plannerEmail", planner_email).getResultList().get(0);
//        Planner p1=(Planner) em.createNamedQuery("Planner.findByPlannerPassword").setParameter("planner_password", planner_password).getResultList().get(0);
        
        return EmailService.EmailService.sendFromGMail(p.getPlannerEmail(), "Here is your planner email and password","hi..");
        
    }
    
    @Override
    public Collection<Planner> plannerShowAll() {
      return em.createNamedQuery("Planner.findAll").getResultList();
    }
    
     @Override
    public Planner getPlannerById(int planner_id) {
       return em.find(Planner.class, planner_id);
    }

 
    @Override
    public String Login(String role_name, String email, String password) {
        Role r=(Role) em.createNamedQuery("Role.findByRoleName").setParameter("role_name", role_name).getResultList();
       if(r.equals("user"))
       {
            em.createNamedQuery("User.findByUserEmail").setParameter("user_email", email).getResultList();
           return "User Login";
       }
       else if(r.equals("planner"))
       {
           em.createNamedQuery("Planner.findByPlannerEmail").setParameter("planner_email",email).getResultList();
            return "Planner Login";
       }
       else if(r.equals("admin"))
       {
            em.createNamedQuery("Admin.findByAdminEmail").setParameter("admin_email",email).getResultList();
            return "Admin Login";
       }
       return null;
    }

    @Override
    public Admin getAdminById(int admin_id) {
       return em.find(Admin.class, admin_id);
    }

    @Override
    public Admin getByAdminEmail(String admin_email) {
        System.out.println("Admin"+admin_email);
       Collection<Admin> a=em.createNamedQuery("Admin.findByAdminEmail").setParameter("adminEmail", admin_email).getResultList();
       for(Admin a1:a)
       {
           return a1;
       }
       return null;
    }

    @Override
    public Collection<Admin> getAllAdmin() {
        return em.createNamedQuery("Admin.findAll").getResultList();
    }

    @Override
    public Admin getByAdminPassword(String admin_password) {
        Collection<Admin> a=em.createNamedQuery("Admin.findByAdminPassword").setParameter("adminPassword", admin_password).getResultList();
       for(Admin a1:a)
       {
           return a1;
       }
       return null;
    }

    @Override
    public String autoPass(String name) {
       
        int i;
        return String.valueOf(Math.random())+"name";
    }

    

   

}
