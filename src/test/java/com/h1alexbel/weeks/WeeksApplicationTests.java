package com.h1alexbel.weeks;

import com.h1alexbel.weeks.route.VwWeek;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WeeksApplicationTests {

  @Test
  void contextLoads() {
    final String title = "test";
    final VwWeek view = new VwWeek(title, "", "");
    Assertions.assertThat(view.getTitle()).isEqualTo(title);
  }
}
