package com.h1alexbel.weeks.cache;

import com.h1alexbel.weeks.model.Users;
import com.h1alexbel.weeks.postgres.PgUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ReactiveHashOperations;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author Aliaksei Bialiauski (abialaiuski.dev@gmail.com)
 * @since 0.0.0
 */
@Component
public class CdUsers implements Users {

  private final Users users;
  private final ReactiveHashOperations<String, Integer, PgUser> cache;

  public CdUsers(@Qualifier("pgUsers") final Users users,
                 final ReactiveRedisOperations<String, PgUser> operations) {
    this.users = users;
    this.cache = operations.opsForHash();
  }

  @Override
  public Mono<PgUser> mono(final Long id) {
    this.cache.put(
      "users",
      1,
      new PgUser(
        1L, "fake"
      )
    ).subscribeOn(Schedulers.boundedElastic());
    return this.cache.get(
        "users",
        1
      )
      .switchIfEmpty(
        this.users.mono(id)
      );
  }
}