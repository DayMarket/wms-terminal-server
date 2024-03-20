package com.kazanexpress.wms.terminal.server.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NexusAssetModel {
    private String downloadUrl;
    private String path;
    private String repository;
    private String contentType;
    private int fileSize;
    private MavenInfoModel maven2;
}
