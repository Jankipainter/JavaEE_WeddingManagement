/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import Entity.PlanProduct;
import Entity.PlanService;
import Entity.Planner;
import Entity.Product;
import Entity.Religion;
import Entity.Service;
import Entity.User;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author pc
 */
@Local
public interface PlannerBeanLocal {
    // public Role getRole(int role_id, String role_name);
    //Add Services
    
    public Planner getByPlannerEmail(String planner_email);
       
    public String addServices(String service_code,String service_name,String description,String picture,long price,int religion_id);
     public String editService(int service_id,String service_code,String service_name,String description,String picture,long price,int religion_id);
     public void removeService(int service_id,int religion_id);
     public Service getServiceById(int service_id);
     public Planner getPlannerById(int pid);
     public Collection<Service> showAllServices();
    //Add Product
     
     public String addProduct(String product_code,String product_name,String description,String picture,long price,int religion_id);
     public String editProduct(int product_id,String product_code,String product_name,String description,String picture,long price,int religion_id);
     public void removeProduct(int product_id,int religion_id);
     
     public Collection<Product> showAllProduct();
     
     //Specific Planner provided Services -->plan_service
     
     public String providedServiceAdd(int planner_id,int service_id,String details,short isActive);
     
     public String providedServiceEdit(int provide_service_id,int planner_id,int service_id,String details,short isActive);
     
     public String providedServiceRemove(int provide_service_id,int planner_id,int service_id);
     
     public Collection<PlanService> showAllPlannerService();
     
     public PlanService getProvidedServiceId(int psid);
     
     public Collection getServiceByPlannerId(Planner p);
     
     public Collection getServiceByPlanner(String planner_id);
     
     // public Service getServiceById(int service_id);
    
     
//Specific Planner provided Products -->plan_product
     
     public String providedProductAdd(int planner_id,int product_id,String details,boolean isActive);
     
     public String providedProductEdit(int provide_product_id,int planner_id,int product_id,String details,boolean isActive);
     
     public String providedProductRemove(int provide_product_id,int planner_id,int product_id);
     
     public Collection<PlanProduct> showAllPlannerProduct();
     
     public String addSelectPlanner(int planner_id,int user_id,int service_id);
     
      public String delSelectPlanner(int sid,int planner_id,int user_id,int service_id);
     
     public Collection getselectPlannerByPlannerId(Planner planner_id);
     
     public Collection getselectPlannerByUserId(User uid);
     
     public void removeSelectService(int sid);
     
     //Show due event
     
     
     //Show success event
     
     //show due payment for event
     
     //show event location
     
     
     //show event date(calender)
     
     
    
}
