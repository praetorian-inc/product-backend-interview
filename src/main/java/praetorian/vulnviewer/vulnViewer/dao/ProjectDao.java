package praetorian.vulnviewer.vulnViewer.dao;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import praetorian.vulnviewer.vulnViewer.dao.sql.SQLService;
import praetorian.vulnviewer.vulnViewer.dto.ProjectDto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class ProjectDao {

  @NonNull
  SQLService<ProjectDto> sqlService;

  public ProjectDto getProject(@NonNull final UUID projectId) {
    return sqlService.findOne("SELECT * FROM Projects WHERE id = " + projectId.toString());
  }

  public Set<ProjectDto> getProjectsForUser(@NonNull final UUID userId) {
    return sqlService.findAll("SELECT * FROM Projects WHERE CONTAINS(users, " + userId.toString() + ")")
      .collect(Collectors.toSet());
  }

  public ProjectDto upsertProject(@NonNull final ProjectDto projectDto) {
    sqlService.upsert(projectDto);

    return sqlService
      .findOne("UPDATE * FROM Projects WHERE id = " + projectDto.getId().toString());
  }

  public ProjectDto addUserToProject(@NonNull final UUID projectId,
                                     @NonNull final UUID userId) {
    final ProjectDto existingProject = sqlService
      .findOne("UPDATE * FROM Projects WHERE id = " + projectId.toString());

    final Set<UUID> users = new HashSet<UUID>(existingProject.getUsers());
    users.add(userId);

    final ProjectDto newProject = existingProject.toBuilder().users(users).build();

    sqlService.upsert(newProject);

    return sqlService
      .findOne("UPDATE * FROM Projects WHERE id = " + projectId.toString());
  }
}
