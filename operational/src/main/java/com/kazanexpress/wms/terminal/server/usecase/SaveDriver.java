package com.kazanexpress.wms.terminal.server.usecase;

import com.kazanexpress.wms.terminal.server.Driver;
import com.kazanexpress.wms.terminal.server.DriverDto;
import com.kazanexpress.wms.terminal.server.factory.DriverFactory;
import com.kazanexpress.wms.terminal.server.mapper.DriverMapper;
import com.kazanexpress.wms.terminal.server.repository.DriverRepository;
import com.kazanexpress.wms.terminal.server.repository.NexusClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveDriver {

    private final NexusClient nexusClient;
    private final DriverRepository driverRepository;
    private final DriverFactory driverFactory;
    private final DriverMapper driverMapper;

    @Value("${wms.nexus.repository-name}")
    private String repository;
    @Value("${wms.nexus.group-id}")
    private String group;
    @Value("${wms.nexus.artifact-id}")
    private String name;
    @Value("${wms.nexus.extension}")
    private String extension;


    @Transactional
    public DriverDto execute(MultipartFile driverFile, boolean enabled) {
        log.info("Saving driver file to nexus with enabled [{}]", enabled);

        Driver driver = driverRepository.insert(driverFactory.createFrom(group, name, extension, enabled));
        nexusClient.upload(repository,
                true,
                driver.getGroupName(),
                driver.getName(),
                String.valueOf(driver.getVersion()),
                driverFile,
                extension
        );

        log.info("Driver {} is saved", driver);
        return driverMapper.createFrom(driver);
    }

}
