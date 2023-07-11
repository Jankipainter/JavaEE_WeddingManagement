package Entity;

import Entity.Event;
import Entity.Invoice;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Wedding.class)
public class Wedding_ { 

    public static volatile SingularAttribute<Wedding, Date> endTimePlanned;
    public static volatile CollectionAttribute<Wedding, Invoice> invoiceCollection;
    public static volatile CollectionAttribute<Wedding, Event> eventCollection;
    public static volatile SingularAttribute<Wedding, Date> startTimePlanned;
    public static volatile SingularAttribute<Wedding, String> weddingCode;
    public static volatile SingularAttribute<Wedding, Integer> weddingId;
    public static volatile SingularAttribute<Wedding, Date> startTime;
    public static volatile SingularAttribute<Wedding, Date> endTime;

}