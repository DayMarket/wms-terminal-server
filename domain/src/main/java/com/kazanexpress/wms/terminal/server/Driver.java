package com.kazanexpress.wms.terminal.server;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Driver {
    private UUID id;
    private Date createdTimestamp;
    private String groupName;
    private String name;
    private long version;
    private Long workerId;
    private String extension;
    private boolean enabled;
}
