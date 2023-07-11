/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Event;
import Entity.Invoice;
import Entity.User;
import Entity.Wedding;
import Payment.Server;
import com.stripe.exception.StripeException;
import ejb.AdminBeanLocal;
import ejb.PlannerBeanLocal;
import ejb.UserBeanLocal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pc
 */
@Named(value = "paymentManagedBean")
@ApplicationScoped
public class PaymentManagedBean {

      @EJB
    AdminBeanLocal aejb;
    @EJB
    UserBeanLocal uejb;
    @EJB
    PlannerBeanLocal pejb;
    
    int iid;
    long amt;
    Date d,sd,ed;
    String ename;
    /**
     * Creates a new instance of PaymentManagedBean
     */
    public PaymentManagedBean() {
    }

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

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public long getAmt() {
        return amt;
    }

    public void setAmt(long amt) {
        this.amt = amt;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public Date getSd() {
        return sd;
    }

    public void setSd(Date sd) {
        this.sd = sd;
    }

    public Date getEd() {
        return ed;
    }

    public void setEd(Date ed) {
        this.ed = ed;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
    
    
    
    public void pay() throws StripeException{
       Server s=new Server();
        HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//                 session.setAttribute("UserEmail",login[1] );
       s.ServerCust();
    }
    
    public void PayLater(){
         HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        
        String createdDate = dtf.format(now);
        Wedding w=uejb.getLastAddedWedding();
        int wid=w.getWeddingId();
        Date due=w.getEndTimePlanned();
        float amt=Float.parseFloat(session.getAttribute("Total").toString());
        long amount;
        String s=uejb.addInvoice(wid, date, due, (long) amt, false, date);
        session.setAttribute("payLater", s);
        
    }
    
    public String goToPayment(){
        return "pay.jsf?faces-redirect=true";
    }
    
    
    public void payment(){
        HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
         DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        
        String createdDate = dtf.format(now);
        Wedding w=uejb.getLastAddedWedding();
        int wid=w.getWeddingId();
        Date due=w.getEndTimePlanned();
        float amt=Float.parseFloat(session.getAttribute("Total").toString());
        long amount;
        uejb.addInvoice(wid, date, due, (long) amt, true, date);
//        return "Invoice.jsf?faces-redirect=true";
    }
    
    public void sendPay()
    {
        
    }
    public String Invoice(){
        Invoice i=uejb.getLastAddedInvoice();
       iid= i.getInvoiceId();
        amt=i.getAmount();
        d=i.getPaymentTime();
        
        i.getWeddingId().getEventCollection();
        Event e=uejb.getLastAddedEvent();
        ename=e.getEventName();
        sd=e.getWeddingId().getStartTime();
        ed=e.getWeddingId().getEndTime();
        Collection<User> u=e.getUserCollection();
        return "Invoice.jsf?faces-redirect=true";
        
    }
    
}
