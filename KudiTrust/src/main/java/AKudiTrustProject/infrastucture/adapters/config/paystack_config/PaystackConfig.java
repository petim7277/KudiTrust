package AKudiTrustProject.infrastucture.adapters.config.paystack_config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PaystackConfig {
    @Value("${PAYSTACK_API_KEY}")
    private String paystackApiKey;

    @Value("${PAYSTACK_BASE_URL}")
    private String paystackBaseUrl;
}
