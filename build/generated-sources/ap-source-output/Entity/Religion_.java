package Entity;

import Entity.Event;
import Entity.Product;
import Entity.Service;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Religion.class)
public class Religion_ { 

    public static volatile CollectionAttribute<Religion, Event> eventCollection;
    public static volatile CollectionAttribute<Religion, Product> productCollection;
    public static volatile SingularAttribute<Religion, String> religionName;
    public static volatile SingularAttribute<Religion, Integer> religionId;
    public static volatile CollectionAttribute<Religion, Service> serviceCollection;

}