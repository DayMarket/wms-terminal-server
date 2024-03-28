package com.kazanexpress.wms.terminal.server.repository;

import com.kazanexpress.wms.terminal.server.Driver;
import com.kazanexpress.wms.terminal.server.repository.dao.DriverDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DriverMyBatisRepository implements DriverRepository {

    private final DriverDao driverDao;

    public Driver insert(Driver driver) {
        return driverDao.insert(driver);
    }

}
