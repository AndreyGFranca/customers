package com.github.andreygfranca.customermanager.adapter.api.v1.model.city;

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
public class CityCriteriaDTO {
  
  String name;
  
  String state;
  
}
