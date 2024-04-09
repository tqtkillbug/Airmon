package com.tqt.airmon.repository;

import com.tqt.airmon.model.Remind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemindRepository extends JpaRepository<Remind,Long> {
    Remind findByAirProjectId(Long id);
}
