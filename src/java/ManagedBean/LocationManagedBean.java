/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.City;
import Entity.Country;
import ejb.AdminBeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
/**
 *
 * @author pc
 */
@Named(value = "locationManagedBean")
@RequestScoped
public class LocationManagedBean {

        private MapModel geoModel;
//    private MapModel revGeoModel;
    private String centerGeoMap = "41.850033, -87.6500523";
    
    
     @PostConstruct
    public void init() {
        geoModel = new DefaultMapModel();
       
    }
    
    
     public void onGeocode() {
         GeocodeEvent event = null;
        List<GeocodeResult> results = event.getResults();

        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();

            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
            }
        }
    }

    public void setGeoModel(MapModel geoModel) {
        this.geoModel = geoModel;
    }

    public void setCenterGeoMap(String centerGeoMap) {
        this.centerGeoMap = centerGeoMap;
    }
     
      public MapModel getGeoModel() {
        return geoModel;
    }

   
    public String getCenterGeoMap() {
        return centerGeoMap;
    }

    
    
}
