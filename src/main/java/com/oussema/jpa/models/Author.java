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
@Table(name = "authors")
@Entity
public class Author extends BaseEntity {

//    @Id
//    @GeneratedValue(
//            strategy = GenerationType.AUTO
//            generator = "author_iq_generator"
//    )
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 1
//    )
//    @TableGenerator(
//            name = "author_iq_generator",
//            table = "author_iq_generator",
//            pkColumnName = "sequence_name",
//            valueColumnName = "sequence_value",
//            allocationSize = 1
//    )


//    private Integer id; // Integer instead of int because hibernate needs a null value to know that the object is not yet persisted
    @Column(name = "f_name", length = 35
    )
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false
    )
    private String email;

    private int age;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors") // mappedBy is used to specify the field in the other entity that is the owner of the relationship
    private List<Course> courses;

}
