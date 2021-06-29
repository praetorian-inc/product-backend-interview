package praetorian.vulnviewer.vulnViewer.resources;


import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import praetorian.vulnviewer.vulnViewer.dto.UserDto;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserResource {

  @GetMapping("/{userId}")
  public UserDto getUser(@PathVariable @NonNull UUID userId) {
    return null;
  }

  @GetMapping("/project/{projectId}")
  public Set<UserDto> getUsersForProject(@PathVariable @NonNull UUID projectId) {
    return null;
  }
}
