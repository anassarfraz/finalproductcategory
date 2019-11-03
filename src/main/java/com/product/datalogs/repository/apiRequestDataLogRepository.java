package com.product.datalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.datalogs.model.APIRequestDataLog;

public interface apiRequestDataLogRepository extends JpaRepository<APIRequestDataLog,Long>{

}
