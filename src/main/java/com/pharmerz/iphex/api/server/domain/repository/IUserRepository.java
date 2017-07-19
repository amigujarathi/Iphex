package com.pharmerz.iphex.api.server.domain.repository;

import com.pharmerz.iphex.api.server.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Created by ankur on 13-08-2016.
 */
@Repository
@RepositoryRestResource
public interface IUserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(@Param("email") String email);
}
