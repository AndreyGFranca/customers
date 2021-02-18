package com.github.andreygfranca.customermanager.adapter.api.v1.model;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
  
  private Long id;
  
  @NotBlank
  private String name;
  
  @NotBlank
  private String state;
  
}
