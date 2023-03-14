package com.h1alexbel.weeks.cache;

import com.h1alexbel.weeks.postgres.PgUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Aliaksei Bialiauski ()
 * @since 0.0.0
 */
@Configuration
public class RedisConfiguration {

  @Bean
  public ReactiveRedisOperations<String, PgUser> template(
    LettuceConnectionFactory connections) {
    final RedisSerializationContext<String, PgUser> serializationContext = RedisSerializationContext
      .<String, PgUser>newSerializationContext(new StringRedisSerializer())
      .key(new StringRedisSerializer())
      .value(new GenericToStringSerializer<>(PgUser.class))
      .hashKey(new Jackson2JsonRedisSerializer<>(Integer.class))
      .hashValue(new GenericJackson2JsonRedisSerializer())
      .build();
    return new ReactiveRedisTemplate<>(connections, serializationContext);
  }
}