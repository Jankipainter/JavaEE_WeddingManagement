package Entity;

import Entity.Invoice;
import Entity.PlanProductInvoice;
import Entity.PlanServiceInvoice;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(InvoiceItem.class)
public class InvoiceItem_ { 

    public static volatile SingularAttribute<InvoiceItem, String> itemName;
    public static volatile SingularAttribute<InvoiceItem, PlanProductInvoice> productIncludeId;
    public static volatile SingularAttribute<InvoiceItem, Long> itemPrice;
    public static volatile SingularAttribute<InvoiceItem, Invoice> invoiceId;
    public static volatile SingularAttribute<InvoiceItem, PlanServiceInvoice> serviceIncludeId;
    public static volatile SingularAttribute<InvoiceItem, Integer> invoiceItemId;

}