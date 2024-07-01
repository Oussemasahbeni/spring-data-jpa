package com.oussema.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // good for small tables
//@DiscriminatorColumn(name = "resource_type") // only for single table
//@Inheritance(strategy = InheritanceType.JOINED) // good for tables with many columns and many subclasses
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // good for tables with many columns and few subclasses
public class Resource {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private int size;

    private String url;

//    @OneToOne(mappedBy = "resource")
//    @JoinColumn(name = "lecture_id")
//    private Lecture lecture;
}
