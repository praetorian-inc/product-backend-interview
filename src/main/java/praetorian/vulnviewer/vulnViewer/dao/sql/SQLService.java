package praetorian.vulnviewer.vulnViewer.dao.sql;

import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/*
* This is where the abstraction starts. We're not doing anything related to SQL in this interview, so we'll just define
* some helper methods here.
*
* */

@Component
public class SQLService<T> {

  public T findOne(@NonNull final String query) {
    return null;
  }

  public Stream<T> findAll(@NonNull final String query) {
    return Stream.empty();
  }

  public void upsert(@NonNull final T entity) {
    // Do nothing
  }
}
