package com.example.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "MovieRating")
public class Movie {

    @Id
   // @NotNull(message = "Id is required")
   // @Min(value = 3,message = "The length must be more than 3")
    private Integer id;

    @Column(unique = true, nullable = false)
   // @Size(min = 2, message = "length must be more than 2")
    private String name;

    @Column(nullable = false)
    @Pattern(regexp = ("Drama|Action|Comedy"))
    private String genre;

    @Column(nullable = false)
    @Positive(message = "Must be number")
    @Range(min = 1, max = 5, message = "Rating range must be between 1-5")
    private String rating;

    @Column(nullable = false)
    @Positive(message = "Must be number")
    @Min(value = 60, message = "must be more than 60")
    private Integer duration;

    @Column(nullable = false)
    private LocalDate lunchDate = LocalDate.now();

}
