package test.jijo.bank.customer;

import com.jijo.bank.customer.CustomerController;
import com.jijo.bank.customer.CustomerInfo;
import com.jijo.bank.customer.data.CustomerDataGateway;
import com.jijo.bank.customer.data.CustomerRecord;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class CustomerControllerTest {

    private CustomerDataGateway gateway = mock(CustomerDataGateway.class);
    private CustomerController controller = new CustomerController(gateway);

    @Test
    public void testShow() {
        doReturn(new CustomerRecord(3L, "Some Customer")).when(gateway).find(anyLong());

        CustomerInfo result = controller.show(3);

        verify(gateway).find(3L);
        assertThat(result).isEqualTo(new CustomerInfo(3L, "Some Customer", "customer info"));
    }
}
