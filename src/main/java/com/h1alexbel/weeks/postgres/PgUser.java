package com.h1alexbel.weeks.postgres;

import com.h1alexbel.weeks.model.User;
import lombok.AllArgsConstructor;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@AllArgsConstructor
public final class PgUser implements User {

  private final Long id;
  private final String login;

  @Override
  public Long id() {
    return this.id;
  }

  @Override
  public String name() {
    return this.login;
  }
}