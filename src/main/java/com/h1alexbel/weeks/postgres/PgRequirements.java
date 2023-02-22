package com.h1alexbel.weeks.postgres;

import com.h1alexbel.weeks.model.Requirement;
import com.h1alexbel.weeks.model.Requirements;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
/**
 * @todo #10:45m/DEV Items implementation
 */
public class PgRequirements implements Requirements {

  @Override
  public Mono<Requirement> mono(Long id) {
    throw new UnsupportedOperationException("#mono()");
  }

  @Override
  public Flux<Requirement> flux(Long week) {
    throw new UnsupportedOperationException("#flux()");
  }
}