package com.kazanexpress.wms.terminal.server.factory;

import com.kazanexpress.wms.terminal.server.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverFactory {

    public Driver createFrom(String group,
                             String name,
                             String extension,
                             boolean enabled) {
        return Driver.builder()
                .groupName(group)
                .name(name)
                .extension(extension)
                .enabled(enabled)
                .build();
    }

}
