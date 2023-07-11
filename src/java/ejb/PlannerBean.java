/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import Entity.PlanProduct;
import Entity.PlanService;
import Entity.Planner;
import Entity.Product;
import Entity.Religion;
import Entity.Selectplanner;
import Entity.Service;
import Entity.User;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author pc
 */
@Stateless
public class PlannerBean implements PlannerBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
      @PersistenceContext(unitName="PersistenceUnit")
    EntityManager em;
    
    @Override
    public String addServices(String service_code, String service_name, String description, String picture, long price,int religion_id) {
        Religion r=em.find(Religion.class, religion_id);
        Collection<Service>slist=r.getServiceCollection();
        Service s=new Service();
        s.setServiceCode(service_code);
        s.setServiceName(service_name);
        s.setDescription(description);
        s.setPicture(picture);
        s.setPri(price);
        s.setReligion(r);
        slist.add(s);
        r.setServiceCollection(slist);
        em.persist(s);
        em.merge(r);
        return "services added";
    }

    @Override
    public String editService(int service_id, String service_code, String service_name, String description, String picture, long price,int religion_id) {
         Religion r=em.find(Religion.class, religion_id);
        Collection<Service>slist=r.getServiceCollection();
        Service s=(Service)em.find(Service.class, service_id);
        s.setServiceCode(service_code);
       s.setServiceName(service_name);
        s.setDescription(description);
        s.setPicture(picture);
        s.setPri(price);
        s.setReligion(r);
        slist.add(s);
        r.setServiceCollection(slist);
        em.merge(s);
        return "Services edited";
    }

    @Override
    public void removeService(int service_id,int religion_id) {
          Religion r=em.find(Religion.class, religion_id);
        Collection<Service>slist=r.getServiceCollection();
        Service s=(Service)em.find(Service.class, service_id);
        if(slist.contains(s))
        {
            slist.remove(s);
            r.setServiceCollection(slist);
             em.remove(s);
       
        }
       
    }
    
    @Override
    public Collection<Service> showAllServices() {
        return em.createNamedQuery("Service.findAll").getResultList();
    }

    @Override
    public String addProduct(String product_code, String product_name, String description, String picture, long price,int religion_id) {
          Religion r=em.find(Religion.class, religion_id);
          Collection<Product>plist=r.getProductCollection();
        Product p=new Product();
        p.setProductCode(product_code);
        p.setProductName(product_name);
        p.setDescription(description);
        p.setPicture(picture);
        p.setPrice(price);
        p.setReligionId(r);
        plist.add(p);
        r.setProductCollection(plist);
        em.persist(p);
        em.merge(r);
        return "Product added";
    }

    @Override
    public String editProduct(int product_id, String product_code, String product_name, String description, String picture, long price,int religion_id) {
        Religion r=em.find(Religion.class, religion_id);
          Collection<Product>plist=r.getProductCollection();
        Product p=(Product)em.find(Product.class, product_id);
        p.setProductCode(product_code);
        p.setProductName(product_name);
        p.setDescription(description);
        p.setPicture(picture);
        p.setPrice(price);
        p.setReligionId(r);
        plist.add(p);
        r.setProductCollection(plist);
        em.merge(p);
        return "Product added";
    }

    @Override
    public void removeProduct(int product_id,int religion_id) {
         Religion r=em.find(Religion.class, religion_id);
          Collection<Product>plist=r.getProductCollection();
        Product p=(Product)em.find(Product.class, product_id);
        if(plist.contains(p))
        {
            plist.remove(p);
            r.setProductCollection(plist);
              em.remove(p);
        }
      
       
    }

    

    @Override
    public Collection<Product> showAllProduct() {
        return em.createNamedQuery("Product.findAll").getResultList();
    }
    
    //provided services

    @Override
    public String providedServiceAdd(int planner_id, int service_id, String details, short isActive) {
        Planner p=(Planner)em.find(Planner.class, planner_id);
        Collection<PlanService>Provideplanner=p.getPlanServiceCollection();
        Service s=(Service)em.find(Service.class, service_id);
        Collection<PlanService>ProvideService=s.getPlanServiceCollection();
        
        PlanService ps=new PlanService();
        ps.setDetails(details);
        ps.setIsActive(isActive);
       ps.setPlanner(p);
        ps.setService(s);
        
        Provideplanner.add(ps);
        ProvideService.add(ps);
        
        p.setPlanServiceCollection(ProvideService);
        s.setPlanServiceCollection(ProvideService);
        em.persist(ps);
        em.merge(p);
        em.merge(s);
        return "Provide Services added";
    }

     @Override
    public String providedServiceEdit(int provide_service_id, int planner_id, int service_id, String details, short isActive) {
        Planner p=(Planner)em.find(Planner.class, planner_id);
        Collection<PlanService>Provideplanner=p.getPlanServiceCollection();
        Service s=(Service)em.find(Service.class, service_id);
        Collection<PlanService>ProvideService=s.getPlanServiceCollection();
        
         PlanService ps=(PlanService)em.find(PlanService.class, provide_service_id);
        ps.setDetails(details);
        ps.setIsActive(isActive);
        ps.setPlanner(p);
        ps.setService(s);
        
        Provideplanner.add(ps);
        ProvideService.add(ps);
        
        p.setPlanServiceCollection(Provideplanner);
        s.setPlanServiceCollection(ProvideService);
        
        em.merge(ps);
        return "Editedd provided services";
        
        
    }

    @Override
    public String providedServiceRemove(int provide_service_id, int planner_id, int service_id) {
        Planner p=(Planner)em.find(Planner.class, planner_id);
        Collection<PlanService>Provideplanner=p.getPlanServiceCollection();
        Service s=(Service)em.find(Service.class, service_id);
        Collection<PlanService>ProvideService=s.getPlanServiceCollection();
         PlanService ps=(PlanService)em.find(PlanService.class, provide_service_id);
         if(ProvideService.contains(ps) && Provideplanner.contains(ps))
         {
             ProvideService.remove(ps);
             p.setPlanServiceCollection(ProvideService);
             
             Provideplanner.remove(ps);
             p.setPlanServiceCollection(Provideplanner);
             
             em.remove(ps);
            
         }
          return "removed provided services";
    }
    
     @Override
    public Collection<PlanService> showAllPlannerService() {
        return em.createNamedQuery("PlanService.findAll").getResultList();
    }

    @Override
    public Collection getServiceByPlannerId(Planner p) {
        return em.createNamedQuery("PlanService.findByPlannerId").setParameter("planner", p).getResultList();
    }
    
//     @Override
//    public Collection getServiceByServiceId(Service s) {
//       return em.createNamedQuery("PlanService.findByServiceId").setParameter("service", s).getResultList();
//    }

    //Provided product
    @Override
    public String providedProductAdd(int planner_id, int product_id, String details, boolean isActive) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    @Override
    public String providedProductEdit(int provide_product_id, int planner_id, int product_id, String details, boolean isActive) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String providedProductRemove(int provide_product_id, int planner_id, int product_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    @Override
    public Collection<PlanProduct> showAllPlannerProduct() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Service getServiceById(int service_id) {
       return em.find(Service.class, service_id);
    }

    @Override
    public Planner getByPlannerEmail(String planner_email) {
         Collection<Planner>u= em.createNamedQuery("Planner.findByPlannerEmail").setParameter("plannerEmail", planner_email).getResultList();
//        System.out.println("user :"+u); 
        for(Planner a1:u)
       {
           
           return a1;
       }
       return null;
       
    }

    @Override
    public Collection getServiceByPlanner(String planner_id) {
       return em.createNamedQuery("PlanService.findByPlannerId").setParameter("planner", planner_id).getResultList();
    }

    @Override
    public PlanService getProvidedServiceId(int psid) {
        return em.find(PlanService.class, psid);
    }

    @Override
    public String addSelectPlanner(int planner_id, int user_id, int service_id) {
       Planner p=em.find(Planner.class, planner_id);
       User u=em.find(User.class, user_id);
       Service s=em.find(Service.class, service_id);
       Selectplanner sp=new Selectplanner();
       sp.setPlannerId(p);
       sp.setUserId(u);
       sp.setServiceId(s);
       em.persist(sp);
       return "added..";
    }

    @Override
    public Collection getselectPlannerByPlannerId(Planner planner_id) {
        return em.createNamedQuery("Selectplanner.findByPlannerId").setParameter("plannerId", planner_id).getResultList();
    }

    @Override
    public Planner getPlannerById(int pid) {
       return em.find(Planner.class, pid);
    }

    @Override
    public Collection getselectPlannerByUserId(User uid) {
        return em.createNamedQuery("Selectplanner.findByUserId").setParameter("userId", uid).getResultList();
    }

    @Override
    public String delSelectPlanner(int sid, int planner_id, int user_id, int service_id) {
       Planner p=em.find(Planner.class, planner_id);
       User u=em.find(User.class, user_id);
       Service s=em.find(Service.class, service_id);
       Selectplanner sp=em.find(Selectplanner.class, sid);
       Collection<Selectplanner>s1=p.getSelectplannerCollection();
       Collection<Selectplanner>s2=u.getSelectplannerCollection();
       Collection<Selectplanner>s3=s.getSelectplannerCollection();
       if(s1.contains(sp) && s2.contains(sp) && s3.contains(sp))
       {
           s1.remove(s);
           p.setSelectplannerCollection(s1);
           
             s2.remove(s);
           u.setSelectplannerCollection(s2);
           
             s3.remove(s);
           s.setSelectplannerCollection(s3);
           
           em.remove(s);
       }
       return null;
    }

    @Override
    public void removeSelectService(int sid) {
        Selectplanner sp=em.find(Selectplanner.class, sid);
        em.remove(sp);
    }

   
   
    
}
