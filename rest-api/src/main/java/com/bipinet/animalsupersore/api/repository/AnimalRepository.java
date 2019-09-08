package com.bipinet.animalsupersore.api.repository;

import com.bipinet.animalsupersore.api.model.Animal;
import com.bipinet.animalsuperstore.model.AnimalDto.SourceEnum;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

  Optional<Animal> findAnimalByThirdPartyIdAndSource(String thirdPartyId, SourceEnum source);

}
