package com.bipinet.animalsupersore.api.mapper;

import com.bipinet.animalsuperstore.model.AnimalDto;
import io.swagger.petstore.model.Pet;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

  @Bean
  public ModelMapper petToAnimalDtoMapper() {
    final ModelMapper modelMapper = new ModelMapper();
    TypeMap<Pet, AnimalDto> typeMap = modelMapper.createTypeMap(Pet.class, AnimalDto.class);
    typeMap.addMappings(mapper -> mapper.map(Pet::getStatus, AnimalDto::setExternalStatus));
    return modelMapper;
  }

}
