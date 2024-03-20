package com.kazanexpress.wms.terminal.server.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MavenInfoModel {
    private String extension;
    private String groupId;
    private String artifactId;
    private String version;
}
