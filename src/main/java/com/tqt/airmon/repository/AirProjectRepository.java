package com.tqt.airmon.repository;

import com.tqt.airmon.model.AirProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirProjectRepository extends JpaRepository<AirProject,Long> {
}
