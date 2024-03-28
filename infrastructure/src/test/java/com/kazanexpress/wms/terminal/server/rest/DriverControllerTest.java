package com.kazanexpress.wms.terminal.server.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kazanexpress.wms.terminal.server.BaseDbTest;
import com.kazanexpress.wms.terminal.server.Driver;
import com.kazanexpress.wms.terminal.server.DriverDto;
import com.kazanexpress.wms.terminal.server.TestHelperUtils;
import com.kazanexpress.wms.terminal.server.repository.DriverRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class DriverControllerTest extends BaseDbTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private DriverRepository driverRepository;

    @Test
    @SneakyThrows
    void saveDriver_test() {
        Boolean enabled = true;

        MockMultipartFile file = TestHelperUtils.buildFile("file");
        when(driverRepository.insert(any())).thenReturn(
                Driver.builder()
                        .enabled(enabled)
                        .build());
        when(nexusFeignClient.upload(any(), anyBoolean(), any(), any(), any(), any(), any())).thenReturn("");

        //test
        ResultActions result = this.mockMvc.perform(
                multipart("/api/v1/driver").file(file)
                        .param("enabled", enabled.toString())
        );

        //check
        result.andExpect(status().isOk());
        DriverDto parsedResult = mapper.readValue(result.andReturn().getResponse().getContentAsString(), DriverDto.class);
        assertThat(parsedResult.isEnabled()).isEqualTo(enabled);

    }

}
