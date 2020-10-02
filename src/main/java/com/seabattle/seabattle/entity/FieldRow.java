package com.seabattle.seabattle.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldRow {

    private int id;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;


}
