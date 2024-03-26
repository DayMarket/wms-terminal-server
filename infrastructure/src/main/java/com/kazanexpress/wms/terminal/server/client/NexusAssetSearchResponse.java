package com.kazanexpress.wms.terminal.server.client;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class NexusAssetSearchResponse {
    private List<NexusAssetModel> items;
    private String continuationToken;
}
