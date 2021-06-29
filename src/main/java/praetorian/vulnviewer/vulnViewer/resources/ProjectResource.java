package praetorian.vulnviewer.vulnViewer.resources;

import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import praetorian.vulnviewer.vulnViewer.dto.ProjectDto;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectResource {

  @GetMapping("/{projectId}")
  public ProjectDto getProject(@PathVariable @NonNull UUID projectId) {
    return null;
  }

  @GetMapping("/user/{userId}")
  public Set<ProjectDto> getProjectsForUser(@PathVariable @NonNull UUID userId) {
    return null;
  }
}
