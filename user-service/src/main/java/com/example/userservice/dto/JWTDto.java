package com.example.userservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JWTDto {
    @ApiModelProperty(example = "eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOj22MzA0NDAxMjcsImV4cCI6MTYzMjAzMjEyNywic3ViIjoidGVzdDFAbmF2ZXIuY29tIn0.R-BAIAPMpSdcspxXrnnck6AM8LvNBeIxC5Y4TyG_rKc")
    private String token;
}
