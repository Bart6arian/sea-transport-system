package com.example.seawise.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ChainDto {

    private List<BlockDto> blockDtos;
}
