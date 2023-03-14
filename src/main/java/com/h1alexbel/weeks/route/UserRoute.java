package com.h1alexbel.weeks.route;

import com.h1alexbel.weeks.model.Users;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Configuration
public class UserRoute {

  private final Users users;

  public UserRoute(@Qualifier("cdUsers") final Users users) {
    this.users = users;
  }

  @Bean
  public RouterFunction<ServerResponse> user() {
    return RouterFunctions.route()
      .GET("/users/{id}", request ->
        ServerResponse.ok()
          .body(
            this.users.mono(
              Long.valueOf(
                request.pathVariable("id")
              )
            ).flatMap(user ->
              Mono.just(
                new VwUser(
                  user.id(),
                  user.name()
                )
              )
            ),
            VwUser.class
          )
      ).build();
  }
}