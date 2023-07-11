package Entity;

import Entity.Event;
import Entity.Role;
import Entity.Selectplanner;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-06T22:15:39", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> userPassword;
    public static volatile CollectionAttribute<User, Selectplanner> selectplannerCollection;
    public static volatile CollectionAttribute<User, Event> eventCollection;
    public static volatile SingularAttribute<User, Role> roleId;
    public static volatile SingularAttribute<User, String> userEmail;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, String> userCode;

}