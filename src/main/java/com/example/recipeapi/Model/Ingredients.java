package com.example.recipeapi.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredients {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String quantity;

    public Ingredients(String blackberries, String s) {

    }
}