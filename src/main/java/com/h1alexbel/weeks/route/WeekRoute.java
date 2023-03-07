package com.h1alexbel.weeks.route;

import com.h1alexbel.weeks.model.Weeks;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class WeekRoute {

  private final Weeks weeks;

  @Bean
  public RouterFunction<ServerResponse> week() {
    return RouterFunctions.route()
      .GET("/weeks/{id}", request ->
        ServerResponse.ok()
          .body(this.weeks.mono(
              Long.valueOf(request.pathVariable("id"))
            ).flatMap(
              week ->
                Mono.just(
                  new VwWeek(
                    week.title(),
                    week.mail(),
                    week.username()
                  )
                )
            ),
            VwWeek.class
          )
      ).build();
  }

  @Bean
  public RouterFunction<ServerResponse> all() {
    return RouterFunctions.route()
      .GET("/weeks/user/@{username}", request ->
        ServerResponse.ok()
          .body(
            this.weeks.flux(
                request.pathVariable("username")
              )
              .flatMap(
                week -> Mono.just(
                  new VwWeek(
                    week.title(),
                    week.mail(),
                    week.username()
                  )
                )
              ),
            VwWeek.class
          )
      ).build();
  }
}