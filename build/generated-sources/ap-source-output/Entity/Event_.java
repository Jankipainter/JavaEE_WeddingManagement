package Entity;

import Entity.Location;
import Entity.PlanProductInvoice;
import Entity.PlanServiceInvoice;
import Entity.Religion;
import Entity.User;
import Entity.Wedding;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Integer> eventId;
    public static volatile CollectionAttribute<Event, PlanProductInvoice> planProductInvoiceCollection;
    public static volatile SingularAttribute<Event, Location> locationId;
    public static volatile SingularAttribute<Event, Date> startTimePlan;
    public static volatile CollectionAttribute<Event, User> userCollection;
    public static volatile SingularAttribute<Event, String> eventName;
    public static volatile SingularAttribute<Event, Date> endTimePlan;
    public static volatile SingularAttribute<Event, Wedding> weddingId;
    public static volatile SingularAttribute<Event, Religion> religionId;
    public static volatile CollectionAttribute<Event, PlanServiceInvoice> planServiceInvoiceCollection;

}