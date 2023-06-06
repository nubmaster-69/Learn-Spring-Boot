package com.hisu.dev.fundamental.repository;

import com.hisu.dev.fundamental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
