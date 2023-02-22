package com.h1alexbel.weeks.route;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Aliaksei Bialiauski (abialiauski@solvd.com)
 * @since 1.0
 */
@Data
@RequiredArgsConstructor
public class VwWeek {

  private final String title;
  private final String to;
  private final String username;
}