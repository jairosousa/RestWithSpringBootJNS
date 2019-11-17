package br.com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.restapi.data.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from user u where u.userName = :userName")
	User findByUsername(@Param("userName") String userName);

}
