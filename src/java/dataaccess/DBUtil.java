package dataaccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Alex Tompkins - 821984
 */
public class DBUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UsersPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
