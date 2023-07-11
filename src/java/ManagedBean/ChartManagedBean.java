///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
// */
//package ManagedBean;
//
//
//import java.io.Serializable;
//import javax.annotation.PostConstruct;
//import javax.enterprise.context.SessionScoped;
//import javax.inject.Named;
//import org.primefaces.model.chart.LineChartSeries;
//import org.primefaces.model.charts.line.LineChartModel;
//
///**
// *
// * @author pc
// */
//@Named(value = "chartManagedBean")
//@SessionScoped
//public class ChartManagedBean implements Serializable{
//private LineChartModel lineModel;
//
//    /**
//     * Creates a new instance of ChartManagedBean
//     */
//    public ChartManagedBean() {
//    }
//    
//    
//     @PostConstruct
//  public void init() {
//      createUserModel();
//      
//    
//  }
//
//  public LineChartModel getLineModel() {
//      return lineModel;
//  }
//
//    private void createUserModel() {
//       lineModel=new LineChartModel();
//       LineChartSeries sedans=new LineChartSeries();
//       sedans.setFill(true);
//       sedans.setLabel("user");
//       sedans.set("sedans-mini", 1200);
//       sedans.set("sedans-standard", 1300);
//       sedans.set("sedans-custom", 15599);
//       sedans.set("sedans-luxury", 18895);
//    }
//}
