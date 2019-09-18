package com.bipinet.animalsupersore.api.mapper;

import com.bipinet.animalsupersore.api.model.Animal;
import com.bipinet.animalsuperstore.model.AnimalDto;
import io.swagger.petstore.model.Pet;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapStructCentralConfig.class)
public interface MapStructDtoMapper {

  MapStructDtoMapper INSTANCE = Mappers.getMapper(MapStructDtoMapper.class);


  /*Third-party*/
  @Mapping(target = "externalStatus", source = "status")
  AnimalDto petToAnimalDto(Pet pet);

  List<AnimalDto> petsToAnimalDtos(List<Pet> pets);

  /*Internal*/
  @Mapping(target = "id", source = "thirdPartyId")
  AnimalDto animalToAnimalDto(Animal animal);

  List<AnimalDto> animalsToAnimalDtos(List<Animal> animalDtos);
}
