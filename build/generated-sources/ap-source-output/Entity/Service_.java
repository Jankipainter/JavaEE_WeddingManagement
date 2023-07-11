package Entity;

import Entity.PlanService;
import Entity.Religion;
import Entity.Selectplanner;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile CollectionAttribute<Service, Selectplanner> selectplannerCollection;
    public static volatile SingularAttribute<Service, String> serviceCode;
    public static volatile SingularAttribute<Service, Long> pri;
    public static volatile CollectionAttribute<Service, PlanService> planServiceCollection;
    public static volatile SingularAttribute<Service, String> description;
    public static volatile SingularAttribute<Service, Integer> serviceId;
    public static volatile SingularAttribute<Service, String> serviceName;
    public static volatile SingularAttribute<Service, String> picture;
    public static volatile SingularAttribute<Service, Religion> religion;

}