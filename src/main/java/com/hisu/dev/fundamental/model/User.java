package com.hisu.dev.fundamental.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class User {
    private String id;
    private String name;
    private int age;
}
