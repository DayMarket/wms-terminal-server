package com.kazanexpress.wms.terminal.server.repository;


import com.kazanexpress.wms.terminal.server.Driver;
import com.kazanexpress.wms.terminal.server.TestHelperUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public interface DriverRepositoryTest {
    DriverRepository getDriverRepository();

    @Test
    default void insert_test() {
        DriverRepository driverRepository = getDriverRepository();
        Driver driverToSave = TestHelperUtils.buildDriverToSave();

        //test
        Driver result = driverRepository.insert(driverToSave);

        //check
        assertThat(result.getId()).isNotNull();
        assertThat(result.getCreatedTimestamp()).isNotNull();
        assertThat(result.getVersion()).isEqualTo(driverToSave.getVersion());
        assertThat(result.getName()).isEqualTo(driverToSave.getName());
        assertThat(result.getGroupName()).isEqualTo(driverToSave.getGroupName());
    }


}
