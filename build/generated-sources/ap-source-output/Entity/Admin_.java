package Entity;

import Entity.Role;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Admin.class)
public class Admin_ { 

    public static volatile SingularAttribute<Admin, Role> roleId;
    public static volatile SingularAttribute<Admin, Integer> adminId;
    public static volatile SingularAttribute<Admin, String> adminCode;
    public static volatile SingularAttribute<Admin, String> adminEmail;
    public static volatile SingularAttribute<Admin, String> adminPassword;

}