package com.semo.kvokka.controller;

import com.semo.kvokka.entity.Project;
import com.semo.kvokka.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ProjectController {

    private final ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @PostMapping("/projects")
    public Project create(@RequestBody Project project) {
        project.setId(null);
        return projectRepository.save(project);
    }

    @GetMapping("/projects/{id}")
    public Optional<Project> getById(@PathVariable Long id) {
        return projectRepository.findById(id);
    }

    @PutMapping("/projects/{id}")
    public Project update(@PathVariable Long id,
                          @RequestBody Project newProject) {
        var project = projectRepository.findById(id).orElseThrow();
        return projectRepository.save(project);
    }

    @DeleteMapping("/projects/{id}")
    public void delete(@PathVariable Long id) {
        projectRepository.deleteById(id);
    }

}
