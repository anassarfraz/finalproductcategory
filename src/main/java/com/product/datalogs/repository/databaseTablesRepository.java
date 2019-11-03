package com.product.datalogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.datalogs.model.DatabaseTables;

public interface databaseTablesRepository extends JpaRepository<DatabaseTables,Long>{

}
