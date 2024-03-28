package com.kazanexpress.wms.terminal.server.client;


import com.kazanexpress.wms.terminal.server.repository.NexusClient;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@FeignClient(url = "${wms.nexus.url}", name = "nexus-client", configuration = FeignConfig.class)
public interface NexusFeignClient extends NexusClient {

    @GetMapping("/service/rest/v1/search/assets")
    NexusAssetSearchResponse search(@RequestParam String repository,
                                    @RequestParam(required = false) String group,
                                    @RequestParam(required = false) String name,
                                    @RequestParam(required = false) String version,
                                    @RequestParam(required = false, name = "maven.extension") String extension

    );

    @GetMapping("/service/rest/v1/search/assets/download")
    Response download(@RequestParam String repository,
                      @RequestParam(required = false) String group,
                      @RequestParam(required = false) String name,
                      @RequestParam(required = false) String version,
                      @RequestParam(required = false, name = "maven.extension") String extension

    );

    @PostMapping(value = "/service/rest/v1/components",
            consumes = MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestParam(required = false) String repository,
                  @RequestPart("maven2.generate-pom") boolean generatePom,
                  @RequestPart("maven2.groupId") String groupId,
                  @RequestPart("maven2.artifactId") String artifactId,
                  @RequestPart("version") String version,
                  @RequestPart("maven2.asset1") MultipartFile file,
                  @RequestPart("maven2.asset1.extension") String extension
    );
}
