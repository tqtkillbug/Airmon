package com.tqt.airmon.repository;

import com.tqt.airmon.model.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends JpaRepository<Source,Long> {

    Source findByLink(String link);
}
