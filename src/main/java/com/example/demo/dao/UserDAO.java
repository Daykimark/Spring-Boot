package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, Long> {
    @Modifying
    @Query("UPDATE User SET name = ?1, lastName = ?2, age = ?3 where id = ?4")
    void updateUserById( String name, String lastName, Byte age, Long id);
}
