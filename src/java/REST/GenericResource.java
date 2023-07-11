/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package REST;

import Entity.Country;
import Entity.PlanService;
import Entity.Planner;
import Entity.Product;
import Entity.Role;
import Entity.Service;
import Entity.User;
import ejb.AdminBeanLocal;
import ejb.PlannerBeanLocal;
import ejb.UserBeanLocal;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author pc
 */

@Path("generic")
public class GenericResource {

    @EJB AdminBeanLocal ab;
    @EJB PlannerBeanLocal pb;
    @EJB UserBeanLocal ub;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    @Path("showAllRole")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Role> getRole() {
        return ab.getRole();
    }
    
     @Path("showAllUser")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAllUser() {
        return ub.getAllUser();
    }
   
    
    //User Register
    @Path("Registeruser/{first_name}/{last_name}/{user_code}/{role_id}/{user_email}/{user_password}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String userRegister(@PathParam("first_name")String first_name,@PathParam("last_name") String last_name,@PathParam("user_code") String user_code,@PathParam("role_id") int role_id,@PathParam("user_email") String user_email,@PathParam("user_password") String user_password){
        return ub.userRegister(first_name, last_name, user_code, role_id, user_email, user_password);
    }
    
    
    @Path("countryInsert/{country_name}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
   public String countryInsert(@PathParam("country_name")String country_name)
   {
       return ab.countryInsert(country_name);
   }
   
  @Path("countryShowAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
   public Collection<Country> countryShowAll(){
       return ab.countryShowAll();
   }
   
   //Planner--->
   
   @Path("plannerInsert/{planner_code}/{planner_name}/{role_id}/{planner_email}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
   public String plannerInsert(@PathParam("planner_code")String planner_code,@PathParam("planner_name")String planner_name,@PathParam("role_id")int role_id,@PathParam("planner_email") String planner_email){
       return ab.plannerInsert(planner_code, planner_name, role_id, planner_email);
   }
   
   @Path("plannerEdit/{planner_id}/{planner_code}/{planner_name}/{role_id}/{planner_email}/{planner_password}")
    @POST
    @Produces("application/json")
   public String plannerEdit(@PathParam("planner_id")int planner_id,@PathParam("planner_code")String planner_code,@PathParam("planner_name")String planner_name,@PathParam("role_id")int role_id,@PathParam("planner_email") String planner_email,@PathParam("planner_password") String planner_password){
       return ab.plannerEdit(planner_id, planner_code, planner_name, role_id, planner_email, planner_password);
   }
   
   @Path("plannerRemove/{planner_id}/{role_id}")
   @DELETE
    @Produces(MediaType.APPLICATION_JSON)
   public void plannerRemove(@PathParam("planner_id")int planner_id,@PathParam("role_id")int role_id)
   {
       ab.plannerRemove(planner_id, role_id);
   }
   
   @Path("plannerShowAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
   public Collection<Planner> plannerShowAll(){
       return ab.plannerShowAll();
   }
   
   @Path("plannerById/{planner_id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
   public Planner getPlannerById(@PathParam("planner_id")int planner_id){
       return ab.getPlannerById(planner_id);
   }
//   //Product List-->
   @Path("productAdd/{product_code}/{product_name}/{description}/{picture}/{price}/{religion_id}")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   public String addProduct(@PathParam("product_code")String product_code,@PathParam("product_name")String product_name,@PathParam("description")String description,@PathParam("picture")String picture,@PathParam("price")long price,@PathParam("religion_id")int religion_id)
   {
       return pb.addProduct(product_code, product_name, description, picture, price, religion_id);
   }
   
   @Path("productEdit/{product_id}/{product_code}/{product_name}/{description}/{picture}/{price}/{religion_id}")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   public String editProduct(@PathParam("product_id")int product_id,@PathParam("product_code")String product_code,@PathParam("product_name")String product_name,@PathParam("description")String description,@PathParam("picture")String picture,@PathParam("price")long price,@PathParam("religion_id")int religion_id)
   {
       return pb.editProduct(product_id, product_code, product_name, description, picture, price, religion_id);
   }
   
   @Path("productRemove/{product_id}/{religion_id}")
   @DELETE
   @Produces(MediaType.APPLICATION_JSON)
   public void removeProduct(@PathParam("product_id")int product_id,@PathParam("religion_id")int religion_id)
   {
        pb.removeProduct(product_id, religion_id);
   }
   
   @Path("listProduct")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Collection<Product> showAllProduct(){
       return pb.showAllProduct();
   }
   
   //Service List-->
   @Path("serviceAdd/{service_code}/{service_name}/{description}/{picture}/{price}/{religion_id}")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   public String addServices(@PathParam("service_code")String service_code,@PathParam("service_name")String service_name,@PathParam("description")String description,@PathParam("picture")String picture,@PathParam("price")long price,@PathParam("religion_id")int religion_id){
       return pb.addServices(service_code, service_name, description, picture, price, religion_id);
   }
   
   @Path("serviceEdit/{service_id}/{service_code}/{service_name}/{description}/{picture}/{price}/{religion_id}")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   public String editService(@PathParam("service_id")int service_id,@PathParam("service_code")String service_code,@PathParam("service_name")String service_name,@PathParam("description")String description,@PathParam("picture")String picture,@PathParam("price")long price,@PathParam("religion_id")int religion_id){
       return pb.editService(service_id, service_code, service_name, description, picture, price, religion_id);
   }
   
   @Path("serviceRemove/{service_id}/{religion_id}")
   @DELETE
   @Produces(MediaType.APPLICATION_JSON)
   public void removeService(@PathParam("service_id")int service_id,@PathParam("religion_id")int religion_id){
        pb.removeService(service_id, religion_id);
   }
   
   @Path("serviceByID/{service_id}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Service getServiceById(@PathParam("service_id")int service_id){
       return pb.getServiceById(service_id);
   }
   
   
   @Path("listService")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Collection<Service> showAllServices(){
       return pb.showAllServices();
   }
   
   //Planner Provided Services-->Plan_Service
   @Path("plannerServiceAdd/{planner_id}/{service_id}/{details}/{isActive}")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   public String providedServiceAdd(@PathParam("planner_id")int planner_id,@PathParam("service_id")int service_id,@PathParam("details")String details,@PathParam("isActive")short isActive){
       return pb.providedServiceAdd(planner_id, service_id, details, isActive);
   }
   
   @Path("plannerServiceEdit/{provide_service_id}/{planner_id}/{service_id}/{details}/{isActive}")
   @POST
   @Produces(MediaType.APPLICATION_JSON)
   public String providedServiceEdit(@PathParam("provide_service_id")int provide_service_id,@PathParam("planner_id")int planner_id,@PathParam("service_id")int service_id,@PathParam("details")String details,@PathParam("isActive")short isActive){
       return pb.providedServiceEdit(provide_service_id, planner_id, service_id, details, isActive);
   }
   
   @Path("plannerServiceRemove/{provide_service_id}/{planner_id}/{service_id}")
   @DELETE
   @Produces(MediaType.APPLICATION_JSON)
   public String providedServiceRemove(@PathParam("provide_service_id")int provide_service_id,@PathParam("planner_id")int planner_id,@PathParam("service_id")int service_id){
       return pb.providedServiceRemove(provide_service_id, planner_id, service_id);
   }
   
    @Path("ProvidedServiceById/{psid}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public PlanService getProvidedServiceId(@PathParam("psid")int psid){
       return pb.getProvidedServiceId(psid);
   }
   
   @Path("listPlannerService")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Collection<PlanService> showAllPlannerService(){
       return pb.showAllPlannerService();
   }
   
   @Path("PlannerServiceById/{p}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public Collection getServiceByPlannerId(@PathParam("p")Planner p)
   {
       return pb.getServiceByPlannerId(p);
   }
}
