package com.kazanexpress.wms.terminal.server.mapper;

import com.kazanexpress.wms.terminal.server.Driver;
import com.kazanexpress.wms.terminal.server.DriverDto;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    public DriverDto createFrom(Driver driver) {
        return DriverDto.builder()
                .id(driver.getId())
                .createdTimestamp(driver.getCreatedTimestamp())
                .group(driver.getGroupName())
                .name(driver.getName())
                .version(driver.getVersion())
                .workerId(driver.getWorkerId())
                .extension(driver.getExtension())
                .enabled(driver.isEnabled())
                .build();
    }
}
