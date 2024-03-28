package com.kazanexpress.wms.terminal.server;

import com.kazanexpress.wms.terminal.server.client.NexusFeignClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

@Transactional
@ActiveProfiles("test")
@SpringBootTest(classes = Application.class)
public class BaseDbTest {
    @Container
    private static final PostgreSQLContainer container = new PostgreSQLContainer("postgres:14.3-alpine");

    static {
        container.start();
        System.setProperty("DB_URL", container.getJdbcUrl());
        System.setProperty("DB_USERNAME", container.getUsername());
        System.setProperty("DB_PASSWORD", container.getPassword());
    }

    @MockBean
    protected NexusFeignClient nexusFeignClient;


}
