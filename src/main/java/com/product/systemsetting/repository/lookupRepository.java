package com.product.systemsetting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.systemsetting.model.Lookup;;

@Repository
public interface lookupRepository extends JpaRepository<Lookup, Long> {

	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP where ISACTIVE='Y'", nativeQuery = true)
	public List<Lookup> findActive();

	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP "
			+ "where CODE like ?1 or DESCRIPTION like ?1 and ENTITY_STATUS like ?1 and ISACTIVE='Y'", nativeQuery = true)
	public List<Lookup> findBySearch(String search);

	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP "
			+ "where CODE like ?1 or DESCRIPTION like ?1 and ENTITY_STATUS like ?1 ", nativeQuery = true)
	public List<Lookup> findAllBySearch(String search);

	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP " 
			+ "where ID LIKE CASE WHEN ?1 = 0 THEN ID ELSE ?1 END "
			+ "and ISACTIVE='Y'", nativeQuery = true)
	List<Lookup> findByAdvancedSearch(Long id);

	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP " 
			+ "where ID LIKE CASE WHEN ?1 = 0 THEN ID ELSE ?1 END ", nativeQuery = true)
	List<Lookup> findAllByAdvancedSearch(Long id);

	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP where ENTITYNAME=?1 and ISACTIVE='Y'", nativeQuery = true)
	public List<Lookup> findActiveByEntityName(String data);

	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP where ENTITYNAME=?1", nativeQuery = true)
	public List<Lookup> findAllByEntityName(String data);

	@Query(value = "select distinct ENTITYNAME from TBLSYSTEMSETTINGLOOKUP where ENTITYNAME not in ('EMAILSETTING') order by ENTITYNAME", nativeQuery = true)
	public List<Object> findEntityList();

	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP where ENTITYNAME='EMAILSETTING'", nativeQuery = true)
	public Lookup getEmailSettings();
	
	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP where ENTITYNAME='SMSSETTING'", nativeQuery = true)
	public Lookup getSmsSettings();

	@Query(value = "select top 1 * from TBLSYSTEMSETTINGLOOKUP where DESCRIPTION=?1 and ENTITY_STATUS='S'", nativeQuery = true)
	public Lookup getEntityDescription(String des);

	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP where ID=?1", nativeQuery = true)
	public Lookup getQualificationLooKupId(Long id);
	
	@Query(value = "select * from TBLSYSTEMSETTINGLOOKUP where DESCRIPTION=?1", nativeQuery = true)
	public Lookup getDescriptionID(String des);

}
