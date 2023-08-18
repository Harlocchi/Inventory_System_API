package com.example.Stock2.VOs;

import lombok.Data;

import java.util.HashMap;

@Data
public class SalePostVO {
    private Long valueLong;
    private HashMap<String, String> hashmap;
}
