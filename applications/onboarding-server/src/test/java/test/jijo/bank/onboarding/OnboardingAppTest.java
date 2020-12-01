package test.jijo.bank.onboarding;

import com.jijo.bank.onboarding.App;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class OnboardingAppTest {

    @Test
    public void embedded() {
        App.main(new String[]{});

        RestTemplate restTemplate = new RestTemplate();

//        assertThat(restTemplate.getForObject("http://localhost:8181/customers/0", String.class)).isEqualTo(null);
    }
}
