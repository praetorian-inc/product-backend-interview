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
public class ProjectDto {

  @NonNull
  UUID id;

  String title;

  Set<UUID> users;
}
