package com.h1alexbel.weeks.postgres;

import com.h1alexbel.weeks.model.Week;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@RequiredArgsConstructor
public final class PgWeek implements Week {

  private final Long id;
  private final String title;
  private final String mail;
  private final String username;

  @Override
  public Long id() {
    return this.id;
  }

  @Override
  public String title() {
    return this.title;
  }

  @Override
  public String mail() {
    return this.mail;
  }

  @Override
  public String username() {
    return this.username;
  }
}