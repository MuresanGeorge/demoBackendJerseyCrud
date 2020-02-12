package com.demo.services;

import com.demo.commons.dto.CreateUserDTO;
import com.demo.commons.dto.UserCountryDTO;
import com.demo.commons.mapper.UserMapper;
import com.demo.db.repository.AddressRepository;
import com.demo.db.repository.AddressRepositoryImpl;
import com.demo.db.repository.UserRepository;
import com.demo.db.repository.UserRepositoryImpl;
import com.demo.model.Address;
import com.demo.model.User;

import java.util.ArrayList;
import java.util.List;

public class DemoService {
    private UserRepository userRepository;
    private AddressRepository addressRepository;

    public DemoService() {
        userRepository = new UserRepositoryImpl();
        addressRepository = new AddressRepositoryImpl();
    }

    public UserCountryDTO createUser(CreateUserDTO createUserDTO) {
        User user = new User();
        Address address = new Address();
        UserCountryDTO userCountryDTO = new UserCountryDTO();
        String nationality = createUserDTO.getNationality();
        if (nationality.equals("roman")) {
            address.setCountry("ROMANIA");
            addressRepository.createAddress(address);
            user.setAddress(address);
            user.setNationality(createUserDTO.getNationality());
            user.setName(createUserDTO.getName());
            user.setSurname(createUserDTO.getSurname());
            userRepository.createUser(user);
            userCountryDTO.setCountry(user.getAddress().getCountry());
            userCountryDTO.setName(user.getName());
        } else {
            address.setCountry("UNGARIA");
            addressRepository.createAddress(address);
            user.setAddress(address);
            user.setNationality(createUserDTO.getNationality());
            user.setName(createUserDTO.getName());
            user.setSurname(createUserDTO.getSurname());
            userRepository.createUser(user);
            userCountryDTO.setCountry(user.getAddress().getCountry());
            userCountryDTO.setName(user.getName());
        }
        return userCountryDTO;
    }

    public List<UserCountryDTO> getAllUsers() {
        List<User> userList = userRepository.getAllUsers();
        List<UserCountryDTO> userCountryDTOArrayList = new ArrayList<>();
        for (User user : userList) {
            UserCountryDTO userCountryDTO = new UserCountryDTO();
            userCountryDTO.setName(user.getName());
            userCountryDTO.setCountry(user.getAddress().getCountry());
            userCountryDTOArrayList.add(userCountryDTO);
        }
        return userCountryDTOArrayList;
    }
}
