package com.centralbank.company.application.ports.output.persistence.repository;

import com.centralbank.company.domain.model.user.User;

public interface UserRepository {
    User save(User user);
    void delete(User user);
    
}
