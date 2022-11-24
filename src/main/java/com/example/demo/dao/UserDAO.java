package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    @Modifying
    @Query("UPDATE User SET name = :name, lastName = :lastName, age = :age where id = :id")
    void updateUserById(@Param("name") String name,
                                @Param("lastName") String lastName,
                                @Param("age") Byte age,
                                @Param("id") Long id);
}
