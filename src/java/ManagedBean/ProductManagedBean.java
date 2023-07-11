/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Client.WeddingClient;
import Entity.Product;
import Entity.Service;
import ejb.PlannerBeanLocal;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Random;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

/**
 *
 * @author pc
 */
@Named(value = "productManagedBean")
@ApplicationScoped
public class ProductManagedBean {

     @EJB PlannerBeanLocal pejb;
    WeddingClient client=new WeddingClient();
    
    
    int product_id;
    String product_code;
    String product_name;
    String description;
    String picture;
    long price;
    int religion_id;
    Response res;
    
    UploadedFile file;
    String photos;
    
    Collection<Product>getAllProduct;
     GenericType<Product> gplanobj = new GenericType<Product>() {};
    /**
     * Creates a new instance of ProductManagedBean
     */
    public ProductManagedBean() {
    }

    public PlannerBeanLocal getPejb() {
        return pejb;
    }

    public void setPejb(PlannerBeanLocal pejb) {
        this.pejb = pejb;
    }

    public WeddingClient getClient() {
        return client;
    }

    public void setClient(WeddingClient client) {
        this.client = client;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public Collection<Product> getGetAllProduct() {
        getAllProduct=pejb.showAllProduct();
        return getAllProduct;
    }

    public void setGetAllProduct(Collection<Product> getAllProduct) {
        this.getAllProduct = getAllProduct;
    }

    public GenericType<Product> getGplanobj() {
        return gplanobj;
    }

    public void setGplanobj(GenericType<Product> gplanobj) {
        this.gplanobj = gplanobj;
    }
    
    
    
    public String addProduct()
    {
        try {
               // InputStream input=file.getInputStream();
                InputStream input=file.getInputStream();
                String path = "J:\\8sem\\project\\WeddingProject\\web\\resources\\Upload";
                Random r=new Random();
                StringBuilder sb=new StringBuilder();
                
                sb.append(r.nextInt(9)+1);
                for(int i=0;i<11;i++)
                {
                    sb.append(r.nextInt(10));
                }
                String temp=sb.toString();
                
                 String ext = FilenameUtils.getExtension(file.getFileName());

                 photos=temp +"_productUpload."+ext;
                 Files.copy(input, new File(path,photos).toPath());
                 
        client.addProduct(product_code, product_name, description, photos, String.valueOf(price), String.valueOf(religion_id));
        return "ProductList.jsf";
              
//                photos="IMG_" + temp + ".jpg";
//                Files.copy(input, new File(path,photos).toPath());
            } catch (Exception ex) {
                ex.printStackTrace();
               // return "ServiceList.jsf";
            }
        return null;
      
    }
    
}
