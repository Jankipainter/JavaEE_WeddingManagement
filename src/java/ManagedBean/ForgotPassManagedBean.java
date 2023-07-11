/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import ejb.UserBeanLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import mail.MailSender;

/**
 *
 * @author pc
 */
@Named(value = "forgotPassManagedBean")
@ApplicationScoped
public class ForgotPassManagedBean {
    
     @EJB
    UserBeanLocal uejb;
     int otp;
     String user_email,user_pass;

    /**
     * Creates a new instance of ForgotPassManagedBean
     */
    public ForgotPassManagedBean() {
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    
    
    public UserBeanLocal getUejb() {
        return uejb;
    }

    public void setUejb(UserBeanLocal uejb) {
        this.uejb = uejb;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }
    
    
    public String ForgotPass(){
//       int otp= uejb.generateOTP();
       return "ForgotPass.jsf?faces-redirect=true";
    }
    public void getOTP(){
        user_email=this.user_email;
        otp=uejb.generateOTP();
        MailSender ms=new MailSender();
        ms.sendEmail(user_email, "Your OTP Is", " "+otp+"Reset Your Password"+" "+"http://localhost:8080/RealWeddingProject/ResetPass.jsf");
    }
    
    public String ResetPass(){
        System.out.println("user"+user_email);
        System.out.println("user"+user_pass);
        uejb.UserforgetPass(user_email, user_pass);
        return "loginpage.jsf?faces-redirect=true";
    }
}
