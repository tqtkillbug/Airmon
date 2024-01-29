package com.tqt.airmon.repository;

import com.tqt.airmon.model.AirProcess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirProcessRepository extends JpaRepository<AirProcess,Long> {
}
