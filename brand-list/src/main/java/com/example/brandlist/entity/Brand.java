package com.example.brandlist.entity;
//品牌实体类

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    private Integer id;
    private String companyName;
    private String brandName;
    private Integer ordered;
    private String description;
}
