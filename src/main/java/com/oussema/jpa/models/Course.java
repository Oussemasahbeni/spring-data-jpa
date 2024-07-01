package com.oussema.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Table(name = "course")
@Entity
public class Course extends BaseEntity {



    private String name;

    private String description;

    @ManyToMany()
    // @JoinTable is used to specify the name of the join table and the columns that will be used to join the two tables
    // The joinColumns is used to specifiy the owner of the relationship
    // The inverseJoinColumns is used to specify the other side of the relationship
    @JoinTable(
            name ="authors_courses",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")
            }
    )
    private List<Author> authors;

    @OneToMany(mappedBy = "course") // mappedBy is used to specify the field in the target entity that owns the relationship
    private List<Section> sections;

}
