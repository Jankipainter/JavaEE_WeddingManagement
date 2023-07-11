package Entity;

import Entity.Event;
import Entity.InvoiceItem;
import Entity.PlanService;
import Entity.Status;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PlanServiceInvoice.class)
public class PlanServiceInvoice_ { 

    public static volatile SingularAttribute<PlanServiceInvoice, Event> eventId;
    public static volatile SingularAttribute<PlanServiceInvoice, Status> statusId;
    public static volatile SingularAttribute<PlanServiceInvoice, Long> price;
    public static volatile CollectionAttribute<PlanServiceInvoice, InvoiceItem> invoiceItemCollection;
    public static volatile SingularAttribute<PlanServiceInvoice, Integer> serviceIncludeId;
    public static volatile SingularAttribute<PlanServiceInvoice, PlanService> provideServiceId;

}