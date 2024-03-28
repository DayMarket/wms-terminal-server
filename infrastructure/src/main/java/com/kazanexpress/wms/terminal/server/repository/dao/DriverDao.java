package com.kazanexpress.wms.terminal.server.repository.dao;

import com.kazanexpress.wms.terminal.server.Driver;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DriverDao {
    Driver insert(@Param("driver")Driver driver);
}
