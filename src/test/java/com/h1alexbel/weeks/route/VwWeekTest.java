package com.h1alexbel.weeks.route;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class VwWeekTest {

  @Test
  void testTitle() {
    final String title = "test";
    final VwWeek view = new VwWeek(title, "", "");
    assertThat(view.getTitle())
      .isEqualTo(title);
  }
}