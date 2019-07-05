package com.gmail.vadimv41.dto;

import lombok.*;
import com.gmail.vadimv41.entity.Role;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
//    private List<Role> roles;

}
