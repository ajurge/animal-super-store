package com.bipinet.animalsupersore.api.service.internal;

import com.bipinet.animalsupersore.api.model.Animal;
import com.bipinet.animalsuperstore.model.AddAnimalDto;
import com.bipinet.animalsuperstore.model.AnimalDto;
import java.util.List;

public interface AnimalService {

  Animal addAnimal(AddAnimalDto addAnimalDto);

  List<AnimalDto> getAllAnimals();
}
