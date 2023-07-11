/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Client.WeddingClient;
import Entity.PlanService;
import Entity.Planner;
import Entity.Service;
import ejb.AdminBeanLocal;
import ejb.PlannerBeanLocal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

/**
 *
 * @author pc
 */
@Named(value = "serviceManagedBean")
@ApplicationScoped
public class ServiceManagedBean {

    @EJB PlannerBeanLocal pejb;
     @EJB AdminBeanLocal aejb;
    WeddingClient client=new WeddingClient();
    
    
    int service_id,planner_id;
    String service_code,details;
    String service_name;
    String description;
    String picture;
    long price;
    int religion_id;
    Response res;
    
    UploadedFile file;
    String photos;
    
    Collection<Service>getAllService;
    ArrayList<Service>getServiceCount;
     GenericType<Service> gplanobj = new GenericType<Service>() {};
     
       Planner p;
    
     Collection<PlanService> getServiceByPlannerId;
    /**
     * Creates a new instance of ServiceManagedBean
     */
    public ServiceManagedBean() {
    }

    public PlannerBeanLocal getPejb() {
        return pejb;
    }

    public void setPejb(PlannerBeanLocal pejb) {
        this.pejb = pejb;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public String getService_code() {
        return service_code;
    }

    public void setService_code(String service_code) {
        this.service_code = service_code;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public int getGetServiceCount() {
        getAllService=pejb.showAllServices();
        getServiceCount=new ArrayList<Service>(getAllService);
        return getServiceCount.size();
    }

    public void setGetServiceCount(ArrayList<Service> getServiceCount) {
        this.getServiceCount = getServiceCount;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getReligion_id() {
        return religion_id;
    }

    public void setReligion_id(int religion_id) {
        this.religion_id = religion_id;
    }

    public WeddingClient getClient() {
        return client;
    }

    public void setClient(WeddingClient client) {
        this.client = client;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public int getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(int planner_id) {
        this.planner_id = planner_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Planner getP() {
        return p;
    }

    public void setP(Planner p) {
        this.p = p;
    }
    
    

//    public Part getFile() {
//        return file;
//    }
//
//    public void setFile(Part file) {
//        this.file = file;
//    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public GenericType<Service> getGplanobj() {
        return gplanobj;
    }

    public void setGplanobj(GenericType<Service> gplanobj) {
        this.gplanobj = gplanobj;
    }

    public Collection<Service> getGetAllService() {
        getAllService=pejb.showAllServices();
        return getAllService;
    }

    public void setGetAllService(Collection<Service> getAllService) {
        this.getAllService = getAllService;
    }

    public Collection<PlanService> getGetServiceByPlannerId() {
        return getServiceByPlannerId;
    }

    public void setGetServiceByPlannerId(Collection<PlanService> getServiceByPlannerId) {
        this.getServiceByPlannerId = getServiceByPlannerId;
    }
    
    public String goToAdd(){
        return "AddServices.jsf?faces-redirect=true";
    }
    
    public String addService() {
       
            try {
               // InputStream input=file.getInputStream();
                InputStream input=file.getInputStream();
                String path = "J:\\8sem\\project\\RealWeddingProject\\web\\resources\\Upload";
                Random r=new Random();
                StringBuilder sb=new StringBuilder();
                
                sb.append(r.nextInt(9)+1);
                for(int i=0;i<11;i++)
                {
                    sb.append(r.nextInt(10));
                }
                String temp=sb.toString();
                
                 String ext = FilenameUtils.getExtension(file.getFileName());

                 photos=temp +"_upload."+ext;
                 Files.copy(input, new File(path,photos).toPath());
                 
       client.addServices(service_code, service_name, description, photos, String.valueOf(price), String.valueOf(religion_id));
      
        HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
              HttpSession session=request.getSession();
              session.setAttribute("Image", photos);
                return "ServiceList.jsf?faces-redirect=true";
              
//                photos="IMG_" + temp + ".jpg";
//                Files.copy(input, new File(path,photos).toPath());
            } catch (Exception ex) {
                ex.printStackTrace();
               // return "ServiceList.jsf";
            }
        return null;
    }
    
    
    
    
    public String toEditService(int id){
        String id1=String.valueOf(id);
         res = client.getServiceById(Response.class, id1);
         Service s=new Service();
         s = res.readEntity(gplanobj);
         service_id=s.getServiceId();
         service_name=s.getServiceName();
         service_code=s.getServiceCode();
         description=s.getDescription();
         picture=s.getPicture();
         
         price=s.getPri();
         religion_id=s.getReligion().getReligionId();
         return "EditService.jsf";
         
    }
    
    public String edirService()
    {
       try {
            InputStream input=file.getInputStream();
            
            String path = "\\J:\\8sem\\project\\RealWeddingProject\\web\\resources\\Upload";
            Random r=new Random();
            StringBuilder sb=new StringBuilder();
            
            sb.append(r.nextInt(9)+1);
            for(int i=0;i<11;i++)
            {
                sb.append(r.nextInt(10));
            }
            String temp=sb.toString();
             String ext = FilenameUtils.getExtension(file.getFileName());
           photos=temp +"_upload."+ext;
        
            Files.copy(input, new File(path,photos).toPath());
              client.editService(String.valueOf(service_id), service_code, service_name, description, photos, String.valueOf(price), String.valueOf( religion_id));

              HttpServletRequest request=(HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
              HttpSession session=request.getSession();
              session.setAttribute("Image", photos);
              
              
        return "ServiceList.jsf";
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      return null;
    }
    
    public String goToServiceList(){
        return "ServiceList.jsf?faces-redirect=true";
    }
    
    public String getAllServiceByPID(int planner_id)
    {
         HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
              planner_id=  (int) session.getAttribute("Planner_Id");
              System.out.println("Planner Id"+planner_id);
              p=aejb.getPlannerById(planner_id);
         getServiceByPlannerId=pejb.getServiceByPlannerId(p);
         return "PlannerHome.jsf";
    }
    
}
