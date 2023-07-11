package Entity;

import Entity.InvoiceItem;
import Entity.Wedding;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Invoice.class)
public class Invoice_ { 

    public static volatile SingularAttribute<Invoice, Long> amount;
    public static volatile SingularAttribute<Invoice, Date> dueDate;
    public static volatile SingularAttribute<Invoice, Boolean> paid;
    public static volatile SingularAttribute<Invoice, Date> createdTime;
    public static volatile SingularAttribute<Invoice, Integer> invoiceId;
    public static volatile SingularAttribute<Invoice, Wedding> weddingId;
    public static volatile SingularAttribute<Invoice, Date> paymentTime;
    public static volatile CollectionAttribute<Invoice, InvoiceItem> invoiceItemCollection;

}