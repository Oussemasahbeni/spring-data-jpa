package com.oussema.jpa;

import com.github.javafaker.Faker;
import com.oussema.jpa.models.Author;
import com.oussema.jpa.models.Video;
import com.oussema.jpa.repositories.AuthorRepository;
import com.oussema.jpa.repositories.VideoRepository;
import com.oussema.jpa.specification.AuthorSpec;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Bean
    @Transactional
    public CommandLineRunner run(
            AuthorRepository authorRepository,
            VideoRepository videoRepository

    ){

        return (args -> {
    //        var author= Author.builder()
//                        .firstName("Oussema")
//                        .lastName("sahbeni")
//                        .email("oussemasahbeni300@gmail.com")
//                        .age(25)
//                        .build();
//
//                authorRepository.save(author);
//            var video = Video.builder()
//                    .name("video1")
//                    .size(100)
//                    .url("http://www.youtube.com")
//                    .length(10)
//                    .build();
//            videoRepository.save(video);
//            for (int i=0; i<50; i++){
//                Faker faker = new Faker();
//                var author= Author.builder()
//                        .firstName(faker.name().firstName())
//                        .lastName(faker.name().lastName())
//                        .email(faker.internet().emailAddress())
//                        .age(faker.number().numberBetween(20, 50))
//                        .build();
//                authorRepository.save(author);
//            }
//            authorRepository.findAllByFirstName("Andres").forEach(System.out::println);

            Specification<Author> spec = Specification.where(
                    AuthorSpec.hasAge(46)
            ).and(
                    AuthorSpec.firstNameLike("Andres")
            );
            authorRepository.findAll(spec).forEach(System.out::println);
        });


    }
}
