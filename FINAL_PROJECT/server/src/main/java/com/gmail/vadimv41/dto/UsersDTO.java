package com.gmail.vadimv41.dto;

import lombok.*;
import com.gmail.vadimv41.entity.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UsersDTO {
private List<User> users;
}
