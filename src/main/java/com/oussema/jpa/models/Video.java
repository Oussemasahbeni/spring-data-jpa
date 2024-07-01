package com.oussema.jpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
//@DiscriminatorValue("v")
//@PrimaryKeyJoinColumn(name="video_id") // when using JOINED inheritance
@Polymorphism(type = PolymorphismType.EXPLICIT) // to exclude the mapping of this class from the parent class
public class Video extends Resource {

    private int length;

}
