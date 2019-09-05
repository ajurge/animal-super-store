package com.bipinet.animalsupersore.api.service.thirdparty;

import com.bipinet.animalsuperstore.model.AnimalDto;
import java.util.List;

public interface ThirdPartyAnimalService {

  List<AnimalDto> findThirdPartyAnimalByStatus(String status);

  AnimalDto getThirdPartyAnimalById(Long animalId);
}
