package com.kazanexpress.wms.terminal.server;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
    private UUID id;
    private Date createdTimestamp;
    private String group;
    private String name;
    private long version;
    private Long workerId;
    private String extension;
    private boolean enabled;
}
