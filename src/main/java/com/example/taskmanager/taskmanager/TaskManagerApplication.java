package com.example.taskmanager.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@ComponentScan("com.example.taskmanager.taskmanager")
@EnableJpaRepositories("com.example.taskmanager.taskmanager")
@SpringBootApplication(scanBasePackages="com.example.taskmanager.taskmanager")
public class TaskManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }
}
