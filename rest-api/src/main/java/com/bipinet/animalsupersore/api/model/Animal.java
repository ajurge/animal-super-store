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
  private String thirdPartyId;
  private String name;
  @ElementCollection(targetClass = String.class)
  private List<String> photoUrls;
  private AnimalDto.SourceEnum source;
  private AnimalDto.ExternalStatusEnum externalStatus;
  private AnimalDto.InternalStatusEnum internalStatus;

  public Animal() {
  }

  public Animal(String thirdPartyId, String name, List<String> photoUrls,
      SourceEnum source,
      ExternalStatusEnum externalStatus,
      InternalStatusEnum internalStatus) {
    this.thirdPartyId = thirdPartyId;
    this.name = name;
    this.photoUrls = photoUrls;
    this.source = source;
    this.externalStatus = externalStatus;
    this.internalStatus = internalStatus;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String thirdPartyId;
    private String name;
    private List<String> photoUrls;
    private SourceEnum source;
    private ExternalStatusEnum externalStatus;
    private InternalStatusEnum internalStatus;

    public Builder setThirdPartyId(final String thirdPartyId) {
      this.thirdPartyId = thirdPartyId;
      return this;
    }

    public Builder setName(final String name) {
      this.name = name;
      return this;
    }

    public Builder setPhotoUrls(final List<String> photoUrls) {
      this.photoUrls = photoUrls;
      return this;
    }

    public Builder setSource(final SourceEnum source) {
      this.source = source;
      return this;
    }

    public Builder setExternalStatus(final ExternalStatusEnum externalStatus) {
      this.externalStatus = externalStatus;
      return this;
    }

    public Builder setInternalStatus(final InternalStatusEnum internalStatus) {
      this.internalStatus = internalStatus;
      return this;
    }

    public Animal build() {
      return new Animal(this.thirdPartyId, this.name, this.photoUrls, this.source,
          this.externalStatus, this.internalStatus);
    }
  }

  public Long getId() {
    return id;
  }

  public String getThirdPartyId() {
    return thirdPartyId;
  }

  public String getName() {
    return name;
  }

  public List<String> getPhotoUrls() {
    return photoUrls;
  }

  public SourceEnum getSource() {
    return source;
  }

  public ExternalStatusEnum getExternalStatus() {
    return externalStatus;
  }

  public InternalStatusEnum getInternalStatus() {
    return internalStatus;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setThirdPartyId(String thirdPartyId) {
    this.thirdPartyId = thirdPartyId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
  }

  public void setSource(SourceEnum source) {
    this.source = source;
  }

  public void setExternalStatus(
      ExternalStatusEnum externalStatus) {
    this.externalStatus = externalStatus;
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
        ", thirdPartyId='" + thirdPartyId + '\'' +
        ", name='" + name + '\'' +
        ", photoUrls=" + photoUrls +
        ", source=" + source +
        ", externalStatus=" + externalStatus +
        ", internalStatus=" + internalStatus +
        '}';
  }
}
