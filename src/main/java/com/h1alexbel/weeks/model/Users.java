package com.h1alexbel.weeks.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
public interface Users {

  Mono<User> mono(Long id);

  Flux<User> flux();
}