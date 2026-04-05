package com.financeapp.financeapp.REPOSITOR;

import com.financeapp.financeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
