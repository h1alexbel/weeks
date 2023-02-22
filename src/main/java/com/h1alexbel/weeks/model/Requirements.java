package com.h1alexbel.weeks.model;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */

/**
 * @todo #10:25m/DEV Items
 */
public interface Requirements {

  Mono<Requirement> mono(Long id);

  Flux<Requirement> flux(Long week);
}