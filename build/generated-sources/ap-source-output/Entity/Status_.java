package Entity;

import Entity.PlanProductInvoice;
import Entity.PlanServiceInvoice;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Status.class)
public class Status_ { 

    public static volatile SingularAttribute<Status, Boolean> offer;
    public static volatile SingularAttribute<Status, Boolean> offerAccepted;
    public static volatile SingularAttribute<Status, Integer> statusId;
    public static volatile CollectionAttribute<Status, PlanProductInvoice> planProductInvoiceCollection;
    public static volatile SingularAttribute<Status, Boolean> offerRejected;
    public static volatile SingularAttribute<Status, String> statusName;
    public static volatile CollectionAttribute<Status, PlanServiceInvoice> planServiceInvoiceCollection;

}