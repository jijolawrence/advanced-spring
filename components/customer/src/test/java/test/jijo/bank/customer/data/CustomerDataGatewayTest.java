package test.jijo.bank.customer.data;

import com.jijo.bank.testsupport.TestScenarioSupport;
import com.jijo.bank.customer.data.CustomerDataGateway;
import com.jijo.bank.customer.data.CustomerRecord;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerDataGatewayTest {

    private TestScenarioSupport testScenarioSupport = new TestScenarioSupport("onboarding_test");
    private JdbcTemplate template = testScenarioSupport.getTemplate();
    private CustomerDataGateway gateway = new CustomerDataGateway(testScenarioSupport.getDataSource());


    @Before
    public void setUp() throws Exception {
        template.execute("DELETE FROM customer;");
    }

    @Test
    public void testCreate() {
        CustomerRecord createdCustomer = gateway.create("aCustomer");


        assertThat(createdCustomer.id).isGreaterThan(0);
        assertThat(createdCustomer.name).isEqualTo("aCustomer");

        Map<String, Object> persistedFields = template.queryForMap("SELECT id, name FROM customer WHERE id = ?", createdCustomer.id);
        assertThat(persistedFields.get("id")).isEqualTo(createdCustomer.id);
        assertThat(persistedFields.get("name")).isEqualTo(createdCustomer.name);
    }

    @Test
    public void testFind() {
        template.execute("INSERT INTO customer(id, name) VALUES (42346, 'aName'), (42347, 'anotherName'), (42348, 'andAnotherName')");


        CustomerRecord record = gateway.find(42347L);


        assertThat(record).isEqualTo(new CustomerRecord(42347L, "anotherName"));
    }

    @Test
    public void testFind_WhenNotFound() {
        assertThat(gateway.find(42347L)).isNull();
    }
}
