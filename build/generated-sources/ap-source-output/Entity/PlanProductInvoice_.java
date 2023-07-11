package Entity;

import Entity.Event;
import Entity.InvoiceItem;
import Entity.PlanProduct;
import Entity.Status;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PlanProductInvoice.class)
public class PlanProductInvoice_ { 

    public static volatile SingularAttribute<PlanProductInvoice, Event> eventId;
    public static volatile SingularAttribute<PlanProductInvoice, Status> statusId;
    public static volatile SingularAttribute<PlanProductInvoice, Integer> productIncludeid;
    public static volatile SingularAttribute<PlanProductInvoice, Long> price;
    public static volatile SingularAttribute<PlanProductInvoice, PlanProduct> provideProductId;
    public static volatile CollectionAttribute<PlanProductInvoice, InvoiceItem> invoiceItemCollection;

}