package praetorian.vulnviewer.vulnViewer.resources;

import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import praetorian.vulnviewer.vulnViewer.dao.ProjectDao;
import praetorian.vulnviewer.vulnViewer.dto.ProjectDto;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectResource {

  @NonNull ProjectDao projectDao;

  @GetMapping("/{projectId}")
  public ProjectDto getProject(@PathVariable @NonNull UUID projectId) {
    return projectDao.getProject(projectId);
  }

  @GetMapping("/user/{userId}")
  public Set<ProjectDto> getProjectsForUser(@PathVariable @NonNull UUID userId) {
    return projectDao.getProjectsForUser(userId);
  }

  @PutMapping("")
  public ProjectDto upsertProject(@RequestBody @NonNull ProjectDto projectDto) {
    return projectDao.upsertProject(projectDto);
  }

  @PostMapping("{projectId}/user/{userId}/")
  public ProjectDto addUserToProject(@PathVariable @NonNull final UUID projectId,
                                     @PathVariable @NonNull final UUID userId) {
    return projectDao.addUserToProject(projectId, userId);
  }
}
