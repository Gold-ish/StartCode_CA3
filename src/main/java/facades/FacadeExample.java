package facades;

import entities.RenameMe;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample {

    private static FacadeExample instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeExample() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //TODO Remove/Change this before use
    public long getRenameMeCount(){
        EntityManager em = getEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
    }
    
    public long addRenameMe(String str){
        EntityManager em = getEntityManager();
        RenameMe rm = new RenameMe(str, str);
        try{
            em.getTransaction().begin();
            em.persist(rm);
            em.getTransaction().commit();
            return rm.getId();
        } finally {
            em.close();
        }
    }
    
    public RenameMe editRenameMe(RenameMe rm) throws SQLException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            RenameMe rmDB = em.find(RenameMe.class, rm.getId());
            if (rmDB == null) {
                throw new SQLException("Nothing found with id.");
            }
            em.persist(rmDB);
            em.getTransaction().commit();
            return rmDB;
        } finally {
            em.close();
        }
    }

}
