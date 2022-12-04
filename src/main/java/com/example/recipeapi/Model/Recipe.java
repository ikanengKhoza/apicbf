package com.example.recipeapi.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "recipe")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Recipe {
    @Id

    @SequenceGenerator(
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )

    private Long id;
    private String name;
    private String description;
    private String instructions;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name= "recipe_ingredients_table", joinColumns = {
            @JoinColumn(name = "recipe_id", referencedColumnName = "id")

    },

            inverseJoinColumns = {
                    @JoinColumn(name = "ingredients_id", referencedColumnName = "id")
            }
    )
    private Set<Ingredients> ingredients;
}