import dto.Employee;
import org.junit.Assert;
import org.junit.Test;
import service.DBService;


import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class DBServiceTest {

    @Test
    public void insert_validUser_returnPersistedUser() throws ClassNotFoundException, SQLException {

        DBService service = new DBService();
        Employee toSave = new Employee();
        toSave.setDob("1986-10-04");
        toSave.setFirstName("Ruben");
        toSave.setLastName("Lopes");
        toSave.setGender("M");

        Employee new_employee = (service.insertEmployee(toSave));

        Assert.assertTrue(new_employee.getFirstName().equals(toSave.getFirstName()));

        //another example
        assertThat(new_employee).isEqualToIgnoringGivenFields(toSave, "number", "hireDate");

    /*@Test
        public void insert_validUser_returnHireDateAsToday() throws ClassNotFoundException, SQLException {

            DBService service = new DBService();
            Employee toSave = new Employee();
            toSave.setDob("1986-10-04");
            toSave.setFirstName("Ruben");
            toSave.setLastName("Lopes");
            toSave.setGender("M");
            toSave.setHireDate("1986-10-04");

            Employee new_employee = (service.insertEmployee(toSave));

            Assert.assertTrue(new_employee.getFirstName().equals(toSave.getFirstName()));

            //another example
            assertThat(new_employee).isEqualToIgnoringGivenFields(toSave, "number");

*/


    }
}
