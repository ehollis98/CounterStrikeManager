package counterStrikeManager.entity;

import counterStrikeManager.persistence.GenericDAO;
import counterStrikeManager.util.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

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
        genericDAO = new GenericDAO(Report.class);
    }

    /**
     * Verifies insert successfully executes.
     */
    @Test
    void insertSuccess() {
        Report newReport = new Report(0, "TestReport", new Date(2018, 12, 18), 0, 0, "test");
        int newId = genericDAO.insert(newReport);
        assertNotEquals(0, newId);
        Report insertedReport = (Report) genericDAO.getById(newId);
        //the id's are expected to be different, so can't test if equal on entire entity
        assertEquals(newReport.getName(), insertedReport.getName());

    }

    /**
     * Verifies getById successfully executes.
     */
    @Test
    void getByIdSuccess() {
        Report retrievedReport = (Report) genericDAO.getById(1);
        assertEquals("TestReport", retrievedReport.getName());
    }


    /**
     * Verifies update successfully executes.
     */
    @Test
    void updateSuccess() {
        Report updateReport = (Report) genericDAO.getById(1);
        String statisticTypeBeforeUpdate = updateReport.getStatisticType();
        updateReport.setStatisticType("category05");
        genericDAO.update(updateReport);
        Report checkReport = (Report) genericDAO.getById(1);
        String statisticTypeAfterUpdate = checkReport.getStatisticType();
        assertNotEquals(statisticTypeBeforeUpdate, statisticTypeAfterUpdate);
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