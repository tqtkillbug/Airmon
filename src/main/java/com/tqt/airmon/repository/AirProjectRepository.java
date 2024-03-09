package com.tqt.airmon.repository;

import com.tqt.airmon.model.AirProject;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirProjectRepository extends JpaRepository<AirProject,Long> {

    boolean existsByLinkSource(String sourceLink);
}
