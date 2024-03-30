package com.example.taskClearEyes.controller;

import com.example.taskClearEyes.model.Task;
import com.example.taskClearEyes.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String getMainPage(Model model){
        model.addAttribute("task", taskService.getMainPage());
        return "index";
    }

    @PostMapping("/calculation")
    public String getTask(@ModelAttribute Task task,
                          Model model)
    {
        model.addAttribute("task", taskService.getTask(task));
        return "index";
    }
}
