package com.kazanexpress.wms.terminal.server.repository.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

@Slf4j
@MappedTypes(UUID.class)
public class UuidTypeHandler implements TypeHandler<UUID> {

    private static UUID toUUID(String val) {
        if (!StringUtils.isBlank(val)) {
            try {
                return UUID.fromString(val);
            } catch (IllegalArgumentException e) {
                log.warn("Bad UUID found: {}", val);
            }
        }
        return null;
    }

    @Override
    public void setParameter(PreparedStatement ps,
                             int i,
                             UUID parameter,
                             JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter, Types.OTHER);
    }

    @Override
    public UUID getResult(ResultSet rs,
                          String columnName) throws SQLException {
        return toUUID(rs.getString(columnName));
    }

    @Override
    public UUID getResult(ResultSet rs,
                          int columnIndex) throws SQLException {
        return toUUID(rs.getString(columnIndex));
    }

    @Override
    public UUID getResult(CallableStatement cs,
                          int columnIndex) throws SQLException {
        return toUUID(cs.getString(columnIndex));
    }
}
