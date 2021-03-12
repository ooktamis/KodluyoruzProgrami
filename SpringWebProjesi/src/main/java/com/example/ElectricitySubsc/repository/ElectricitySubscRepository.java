package com.example.ElectricitySubsc.repository;

import com.example.springweb.domObj.ElectricitySubscDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElectricitySubscRepository extends JpaRepository<ElectricitySubscDO,Long> {
    Optional<ElectricitySubscDO> findByName(String name);
}
