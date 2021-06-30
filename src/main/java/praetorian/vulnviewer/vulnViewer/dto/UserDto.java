package praetorian.vulnviewer.vulnViewer.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.Set;
import java.util.UUID;

@Builder(toBuilder = true)
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Value
public class UserDto {

  @NonNull
  UUID id;

  @NonNull
  Set<UUID> projectIds;

  String email;

  String firstName;

  String lastName;

  Set<String> roles; // User roles, e.g. VULNERABILITY_EDITOR, VULNERABILITY_VIEWER, PROJECT_EDITOR

}
