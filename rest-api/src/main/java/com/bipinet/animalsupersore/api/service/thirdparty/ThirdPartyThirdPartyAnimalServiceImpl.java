package com.bipinet.animalsupersore.api.service.thirdparty;

import com.bipinet.animalsupersore.api.mapper.MapStrucyDtoMapper;
import com.bipinet.animalsuperstore.model.AnimalDto;
import io.swagger.petstore.api.PetApi;
import java.util.Arrays;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyThirdPartyAnimalServiceImpl implements ThirdPartyAnimalService {

  private final PetApi petApi;
  private final ModelMapper petToAnimalDtoMapper;

  public ThirdPartyThirdPartyAnimalServiceImpl(PetApi petApi, ModelMapper petToAnimalDtoMapper) {
    this.petApi = petApi;
    this.petToAnimalDtoMapper = petToAnimalDtoMapper;
  }

  @Override
  public List<AnimalDto> findThirdPartyAnimalByStatus(String status) {
    final List<AnimalDto> animalDtos =
        MapStrucyDtoMapper.INSTANCE
            .petsToAnimalDtos(petApi.findPetsByStatus(Arrays.asList(status)));
    animalDtos.stream().forEach(animalDto -> {
          animalDto.setSource(AnimalDto.SourceEnum.SWAGGER_PETSTORE);
          animalDto.setInternalStatus(AnimalDto.InternalStatusEnum.IMPORTING);
        }
    );
    return animalDtos;
  }

  @Override
  public AnimalDto getThirdPartyAnimalById(Long animalId) {
    final AnimalDto animalDto = petToAnimalDtoMapper
        .map(petApi.getPetById(animalId), AnimalDto.class);
    animalDto.setSource(AnimalDto.SourceEnum.SWAGGER_PETSTORE);
    animalDto.setInternalStatus(AnimalDto.InternalStatusEnum.IMPORTING);
    return animalDto;
  }
}
