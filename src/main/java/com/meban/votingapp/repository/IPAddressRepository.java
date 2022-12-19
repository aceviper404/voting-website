package com.meban.votingapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meban.votingapp.entity.IPAddress;

@Repository
public interface IPAddressRepository extends JpaRepository<IPAddress, Short> {
	Optional<IPAddress> findByAddress(String address);
}
