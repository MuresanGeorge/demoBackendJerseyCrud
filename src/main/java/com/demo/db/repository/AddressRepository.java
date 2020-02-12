package com.demo.db.repository;

import com.demo.model.Address;

import java.util.List;

public interface AddressRepository {
    void createAddress(Address address);
    Address getAddressById(int id);
    List<Address> getAllAddresses();
}
