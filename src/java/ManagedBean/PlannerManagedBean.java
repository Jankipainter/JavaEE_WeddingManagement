/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Client.WeddingClient;
import Entity.Planner;
import Entity.Role;
import com.sun.istack.NotNull;
import javax.ws.rs.core.Response;
import ejb.AdminBeanLocal;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.core.GenericType;
import mail.MailSender;
import org.primefaces.PrimeFaces;

/**
 *
 * @author pc
 */
@Named(value = "plannerManagedBean")
@ApplicationScoped
public class PlannerManagedBean {

    @EJB
    private AdminBeanLocal ejbean;
    private WeddingClient client = new WeddingClient();
    
   

    public WeddingClient getClient() {
        return client;
    }

    public void setClient(WeddingClient client) {
        this.client = client;
    }
    Response res;
    int pid;
//        private String planner_id;
    private String planner_name;
    private String planner_code;
    private String planner_email;
    private String planner_password;
    private int role_id;
    Collection<Planner> planners;
    GenericType<List<Planner>> gplan;
    Collection<Role> roles;
    GenericType<List<Role>> grole;

    GenericType<Planner> gplanobj = new GenericType<Planner>() {};

    
     String fromMail;
    String toEmail;
    
    String msg;
   
    Session session;
//    public String getPlanner_id() {
//        return planner_id;
//    }
//
//    public void setPlanner_id(String planner_id) {
//        this.planner_id = planner_id;
//    }
    public String getPlanner_name() {
        return planner_name;
    }

    public void setPlanner_name(String planner_name) {
        this.planner_name = planner_name;
    }

    public String getPlanner_code() {
        return planner_code;
    }

    public void setPlanner_code(String planner_code) {
        this.planner_code = planner_code;
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public GenericType<Planner> getGplanobj() {
        return gplanobj;
    }

    public void setGplanobj(GenericType<Planner> gplanobj) {
        this.gplanobj = gplanobj;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Collection<Planner> getPlanners() {
        res = client.plannerShowAll(Response.class);
        List<Planner> planners = res.readEntity(gplan);
        return planners;
    }

    public void setPlanners(Collection<Planner> planners) {
        this.planners = planners;
    }

    public Collection<Role> getRoles() {
        res = client.getRole(Response.class);
        List<Role> roles = res.readEntity(grole);
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public GenericType<List<Planner>> getGplan() {
        return gplan;
    }

    public void setGplan(GenericType<List<Planner>> gplan) {
        this.gplan = gplan;
    }

    public GenericType<List<Role>> getGrole() {
        return grole;
    }

    public void setGrole(GenericType<List<Role>> grole) {
        this.grole = grole;
    }

    /**
     * Creates a new instance of PlannerManagedBean
     */
    public PlannerManagedBean() {
    }

    //plannerList
    public Collection<Planner> showAllPlanner() {

        return ejbean.plannerShowAll();

    }

    public String goToAdd() {
        return "AddPlanner.jsf?faces-redirect=true";
    }

    public String addPlanner() {
        this.role_id=2;
        client.plannerInsert(planner_code, planner_name, String.valueOf(role_id), planner_email);
        return "PlannerList.jsf?faces-redirect=true";
    }

    public String plannerRemove(int id1, int id2) {
        client.plannerRemove(String.valueOf(id1), String.valueOf(id2));
        return "PlannerList.jsf";
    }

    public String goToPlannerEdit(int id) {
        String id1 = String.valueOf(id);
        res = client.getPlannerById(Response.class, id1);
        Planner p = new Planner();
        p = res.readEntity(gplanobj);
        pid = p.getPlannerId();
        planner_name = p.getPlannerName();
        planner_email = p.getPlannerEmail();
        planner_code = p.getPlannerCode();
        role_id = p.getRoleId().getRoleId();
        planner_password = p.getPlannerPassword();
        return "PlannerEdit.jsf";
    }

    public String plannerUpdate() {
        client.plannerEdit(String.valueOf(pid), planner_code, planner_name, String.valueOf(role_id), planner_email, planner_password);
        return "PlannerList.jsf?faces-redirect=true";
    }

    public Collection<Role> getRole() {
        return ejbean.getRole();
    }

    public String goToPlannerList() {
        return "PlannerList.jsf";
    }
    
    
    public String sendEmail(int id){
        String id1 = String.valueOf(id);
        res = client.getPlannerById(Response.class, id1);
        Planner p = new Planner();
        p = res.readEntity(gplanobj);
        pid = p.getPlannerId();
        planner_name = p.getPlannerName();
        planner_email = p.getPlannerEmail();
        planner_code = p.getPlannerCode();
        role_id = p.getRoleId().getRoleId();
        planner_password = p.getPlannerPassword();
        return "SendMail.jsf";
    }
    
     public void send(String toEmail,String msg){
        try{
            MailSender ms= new MailSender();
//            ms.sendMail(fromMail, toEmail, subject, msg, user, pass);
           ms.sendEmail( toEmail, "your login id ", "Use Your Email := "+toEmail+" "+"And Your Password :=  "+" "+msg+" "+"to access The Real Wedding site link:= "+ "http://localhost:8080/RealWeddingProject/loginpage.jsf");
            System.out.print(toEmail);
            System.out.print("mail send");
        }catch(Exception e)
        {
            
        }
    }
     
      public void showMessage() {
        
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Message", "Message Send Successfullyyyy..");

        PrimeFaces.current().dialog().showMessageDynamic(message);
          
    }

    
    public String gotoPlannerList()
    {
        return "PlannerList.jsf?faces-redirect=true";
    }
   
    public String gotoUserList()
    {
        return "UserList.jsf?faces-redirect=true";
    }
    
      public String gotoAdminHome()
    {
        return "AdminHome.jsf?faces-redirect=true";
    }
    
      
      public String gotoServiceList()
    {
        return "ServiceList.jsf?faces-redirect=true";
    }
      
    public String gotoplannerhome(){
        return "PlannerHome.jsf?faces-redirect=true";
    }
    
      public String gotoplannerAddservice(){
        return "AddPlannerService.jsf?faces-redirect=true";
    }
      
      public String gotoSelectList(){
          return "SelectedService.jsf?faces-redirect=true";
      }
    
    }
