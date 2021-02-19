package com.github.andreygfranca.customermanager.adapter.api.v1.model.customer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.github.andreygfranca.customermanager.adapter.api.v1.model.city.CityResponseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
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
@ApiModel("Customer")
public class CustomerResponseDTO {
  
  @ApiModelProperty(example = "1")
  private Long id;
  
  @ApiModelProperty(example = "Galvão Bueno")
  @NotBlank
  private String name;
  
  @ApiModelProperty(example = "FEMALE")
  private String gender;
  
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @ApiModelProperty(example = "1997-02-05")
  private LocalDate birthDate;
  
  @ApiModelProperty(example = "23")
  private Integer age;
  
  private CityResponseDTO city;
  
}
