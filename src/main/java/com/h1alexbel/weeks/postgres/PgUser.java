package com.h1alexbel.weeks.postgres;

import com.h1alexbel.weeks.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public final class PgUser implements User {

  private Long id;
  private String login;

  @Override
  public Long id() {
    return this.id;
  }

  @Override
  public String name() {
    return this.login;
  }
}