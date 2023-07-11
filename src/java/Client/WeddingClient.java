/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:GenericResource [generic]<br>
 * USAGE:
 * <pre>
 *        WeddingClient client = new WeddingClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author pc
 */
public class WeddingClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/RealWeddingProject/webresources";

    public WeddingClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
    }

    public String providedServiceAdd(String planner_id, String service_id, String details, String isActive) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("plannerServiceAdd/{0}/{1}/{2}/{3}", new Object[]{planner_id, service_id, details, isActive})).request().post(null, String.class);
    }

    public void removeProduct(String product_id, String religion_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("productRemove/{0}/{1}", new Object[]{product_id, religion_id})).request().delete();
    }

    public String addProduct(String product_code, String product_name, String description, String picture, String price, String religion_id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("productAdd/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{product_code, product_name, description, picture, price, religion_id})).request().post(null, String.class);
    }

    public <T> T countryShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countryShowAll");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String editService(String service_id, String service_code, String service_name, String description, String picture, String price, String religion_id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("serviceEdit/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{service_id, service_code, service_name, description, picture, price, religion_id})).request().post(null, String.class);
    }

    public String editProduct(String product_id, String product_code, String product_name, String description, String picture, String price, String religion_id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("productEdit/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{product_id, product_code, product_name, description, picture, price, religion_id})).request().post(null, String.class);
    }

    public <T> T getServiceByPlannerId(Class<T> responseType, String p) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("PlannerServiceById/{0}", new Object[]{p}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T showAllProduct(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("listProduct");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String providedServiceRemove(String provide_service_id, String planner_id, String service_id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("plannerServiceRemove/{0}/{1}/{2}", new Object[]{provide_service_id, planner_id, service_id})).request().delete(String.class);
    }

    public <T> T getProvidedServiceId(Class<T> responseType, String psid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("ProvidedServiceById/{0}", new Object[]{psid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeService(String service_id, String religion_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("serviceRemove/{0}/{1}", new Object[]{service_id, religion_id})).request().delete();
    }

    public String userRegister(String first_name, String last_name, String user_code, String role_id, String user_email, String user_password) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("Registeruser/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{first_name, last_name, user_code, role_id, user_email, user_password})).request().post(null, String.class);
    }

    public String countryInsert(String country_name) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("countryInsert/{0}", new Object[]{country_name})).request().post(null, String.class);
    }

    public void plannerRemove(String planner_id, String role_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("plannerRemove/{0}/{1}", new Object[]{planner_id, role_id})).request().delete();
    }

    public <T> T plannerShowAll(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("plannerShowAll");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String plannerEdit(String planner_id, String planner_code, String planner_name, String role_id, String planner_email, String planner_password) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("plannerEdit/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{planner_id, planner_code, planner_name, role_id, planner_email, planner_password})).request().post(null, String.class);
    }

    public <T> T showAllPlannerService(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("listPlannerService");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getRole(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("showAllRole");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T showAllServices(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("listService");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getServiceById(Class<T> responseType, String service_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("serviceByID/{0}", new Object[]{service_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPlannerById(Class<T> responseType, String planner_id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("plannerById/{0}", new Object[]{planner_id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String providedServiceEdit(String provide_service_id, String planner_id, String service_id, String details, String isActive) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("plannerServiceEdit/{0}/{1}/{2}/{3}/{4}", new Object[]{provide_service_id, planner_id, service_id, details, isActive})).request().post(null, String.class);
    }

    public <T> T getAllUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("showAllUser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String addServices(String service_code, String service_name, String description, String picture, String price, String religion_id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("serviceAdd/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{service_code, service_name, description, picture, price, religion_id})).request().post(null, String.class);
    }

    public String plannerInsert(String planner_code, String planner_name, String role_id, String planner_email) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("plannerInsert/{0}/{1}/{2}/{3}", new Object[]{planner_code, planner_name, role_id, planner_email})).request().post(null, String.class);
    }

    public void close() {
        client.close();
    }
    
}
