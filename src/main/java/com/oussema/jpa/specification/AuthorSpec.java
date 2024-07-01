package com.oussema.jpa.specification;

import com.oussema.jpa.models.Author;
import org.springframework.data.jpa.domain.Specification;

public class AuthorSpec {

    public  static Specification<Author> hasAge(int age){
        return (
                (root,
                 query,
                 criteriaBuilder) -> {
                    if(age == 0){
                        return null;
                    }
                    return criteriaBuilder.equal(root.get("age"), age);
                }
                );
    }

    public static Specification<Author> firstNameLike(String fn){
        return (
                (root,
                 query,
                 criteriaBuilder) -> {
                    if(fn == null){
                        return null;
                    }
                    return criteriaBuilder.like(root.get("firstName"), "%"+ fn + "%");
                }
                );
    }
}
