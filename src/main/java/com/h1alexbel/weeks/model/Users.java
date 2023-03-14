package com.h1alexbel.weeks.model;

import com.h1alexbel.weeks.postgres.PgUser;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Users {

  Mono<? extends PgUser> mono(Long id);
}