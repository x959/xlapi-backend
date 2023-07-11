package com.xlapi.xlapiclientsdk;


import com.xlapi.xlapiclientsdk.client.XlApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("xlapi.client")
@Data
@ComponentScan
public class XlApiClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public XlApiClient xlApiClient(){
        return new XlApiClient(accessKey, secretKey);
    }
}
