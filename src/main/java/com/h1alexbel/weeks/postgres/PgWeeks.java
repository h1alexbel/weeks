package com.h1alexbel.weeks.postgres;

import com.h1alexbel.weeks.model.Week;
import com.h1alexbel.weeks.model.Weeks;
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
public class PgWeeks implements Weeks {

  private final DatabaseClient db;

  @Override
  public Mono<Week> mono(final Long id) {
    String sql = """
      SELECT
      w.id AS id,
      w.title AS title,
      w.mail AS mail,
      l.name AS login
      FROM week w
      JOIN login l on l.id = w.login
      WHERE w.id = :id
      """;
    return this.db.sql(sql)
      .bind("id", id)
      .fetch()
      .one()
      .map(rows ->
        new PgWeek(
          (Long) rows.get("id"),
          (String) rows.get("title"),
          (String) rows.get("mail"),
          (String) rows.get("login")
        )
      );
  }

  @Override
  public Flux<Week> flux(final String login) {
    String sql = """
      SELECT
      w.id AS id,
      w.title AS title,
      w.mail AS mail,
      l.name AS login
      FROM week w
      JOIN login l on l.id = w.login
      WHERE l.name = :login    
      """;
    return this.db.sql(sql)
      .bind("login", login)
      .fetch()
      .all()
      .map(rows ->
        new PgWeek(
          (Long) rows.get("id"),
          (String) rows.get("title"),
          (String) rows.get("mail"),
          (String) rows.get("login")
        )
      );
  }
}