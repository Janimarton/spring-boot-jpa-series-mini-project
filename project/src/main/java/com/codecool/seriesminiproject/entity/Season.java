package com.codecool.seriesminiproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {

    @Id
    @GeneratedValue
    private Long id;

    private Integer episodeNum;

    private LocalDate releaseDate;

    @Singular
    @JsonIgnoreProperties({"season"})
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @EqualsAndHashCode.Exclude
    private List<Episode> episodes;

    @ManyToOne
    private Series series;


}
