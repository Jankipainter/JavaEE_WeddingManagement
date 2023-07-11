/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import Entity.Admin;
import Entity.City;
import Entity.Country;
import Entity.Planner;
import Entity.Role;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author pc
 */
@Local
public interface AdminBeanLocal {
    
     //For Role--> Admin,User or planner
    public Collection<Role> getRole();
     public Admin getAdminById(int admin_id);
    
//    //Login Page
//    public String Login(String role_name);

    //Country
    public String countryInsert(String country_name);

    public String countryUpdate(int country_id, String country_name);

    public String countryDelete(int country_id);

    public Country countryFindById(int country_id);

    public Country countryFindByName(String country_name);

  
    public Collection<Country> countryShowAll();
    

    //City
    public String cityInsert(String city_name, int country_id);

    public String cityUpdate(int city_id, String city_name,int country_id);

    public String cityDelete(int city_id,int country_id);

    public City cityFindById(int city_id);

    public City cityFindByName(String city_name);

    public Collection<City> cityShowAll();
    
    
    //Add Planner
    public String autoPass(String name);
    
    public String plannerInsert(String planner_code,String planner_name,int role_id, String planner_email);
    
    public String plannerEdit(int planner_id,String planner_code,String planner_name,int role_id, String planner_email, String planner_password);
    
   public void plannerRemove(int planner_id,int role_id);
   
    
    
    public Collection<Planner> plannerShowAll();
    
    public Planner getPlannerById(int planner_id);
     public Boolean SendMail(String planner_email,String planner_password);
    
    
    //For login
    public String Login(String role_name,String email,String password);
    
    public Admin getByAdminEmail(String admin_email);
     public Admin getByAdminPassword(String admin_password);
    public Collection<Admin>getAllAdmin();

}
