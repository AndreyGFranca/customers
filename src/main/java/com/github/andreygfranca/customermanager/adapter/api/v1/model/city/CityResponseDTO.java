package com.github.andreygfranca.customermanager.adapter.api.v1.model.city;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("CityResponse")
public class CityResponseDTO {
  
  @ApiModelProperty(example = "1")
  private Long id;
  
  @ApiModelProperty(example = "Jatai")
  @NotBlank
  private String name;
  
  @ApiModelProperty(example = "Goias")
  @NotBlank
  private String state;
  
}
