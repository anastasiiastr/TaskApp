package ru.stmlabs.taskapp.user.repository;

import ru.stmlabs.taskapp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsUserByName(String username);

    Optional<User> findByNameAndPassword(String name, String password);

    Optional<User> findByName(String name);
}
