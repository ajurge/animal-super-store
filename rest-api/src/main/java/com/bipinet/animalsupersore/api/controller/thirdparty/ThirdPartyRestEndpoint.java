package com.bipinet.animalsupersore.api.controller.thirdparty;

import com.bipinet.animalsupersore.api.service.thirdparty.ThirdPartyAnimalService;
import com.bipinet.animalsuperstore.api.ThirdPartyApi;
import com.bipinet.animalsuperstore.model.AnimalDto;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${rest.api.context-path}")
public class ThirdPartyRestEndpoint implements ThirdPartyApi {

  private final ThirdPartyAnimalService thirdPartyAnimalService;

  public ThirdPartyRestEndpoint(
      ThirdPartyAnimalService thirdPartyAnimalService) {
    this.thirdPartyAnimalService = thirdPartyAnimalService;
  }

  @Override
  public ResponseEntity<List<AnimalDto>> findThirdPartyAnimalByStatus(
      @NotNull @Valid String status) {
    return new ResponseEntity<>(thirdPartyAnimalService.findThirdPartyAnimalByStatus(status),
        HttpStatus.OK);
  }

  @Override
  public ResponseEntity<AnimalDto> getThirdPartyAnimalById(Long animalId) {
    return new ResponseEntity<>(thirdPartyAnimalService.getThirdPartyAnimalById(animalId),
        HttpStatus.OK);
  }
}
