package com.github.andreygfranca.customermanager.adapter.api.v1.model.customer;

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
@ApiModel("CustomerUpdate")
public class CustomerUpdateDTO {
  
  @ApiModelProperty(example = "Galvão Bueno")
  @NotBlank
  private String name;
  
}
