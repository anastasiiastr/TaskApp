package ru.stmlabs.taskapp.task.repository;

import ru.stmlabs.taskapp.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTag(String tag);

    List<Task> findAllByAuthorName(String authorName);

    List<Task> findAllByTag(String tag);
}
