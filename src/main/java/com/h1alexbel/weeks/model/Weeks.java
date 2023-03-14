package com.h1alexbel.weeks.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Weeks {

  Mono<Void> create(Week week);

  Mono<Week> mono(Long id);

  Flux<Week> flux(String username);
}