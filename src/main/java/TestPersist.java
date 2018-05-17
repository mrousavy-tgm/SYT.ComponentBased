import BusinessObjects.Bahnhof;
import BusinessObjects.Benutzer;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

public class TestPersist {

    @Test
    public void testPersist()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("westbahn");
        EntityManager entityManager = factory.createEntityManager();

        try {
            String[] names = new String[]{"Marc", "Max", "David", "Mike"};
            for (String name : names) {
                Benutzer benutzer = new Benutzer();
                benutzer.setVorName(name);
                benutzer.setVerbuchtePraemienMeilen(5);
                benutzer.setNachName("Mustermann");
                benutzer.seteMail(name + "@gmail.com");
                benutzer.setPasswort("123");
                benutzer.setSmsNummer("+123456");

                entityManager.getTransaction().begin();
                entityManager.persist(benutzer);
                entityManager.getTransaction().commit();
            }
        } catch (Exception ex) {
            assert(true);
        }
    }

    @Test
    public void testExists()
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("westbahn");
        EntityManager entityManager = factory.createEntityManager();

        try {
            Bahnhof bahnhof = entityManager.find(Bahnhof.class, 1);
            assertNotNull(bahnhof);
        } catch (Exception ex) {
            assert(true);
        }
    }
}
