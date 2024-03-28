package com.kazanexpress.wms.terminal.server;

import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils;

public class TestHelperUtils {

    public static Driver buildDriverToSave() {
        return Driver.builder()
                .groupName(RandomStringUtils.random(5))
                .name(RandomStringUtils.random(5))
                .extension(RandomStringUtils.random(5))
                .enabled(false)
                .build();
    }

    public static MockMultipartFile buildFile(String name) {
        return new MockMultipartFile(
                name,
                RandomStringUtils.random(5),
                MediaType.APPLICATION_OCTET_STREAM_VALUE,
                RandomStringUtils.random(50).getBytes()
        );
    }
}
