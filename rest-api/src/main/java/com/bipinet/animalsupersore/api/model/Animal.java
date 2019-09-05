package com.bipinet.animalsupersore.api.model;

import com.bipinet.animalsuperstore.model.AnimalDto;
import com.bipinet.animalsuperstore.model.AnimalDto.ExternalStatusEnum;
import com.bipinet.animalsuperstore.model.AnimalDto.InternalStatusEnum;
import com.bipinet.animalsuperstore.model.AnimalDto.SourceEnum;
import java.util.List;
import java.util.Objects;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
//@ToString
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"thirdPartyId", "source"})
)
@Entity
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long thirdPartyId;
  private String name;
  @ElementCollection(targetClass = String.class)
  private List<String> photoUrls;
  private AnimalDto.SourceEnum source;
  private AnimalDto.ExternalStatusEnum externalStatus;
  private AnimalDto.InternalStatusEnum internalStatus;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getThirdPartyId() {
    return thirdPartyId;
  }

  public void setThirdPartyId(Long thirdPartyId) {
    this.thirdPartyId = thirdPartyId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
  }

  public SourceEnum getSource() {
    return source;
  }

  public void setSource(SourceEnum source) {
    this.source = source;
  }

  public ExternalStatusEnum getExternalStatus() {
    return externalStatus;
  }

  public void setExternalStatus(
      ExternalStatusEnum externalStatus) {
    this.externalStatus = externalStatus;
  }

  public InternalStatusEnum getInternalStatus() {
    return internalStatus;
  }

  public void setInternalStatus(
      InternalStatusEnum internalStatus) {
    this.internalStatus = internalStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Animal animal = (Animal) o;
    return Objects.equals(id, animal.id) &&
        Objects.equals(thirdPartyId, animal.thirdPartyId) &&
        Objects.equals(name, animal.name) &&
        Objects.equals(photoUrls, animal.photoUrls) &&
        source == animal.source &&
        externalStatus == animal.externalStatus &&
        internalStatus == animal.internalStatus;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, thirdPartyId, name, photoUrls, source, externalStatus, internalStatus);
  }

  @Override
  public String toString() {
    return "Animal{" +
        "id=" + id +
        ", thirdPartyId=" + thirdPartyId +
        ", name='" + name + '\'' +
        ", photoUrls=" + photoUrls +
        ", source=" + source +
        ", externalStatus=" + externalStatus +
        ", internalStatus=" + internalStatus +
        '}';
  }
}
