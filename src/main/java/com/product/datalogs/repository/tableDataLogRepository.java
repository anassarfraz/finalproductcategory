package com.product.datalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.datalogs.model.TableDataLog;

public interface tableDataLogRepository extends JpaRepository<TableDataLog,Long>{

}
