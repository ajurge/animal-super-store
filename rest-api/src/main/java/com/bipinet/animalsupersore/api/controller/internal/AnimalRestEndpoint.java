package com.bipinet.animalsupersore.api.controller.internal;

import com.bipinet.animalsupersore.api.service.internal.AnimalService;
import com.bipinet.animalsuperstore.api.AnimalApi;
import com.bipinet.animalsuperstore.model.AddAnimalDto;
import com.bipinet.animalsuperstore.model.AnimalDto;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${rest.api.context-path}")
public class AnimalRestEndpoint implements AnimalApi {

  private final AnimalService animalService;

  public AnimalRestEndpoint(AnimalService animalService) {
    this.animalService = animalService;
  }

  @Override
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Void> addAnimal(@Valid AddAnimalDto addAnimalDto) {
    animalService.addAnimal(addAnimalDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<List<AnimalDto>> getAllAnimals() {
    return new ResponseEntity<>(animalService.getAllAnimals(), HttpStatus.OK);
  }
}
