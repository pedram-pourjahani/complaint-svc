package org.taba.msaapp.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.taba.msaapp.models.entity.ProfileEntity;
import reactor.core.publisher.Mono;

@Repository
public interface ProfileRepository extends ReactiveCrudRepository<ProfileEntity, Long> {
    Mono<ProfileEntity> findByNationalcode(String nationalCode);
}
