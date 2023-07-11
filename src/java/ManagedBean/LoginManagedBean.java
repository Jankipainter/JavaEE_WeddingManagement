/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Client.WeddingClient;
import Entity.Admin;
import Entity.Planner;
import Entity.Role;
import Entity.User;
import ejb.AdminBeanLocal;
import ejb.PlannerBeanLocal;
import ejb.UserBeanLocal;
import static java.lang.System.out;
import java.util.Collection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
@Named(value = "loginManagedBean")
@ApplicationScoped
public class LoginManagedBean {

    @EJB
    AdminBeanLocal aejb;
    @EJB
    UserBeanLocal uejb;
    @EJB
    PlannerBeanLocal pejb;
    WeddingClient client = new WeddingClient();

    String email, password;

//   
//    int role_id;
//    String role_name;
//    
    int user_id;
    String user_email;
    String user_password;

    int planner_id;
    String planner_email;
    String planner_password;

    int admin_id;
    String admin_email;
    String admin_password;

    public AdminBeanLocal getAejb() {
        return aejb;
    }

    public void setAejb(AdminBeanLocal aejb) {
        this.aejb = aejb;
    }

    public UserBeanLocal getUejb() {
        return uejb;
    }

    public void setUejb(UserBeanLocal uejb) {
        this.uejb = uejb;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public int getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(int planner_id) {
        this.planner_id = planner_id;
    }

    public String getPlanner_email() {
        return planner_email;
    }

    public void setPlanner_email(String planner_email) {
        this.planner_email = planner_email;
    }

    public String getPlanner_password() {
        return planner_password;
    }

    public void setPlanner_password(String planner_password) {
        this.planner_password = planner_password;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public LoginManagedBean() {
    }

    public String Login() {

        String u = uejb.getByUserEmail(getEmail(),getPassword());
        User u1;
        
        String email123 = u;
        System.out.println("email12312323 " + u);
        
        String[] login = u.split(",", 6);
        
        System.out.println(login[0]+" "+ login[1]+ " " + login[2]);
        
        String email_user = login[1];
        String pass_user = login[2];
        String role_user = login[0];
        
        if (email_user != null && pass_user != null){
            if(role_user.equals("user")){
                 HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                 session.setAttribute("UserEmail",login[1] );
                 session.setAttribute("UserFName",login[4] );
                 session.setAttribute("UserLName",login[5] );
                 session.setAttribute("UserId",login[3] );
                return "User/WeddingDate.jsf?faces-redirect=true";
            }
            else if(role_user.equals("planner"))
            {
                HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                 session.setAttribute("PlannerEmail",login[1] );
                 session.setAttribute("PlannerName",login[4] );
                  session.setAttribute("Planner_Id",login[3] );
                 return "Planner/PlannerHome.jsf?faces-redirect=true";
            }
            else{
                return "Admin/AdminHome.jsf?faces-redirect=true";
            }
        }
        else
        {
            return "loginpage.jsf";   
        }

       
    }
     
    
//    public String userProfile(){
//        
//    }
    
    public String gotoRegister(){
        return "Register.jsf?faces-redirect=true";
    }
    
    
    
    
    }
        
    
