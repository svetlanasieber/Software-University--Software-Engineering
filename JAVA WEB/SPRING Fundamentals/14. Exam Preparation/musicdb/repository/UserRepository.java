package com.example.musicdb.repository;

import com.example.musicdb.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
     UserEntity findByUsernameAndPassword(String username, String password);
}
