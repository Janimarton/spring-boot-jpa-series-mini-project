package com.codecool.seriesminiproject.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate releaseDate;

    @Singular
    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @EqualsAndHashCode.Exclude
    private List<Season> seasons;


    private Integer seasonsNum;


}
