package com.pharmerz.iphex.api.server.domain.repository;

import com.pharmerz.iphex.api.server.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ankur on 13-08-2016.
 */
@Repository
@RepositoryRestResource
public interface IProductRepository extends JpaRepository<Product, UUID> {
    Page<Product> findByUserIdOrderByProductAsc(@Param("userId") UUID userId, Pageable pageable);
}
