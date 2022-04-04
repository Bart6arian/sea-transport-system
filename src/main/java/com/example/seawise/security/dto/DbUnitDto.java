package com.example.seawise.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DbUnitDto {

    private String unitHash;
    private ChainDto chainDto;
}
