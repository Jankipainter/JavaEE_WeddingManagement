package Entity;

import Entity.PlanProduct;
import Entity.Religion;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> productCode;
    public static volatile SingularAttribute<Product, Integer> productId;
    public static volatile SingularAttribute<Product, Long> price;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile CollectionAttribute<Product, PlanProduct> planProductCollection;
    public static volatile SingularAttribute<Product, Religion> religionId;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, String> picture;

}