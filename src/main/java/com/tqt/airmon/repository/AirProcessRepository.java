package com.tqt.airmon.repository;

import com.tqt.airmon.model.AirProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirProcessRepository extends JpaRepository<AirProcess,Long> {
    List<AirProcess> findAllByAirProjectId(Long id);
}
