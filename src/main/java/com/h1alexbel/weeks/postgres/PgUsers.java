package com.h1alexbel.weeks.postgres;

import com.h1alexbel.weeks.model.User;
import com.h1alexbel.weeks.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Component
@RequiredArgsConstructor
public class PgUsers implements Users {

  private final DatabaseClient db;

  @Override
  public Mono<User> mono(final Long id) {
    return this.db.sql("SELECT id, name FROM login WHERE id=:id")
      .bind("id", id)
      .fetch()
      .one()
      .map(rows ->
        new PgUser(
          (Long) rows.get("id"),
          (String) rows.get("name")
        )
      );
  }

  @Override
  public Flux<User> flux() {
    return null;
  }
}