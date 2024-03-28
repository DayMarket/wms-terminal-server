package com.kazanexpress.wms.terminal.server.rest;


import com.kazanexpress.wms.terminal.server.client.NexusAssetSearchResponse;
import com.kazanexpress.wms.terminal.server.client.NexusFeignClient;
import feign.Response;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.apache.commons.io.IOUtils.toByteArray;


@RestController
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {


    @Value("${wms.nexus.repository-name}")
    private String repository;
    @Value("${wms.nexus.group-id}")
    private String group;
    @Value("${wms.nexus.artifact-id}")
    private String name;

    private final NexusFeignClient nexusClient;

    @GetMapping
    public NexusAssetSearchResponse get(@RequestParam String version) {
        return nexusClient.search(repository,
                group,
                name,
                version,
                "jar");
    }

    @GetMapping("/download")
    @SneakyThrows
    public ResponseEntity<ByteArrayResource> download(@RequestParam String version) {
        Response response = nexusClient.download(repository,
                group,
                name,
                version,
                "jar");

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("inline; filename=%s", "jar.jar"));
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new ByteArrayResource(toByteArray(response.body().asInputStream())));
    }

    @PostMapping
    @SneakyThrows
    public String post(@RequestParam String version,
                       @RequestPart("file") MultipartFile file) {

        return nexusClient.upload(repository,
                true,
                group,
                name,
                version,
                file,
                "jar"
        );
    }

}
