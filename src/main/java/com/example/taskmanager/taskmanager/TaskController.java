package com.example.taskmanager.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Redirect root ("/") to "/tasks"
    @GetMapping("/")
    public String redirectToTasks() {
        return "redirect:/tasks";
    }

    // Display all tasks
    @GetMapping
    public String getAllTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "index";
    }

    // Create a new task
    @PostMapping
    public String createTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/tasks";
    }

    // Delete a task by ID
    @PostMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }

    // Render the task edit form
    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable Long id, Model model) {
        Task task = taskService.getTaskById(id).orElse(null);
        if (task == null) {
            return "redirect:/tasks"; // Redirect if the task doesn't exist
        }
        model.addAttribute("task", task);
        return "edit";
    }

    // Update a task
//    @PostMapping("/edit/{id}")
//    public String updateTask(@PathVariable Long id, @ModelAttribute Task updatedTask) {
//        Task existingTask = taskService.getTaskById(id).orElse(null);
//        if (existingTask == null) {
//            return "redirect:/tasks"; // Redirect if the task doesn't exist
//        }
//
//        // Update only editable fields
//        existingTask.setTitle(updatedTask.getTitle());
//        existingTask.setDescription(updatedTask.getDescription());
//        existingTask.setCompleted(updatedTask.isCompleted());
//
//        // Save the updated task
//        taskService.updateTask(id, existingTask);
//        return "redirect:/tasks";
//    }

    @PostMapping("/edit/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task updatedTask) {
        taskService.updateTask(id, updatedTask);
        return "redirect:/tasks";
    }
}
