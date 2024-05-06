package com.starbucks.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private char[] password;

}
