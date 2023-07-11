/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Client.WeddingClient;
import ejb.UserBeanLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ClientErrorException;

/**
 *
 * @author pc
 */
@Named(value = "registerManageBean")
@ApplicationScoped
public class RegisterManageBean {
    
    @EJB UserBeanLocal uejb;
    WeddingClient client=new WeddingClient();
    
    int user_id;
    String first_name;
    String last_name;
    String user_code;
    int role_id;
    String user_email;
    String user_password;
    boolean registere,notRegister;
    

    /**
     * Creates a new instance of RegisterManageBean
     */
    public RegisterManageBean() {
    }
    
   

    public UserBeanLocal getUejb() {
        return uejb;
    }

    public void setUejb(UserBeanLocal uejb) {
        this.uejb = uejb;
    }

    public WeddingClient getClient() {
        return client;
    }

    public void setClient(WeddingClient client) {
        this.client = client;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public boolean isRegistere() {
        return registere;
    }

    public void setRegistere(boolean registere) {
        this.registere = registere;
    }

    public boolean isNotRegister() {
        return notRegister;
    }

    public void setNotRegister(boolean notRegister) {
        this.notRegister = notRegister;
    }
    
    
    
     @PostConstruct
    public void init(){
        this.role_id=1;  
    }
    
    public void setFalse(){
        this.registere=false;
        this.notRegister=false;
    }
    
    public String userRegister(){
        
      
        this.role_id= 1;
        client.userRegister(first_name, last_name, user_code, String.valueOf(role_id), user_email, user_password);
       
        return "index.jsf?faces-redirect=true";
       
    }
    
}
