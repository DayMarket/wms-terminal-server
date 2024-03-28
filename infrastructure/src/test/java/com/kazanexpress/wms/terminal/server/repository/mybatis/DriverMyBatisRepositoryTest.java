package com.kazanexpress.wms.terminal.server.repository.mybatis;

import com.kazanexpress.wms.terminal.server.BaseDbTest;
import com.kazanexpress.wms.terminal.server.repository.DriverMyBatisRepository;
import com.kazanexpress.wms.terminal.server.repository.DriverRepository;
import com.kazanexpress.wms.terminal.server.repository.DriverRepositoryTest;
import org.springframework.beans.factory.annotation.Autowired;

public class DriverMyBatisRepositoryTest extends BaseDbTest implements DriverRepositoryTest {

    @Autowired
    private DriverMyBatisRepository driverRepository;

    @Override
    public DriverRepository getDriverRepository() {
        return driverRepository;
    }
}
