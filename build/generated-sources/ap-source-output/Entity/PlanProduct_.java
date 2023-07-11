package Entity;

import Entity.PlanProductInvoice;
import Entity.Planner;
import Entity.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PlanProduct.class)
public class PlanProduct_ { 

    public static volatile SingularAttribute<PlanProduct, Planner> plannerId;
    public static volatile SingularAttribute<PlanProduct, Product> productId;
    public static volatile CollectionAttribute<PlanProduct, PlanProductInvoice> planProductInvoiceCollection;
    public static volatile SingularAttribute<PlanProduct, String> details;
    public static volatile SingularAttribute<PlanProduct, Integer> provideProductId;
    public static volatile SingularAttribute<PlanProduct, Boolean> isActive;

}