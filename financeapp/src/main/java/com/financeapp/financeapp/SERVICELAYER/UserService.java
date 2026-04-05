package com.financeapp.financeapp.SERVICELAYER;

import com.financeapp.financeapp.REPOSITOR.UserRepository;
import com.financeapp.financeapp.Status;
import com.financeapp.financeapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User create(User user) {
//        user.setStatus(Status.ACTIVE);
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User updateStatus(Long id, Status status) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

//        user.setStatus(status);
        return repo.save(user);
    }
}
