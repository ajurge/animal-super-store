package com.bipinet.animalsupersore.api.service.internal;

import com.bipinet.animalsupersore.api.mapper.MapStrucyDtoMapper;
import com.bipinet.animalsupersore.api.model.Animal;
import com.bipinet.animalsupersore.api.repository.AnimalRepository;
import com.bipinet.animalsuperstore.model.AddAnimalDto;
import com.bipinet.animalsuperstore.model.AnimalDto;
import com.bipinet.animalsuperstore.model.AnimalDto.ExternalStatusEnum;
import com.bipinet.animalsuperstore.model.AnimalDto.InternalStatusEnum;
import com.bipinet.animalsuperstore.model.AnimalDto.SourceEnum;
import io.swagger.petstore.api.PetApi;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class InternalAnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;
  private final PetApi petApi;

  public InternalAnimalServiceImpl(AnimalRepository animalRepository, PetApi petApi) {
    this.animalRepository = animalRepository;
    this.petApi = petApi;
  }

  @Override
  public Animal addAnimal(AddAnimalDto addAnimalDto) {
    return animalRepository.findAnimalByThirdPartyIdAndSource(addAnimalDto.getId(),
        AnimalDto.SourceEnum.fromValue(addAnimalDto.getSource().name().toLowerCase()))
        .orElseGet((() -> animalRepository.save(createAnimal(addAnimalDto))));
  }

  @Override
  public List<AnimalDto> getAllAnimals() {
    return MapStrucyDtoMapper.INSTANCE.animalsToAnimalDtos(animalRepository.findAll());
  }

  private Animal createAnimal(AddAnimalDto addAnimalDto) {
    final var animalInThirdParty = petApi.getPetById(addAnimalDto.getId());
    final var animal = new Animal();
    animal.setThirdPartyId(addAnimalDto.getId());
    animal
        .setExternalStatus(ExternalStatusEnum.fromValue(animalInThirdParty.getStatus().getValue()));
    animal
        .setInternalStatus(InternalStatusEnum.fromValue(animalInThirdParty.getStatus().getValue()));
    animal.setSource(SourceEnum.SWAGGER_PETSTORE);
    animal.setName(animalInThirdParty.getName());
    animal.setPhotoUrls(animalInThirdParty.getPhotoUrls());
    return animal;
  }
}
