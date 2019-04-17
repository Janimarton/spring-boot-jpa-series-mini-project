# spring-boot-jpa-series-mini-project

in this project I implement a JPA project with the following entities:

Series
Season
Episode

Each entity should contain at least 3 attributes (id, name, title, length, releaseDate, etc), and there should be the entities connects together based on these relations:

1 Series has N Seasons
1 Season has N Episodes

That was required also that i should use all of these JPA annotations: @Transient, @Enumerated, @ElementCollection.
