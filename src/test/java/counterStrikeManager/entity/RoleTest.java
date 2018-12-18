package counterStrikeManager.entity;

import counterStrikeManager.persistence.GenericDAO;
import counterStrikeManager.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

class RoleTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * The Generic Dao.
     */
    GenericDAO genericDAO;

    /**
     * The User Dao.
     */
    GenericDAO userDAO;

    /**
     * Runs before each individual test, resetting the database and specifying the DAO type.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        genericDAO = new GenericDAO(Role.class);
        userDAO = new GenericDAO(User.class);
    }

    /**
     * Verifies insert successfully executes.
     */
    @Test
    void insertSuccess() {
        User user = (User) userDAO.getById(1);
        Role newRole = new Role(user, "defaultUser", "darko98");
        user.addRole(newRole);
        int newId = genericDAO.insert(newRole);
        assertNotEquals(0, newId);
    }


    /**
     * Verifies getById successfully executes.
     */
    @Test
    void getByIdSuccess() {
        Role role = (Role) genericDAO.getById(1);
        assertEquals("admin", role.getRoleName());
    }


    /**
     * Verifies update successfully executes.
     */
    @Test
    void updateSuccess() {
        Role updateRole = (Role) genericDAO.getById(1);
        String roleNameBeforeUpdate = updateRole.getRoleName();
        updateRole.setRoleName("Boss");
        genericDAO.update(updateRole);
        Role checkRole = (Role) genericDAO.getById(1);
        String roleNameAfterUpdate = checkRole.getRoleName();
        assertNotEquals(roleNameBeforeUpdate, roleNameAfterUpdate);
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