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
    //Convert Id to String
    typeMap.addMappings(mapper -> mapper.using(ctx -> ((Long) ctx.getSource()).toString()).map(Pet::getId, AnimalDto::setId));
    //Map Pet Store status to internal Dto external status
    typeMap.addMappings(mapper -> mapper.map(Pet::getStatus, AnimalDto::setExternalStatus));
    return modelMapper;
  }

}
