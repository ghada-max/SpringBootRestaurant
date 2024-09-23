package com.zoch.recipe_sharing.repository;
import org.springframework.data.repository.CrudRepository;

import com.zoch.recipe_sharing.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
public interface userRepository extends JpaRepository<user,Long> {
 public user findByEmail(String email);

}
