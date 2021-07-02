package com.solo.ujianjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.solo.ujianjpa.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(value = "Select * FROM user WHERE user_company_id = ?1", nativeQuery = true)
	List<User> findUserByCompanyId(int user_company_id);
	
	@Query(value = "Select * FROM user WHERE user_name Like %?1%", nativeQuery = true)
	List<User> findUserByNames(String user_name);
}
