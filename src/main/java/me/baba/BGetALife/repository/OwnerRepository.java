package me.baba.BGetALife.repository;

import me.baba.BGetALife.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    @Override
    Optional<Owner> findById(Long aLong);
}
