package com.pharmerz.iphex.api.server.domain.repository;

import com.pharmerz.iphex.api.server.domain.model.Scan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by ankur on 16-03-2017.
 */
@Repository
public interface IScanRepository extends JpaRepository<Scan, UUID> {
    Page<Scan> findByUserId(@Param("userId") UUID userId, Pageable pageable);
    Page<Scan> findByOtherId(@Param("otherId") UUID otherId, Pageable pageable);
}
