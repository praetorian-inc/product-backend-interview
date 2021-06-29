package praetorian.vulnviewer.vulnViewer.dto;

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Value
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserDto {

  UUID id;

  UUID projectId;

  String email;

  String firstName;

  String lastName;

}
