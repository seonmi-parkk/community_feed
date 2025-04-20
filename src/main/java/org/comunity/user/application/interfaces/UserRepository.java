package org.comunity.user.application.interfaces;

import org.comunity.user.domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(User user);
    Optional<User> findById(Long id);
}
