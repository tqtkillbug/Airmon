package com.tqt.airmon.repository;

import com.tqt.airmon.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findAllByProfileId(Long id);
}
