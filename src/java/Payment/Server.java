/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Payment;
import java.nio.file.Paths;

//import static spark.Spark.post;
//import static spark.Spark.port;
//import static spark.Spark.staticFiles;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pc
 */
public class Server {
    public void ServerCust() throws StripeException  {
//        port(8080);

 Stripe.apiKey = "sk_test_51NHiwpSI9gd6L2aP6lkLwhNTMou9gHENRj3a7x0xiyreDcYJ6qyG8BGi854vyT5WnThKFcAKUXubG2gS7858vkQD00SVW04IUk";

   Map<String,Object> userParameter=new HashMap<String,Object>();
   userParameter.put("email", "a@gmail.com");
   Customer newcust=Customer.create(userParameter); 
   

    }
    
}
