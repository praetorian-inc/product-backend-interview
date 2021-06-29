package praetorian.vulnviewer.dto;

import lombok.AccessLevel;
import lombok.Value;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Value
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProjectDto {
  UUID id;

  String title;
}
