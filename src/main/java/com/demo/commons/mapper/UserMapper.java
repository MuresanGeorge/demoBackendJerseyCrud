package com.demo.commons.mapper;

import com.demo.commons.dto.UserDTO;
import com.demo.model.User;

public class UserMapper {

    public User userDTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setAddress(userDTO.getAddress());
        user.setNationality(userDTO.getNationality());
        return user;
    }

    public UserDTO userToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setAddress(user.getAddress());
        userDTO.setNationality(user.getNationality());
        return userDTO;
    }
}
