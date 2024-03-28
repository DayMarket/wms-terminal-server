package com.kazanexpress.wms.terminal.server.rest;

import com.kazanexpress.wms.terminal.server.DriverDto;
import com.kazanexpress.wms.terminal.server.usecase.SaveDriver;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/driver")
@RequiredArgsConstructor
public class DriverController {

    private final SaveDriver saveDriver;

    @PostMapping
    public DriverDto saveDriver(@RequestPart("file") MultipartFile driver, @RequestParam boolean enabled) {
        return saveDriver.execute(driver, enabled);
    }

}
