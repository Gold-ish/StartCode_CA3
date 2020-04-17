package utils;


import entities.Role;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.DROP_AND_CREATE);
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords
    User admin = new User("admin", "test");
    User user1 = new User("user1", "test");
    User user2 = new User("user2", "test");
    User user3 = new User("user3", "test");

    if(admin.getUserPass().equals("test")||user1.getUserPass().equals("test")||user2.getUserPass().equals("test")||user3.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user1.addRole(userRole);
    user2.addRole(userRole);
    user3.addRole(userRole);
    admin.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user1);
    em.persist(user2);
    em.persist(user3);
    em.persist(admin);
    em.getTransaction().commit();
    System.out.println("PW: " + user1.getUserPass());
    System.out.println("Testing user with OK password: " + user1.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user1.verifyPassword("test123"));
    System.out.println("Created TEST Users");
   
  }

}
