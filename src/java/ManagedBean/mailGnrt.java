/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.mail.Session;
import mail.MailSender;

/**
 *
 * @author pc
 */
@Named(value = "mailGnrt")
@SessionScoped
public class mailGnrt implements Serializable {
    String fromMail;
    String toEmail;
    String subject;
    String msg;
    String user;
    String pass;
    Session session;
String planner_email;
String planner_password;
    /**
     * Creates a new instance of mailGnrt
     */
    public mailGnrt() {
    }

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    
    
   
    public void send(){
        try{
            MailSender ms= new MailSender();
//            ms.sendMail(fromMail, toEmail, subject, msg, user, pass);
           ms.sendEmail( getPlanner_email(), "your login id", getPlanner_password());
            System.out.print(getPlanner_email());
            System.out.print("mail send");
        }catch(Exception e)
        {
            
        }
    }
}
