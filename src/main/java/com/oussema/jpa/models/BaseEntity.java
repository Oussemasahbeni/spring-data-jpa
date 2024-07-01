package com.oussema.jpa.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedAt;

    private String createdBy;

    private String lastModifiedBy;

}
