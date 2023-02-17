package com.h1alexbel.weeks.route;

import com.h1alexbel.weeks.model.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class UserCtrl {

  private final Users users;

  @GetMapping
  public Mono<VwUser> mono() {
    return this.users.mono(1L)
      .flatMap(
        user -> {
          log.debug("username is {}", user.name());
          return Mono.just(
            new VwUser(
              user.id(),
              user.name()
            )
          );
        }
      );
  }
}