package com.pharmerz.iphex.api.server.domain.repository;

import com.pharmerz.iphex.api.server.domain.model.Exhibitor;
import com.pharmerz.iphex.api.server.domain.model.Exhibitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by i5 on 4/15/2017.
 */
@Repository
@RepositoryRestResource
public interface IExhibitorRepository extends JpaRepository<Exhibitor, UUID>{

  Page<Exhibitor> findByCompanyIgnoreCase(@Param("productId") String productId, Pageable pageable);
}
