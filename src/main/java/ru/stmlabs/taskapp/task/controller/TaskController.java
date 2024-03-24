package ru.stmlabs.taskapp.task.controller;

import ru.stmlabs.taskapp.task.dto.TaskDtoFromRequest;
import ru.stmlabs.taskapp.task.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    @GetMapping("/greeting")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }

    @GetMapping("/main/{userName}/{userPassword}")
    public String main(@RequestParam(required = false, defaultValue = "") String tag,
                       @PathVariable("userName") @NotEmpty String userName,
                       @PathVariable("userPassword") @NotEmpty String userPassword,
                       Model model) {

        model.addAttribute("tasks", service.getAllByTag(tag, userName, userPassword));

        model.addAttribute("filter", tag);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestBody @Valid TaskDtoFromRequest task, Map<String, Object> model) {

        model.put("tasks", service.save(task));

        return "main";
    }

}
