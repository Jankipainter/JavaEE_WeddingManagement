package Entity;

import Entity.PlanProduct;
import Entity.PlanService;
import Entity.Role;
import Entity.Selectplanner;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Planner.class)
public class Planner_ { 

    public static volatile CollectionAttribute<Planner, Selectplanner> selectplannerCollection;
    public static volatile SingularAttribute<Planner, Integer> plannerId;
    public static volatile SingularAttribute<Planner, String> plannerName;
    public static volatile SingularAttribute<Planner, Role> roleId;
    public static volatile SingularAttribute<Planner, String> plannerEmail;
    public static volatile CollectionAttribute<Planner, PlanService> planServiceCollection;
    public static volatile SingularAttribute<Planner, String> plannerCode;
    public static volatile CollectionAttribute<Planner, PlanProduct> planProductCollection;
    public static volatile SingularAttribute<Planner, String> plannerPassword;

}