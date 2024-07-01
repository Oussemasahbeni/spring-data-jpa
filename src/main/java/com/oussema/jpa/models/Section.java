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
@Table(name = "section")
@Entity
public class Section extends BaseEntity {



    private String name;

    private int sectionOrder;

    // when using @ManyToOne,we need to specify the column that will be used to join the two tables using @JoinColumn
    @ManyToOne
    @JoinColumn(name = "course_id") // This is used to specify the column that will be used to join the two tables
    private Course course;

    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
