package com.product.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.product.model.ProductCategory;

public interface productCategoryRepository extends JpaRepository <ProductCategory,Long> {
	@Query(value = "select * from TBLPRODUCTCATEGORY where ISACTIVE='Y' " , nativeQuery = true)
	List<ProductCategory> findActive();


	
}





	
