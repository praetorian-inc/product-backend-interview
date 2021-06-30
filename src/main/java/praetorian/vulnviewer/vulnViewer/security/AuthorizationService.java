package praetorian.vulnviewer.vulnViewer.security;

import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import praetorian.vulnviewer.vulnViewer.dto.UserDto;

import static lombok.AccessLevel.PRIVATE;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
@FieldDefaults(makeFinal = true, level = PRIVATE)
public class AuthorizationService {

  public UserDto getCurrentUser() {
    return null; // STUB
  }

}
