package com.example.seawise.security.blockchain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Chain {

    private Long id;
    private List<Block> blockList;

}
