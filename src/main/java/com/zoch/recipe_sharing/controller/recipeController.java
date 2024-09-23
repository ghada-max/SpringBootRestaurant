package com.zoch.recipe_sharing.controller;

import com.zoch.recipe_sharing.Services.recipeService;
import com.zoch.recipe_sharing.model.recipe;
import com.zoch.recipe_sharing.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.zoch.recipe_sharing.repository.userRepository;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/Recipe")

public class recipeController {
@Autowired
    recipeService recipeservice;
    @Autowired
    userRepository userrepository;

    @PostMapping(path="/user/recipe/{userId}")
    public recipe createRecipe(@RequestBody recipe Recipe, @PathVariable Long userId){
        Optional<user> User=userrepository.findById(userId);
        recipe createdRecipe=recipeservice.createRecipe(User,Recipe);
        return createdRecipe;
    }
    @GetMapping (path="/recipe/getAllRecipes")
    public List<recipe> getAllRecipes(){
         List<recipe> recipes=recipeservice.findAllRecipe();
         return recipes;
    }

    @DeleteMapping(path = "/recipe/delete/{id}")
    public String deleteRecipe(@PathVariable Long id) throws Exception {
        try {
            String response = recipeservice.deleteRecipe(id);
            return response;
        } catch (Exception e) {
            // Handle the exception here
            throw new Exception("Something went wrong while deleting the recipe with id: " + id, e);
        }
    }

    @PutMapping(path = "/recipe/update/{id}")
    public recipe updateRecipe(@RequestBody recipe Recipe,@PathVariable Long id) throws Exception {
        try {
         recipe updatedrecipe=recipeservice.updateRecipe(Recipe,id);
         return updatedrecipe;
        } catch (Exception e) {
            // Handle the exception here
            throw new Exception("Something went wrong while updating the recipe with id: " + id, e);
        }
    }

    @PutMapping(path = "/recipe/{recipeid}/user/{userId}")
    public recipe likeRecipe(@PathVariable Long recipeId,@PathVariable Long UserId) throws Exception {
        try {

            Optional<user> User=userrepository.findById(UserId);
            recipe likerecipe=recipeservice.likeRecipe(recipeId,User);
            return likerecipe;
        } catch (Exception e) {
            // Handle the exception here
            throw new Exception("Something went wrong" );
        }
    }






























}











