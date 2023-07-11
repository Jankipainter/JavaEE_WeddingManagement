package Entity;

import Entity.Planner;
import Entity.Service;
import Entity.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Selectplanner.class)
public class Selectplanner_ { 

    public static volatile SingularAttribute<Selectplanner, Planner> plannerId;
    public static volatile SingularAttribute<Selectplanner, Service> serviceId;
    public static volatile SingularAttribute<Selectplanner, User> userId;
    public static volatile SingularAttribute<Selectplanner, Integer> sid;

}