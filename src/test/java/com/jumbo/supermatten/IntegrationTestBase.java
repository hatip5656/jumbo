package com.jumbo.supermatten;

import static org.junit.Assert.assertEquals;

import com.jumbo.supermatten.model.dto.MarketDTO;
import com.jumbo.supermatten.service.MarketService;
import lombok.RequiredArgsConstructor;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = {IntegrationTestBase.Initializer.class})
public class IntegrationTestBase {
    private static final String IMAGE_VERSION = "mysql:8.0";

    @ClassRule
    public static MySQLContainer mySQLContainer = new MySQLContainer(IMAGE_VERSION)
        .withDatabaseName("tests-db")
        .withUsername("sa")
        .withPassword("sa");

    static class Initializer
        implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                "spring.datasource.url=" + mySQLContainer.getJdbcUrl(),
                "spring.datasource.username=" + mySQLContainer.getUsername(),
                "spring.datasource.password=" + mySQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }


}
