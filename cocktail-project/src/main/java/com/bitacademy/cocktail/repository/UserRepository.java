package com.bitacademy.cocktail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitacademy.cocktail.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
