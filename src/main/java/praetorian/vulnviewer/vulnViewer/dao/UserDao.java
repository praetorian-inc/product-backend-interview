package praetorian.vulnviewer.vulnViewer.dao;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import praetorian.vulnviewer.vulnViewer.dao.sql.SQLService;
import praetorian.vulnviewer.vulnViewer.dto.UserDto;

import java.util.Set;
import java.util.UUID;

import static java.util.stream.Collectors.toSet;
import static lombok.AccessLevel.PRIVATE;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class UserDao {

  @NonNull
  SQLService<UserDto> sqlService;

  public UserDto getUserById(@NonNull final UUID userId) {
    return sqlService.findOne("SELECT * FROM Users WHERE id = " + userId.toString());
  }

  public Set<UserDto> getUsersById(@NonNull final UUID projectId) {
    return sqlService.findAll("SELECT * FROM Users WHERE projectId = " + projectId.toString()).map(entity -> (UserDto) entity).collect(toSet());
  }
}
