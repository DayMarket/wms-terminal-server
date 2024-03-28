package com.kazanexpress.wms.terminal.server.repository;

import org.springframework.web.multipart.MultipartFile;

public interface NexusClient {

    String upload(String repository,
                  boolean generatePom,
                  String groupId,
                  String artifactId,
                  String version,
                  MultipartFile file,
                  String extension);
}
