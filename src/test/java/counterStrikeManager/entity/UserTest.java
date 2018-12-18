package counterStrikeManager.entity;

import counterStrikeManager.util.Database;
import counterStrikeManager.persistence.GenericDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Dao.
     */
    GenericDAO genericDAO;


    /**
     * Runs before each individual test, resetting the database and specifying the DAO type.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        genericDAO = new GenericDAO(User.class);
    }


    /**
     * Verifies insert successfully executes.
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Frank", "Hollis", "frankTheTank", "superSecret123");
        int newId = genericDAO.insert(newUser);
        assertNotEquals(0, newId);
        User insertedUser = (User) genericDAO.getById(newId);
        //the id's are expected to be different, so can't test if equal on entire entity
        assertEquals(newUser.getUsername(), insertedUser.getUsername());

    }


    /**
     * Verifies getById successfully executes.
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User) genericDAO.getById(1);
        assertEquals("ehollis98", retrievedUser.getUsername());
    }

    
    /**
     * Verifies update successfully executes.
     */
    @Test
    void updateSuccess() {
        User updateUser = (User) genericDAO.getById(1);
        String usernameBeforeUpdate = updateUser.getUsername();
        updateUser.setUsername("TestUsername");
        genericDAO.update(updateUser);
        User checkUser = (User) genericDAO.getById(1);
        String usernameAfterUpdate = checkUser.getUsername();
        assertNotEquals(usernameBeforeUpdate, usernameAfterUpdate);
    }


    /**
     * Verifies delete successfully executes.
     */
    @Test
    void deleteSuccess() {
        genericDAO.delete(genericDAO.getById(1));
        assertNull(genericDAO.getById(1));
    }


}