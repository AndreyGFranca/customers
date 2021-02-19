package com.github.andreygfranca.customermanager.infrastructure.exceptionhandler;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Problem {
  
  private Integer status;
  private String title;
  private String detail;
  private OffsetDateTime timestamp;
  
}
