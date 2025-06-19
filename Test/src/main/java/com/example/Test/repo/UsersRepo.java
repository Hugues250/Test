package com.example.Test.repo;

import com.example.Test.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepo extends JpaRepository<Users, UUID> {

    Optional<Users> findByNameAndEmail(String name, String email);
}
