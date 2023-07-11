package Entity;

import Entity.PlanServiceInvoice;
import Entity.Planner;
import Entity.Service;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PlanService.class)
public class PlanService_ { 

    public static volatile SingularAttribute<PlanService, Service> service;
    public static volatile SingularAttribute<PlanService, String> details;
    public static volatile SingularAttribute<PlanService, Short> isActive;
    public static volatile SingularAttribute<PlanService, Planner> planner;
    public static volatile SingularAttribute<PlanService, Integer> provideServiceId;
    public static volatile CollectionAttribute<PlanService, PlanServiceInvoice> planServiceInvoiceCollection;

}