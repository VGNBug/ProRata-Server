package com.pawsey.prorata.api.repository;

import com.pawsey.api.repository.BaseRepository;
import com.pawsey.prorata.model.ProrataUserEntity;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * Repository : ProrataUser.
 */
public interface ProrataUserRepository extends BaseRepository<ProrataUserEntity, Integer> {
    @Query("SELECT p FROM ProrataUserEntity p WHERE p.email = ?1")
    ProrataUserEntity findByEmail(String email);
}
