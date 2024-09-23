package com.zoch.recipe_sharing.Services;

import com.zoch.recipe_sharing.model.recipe;
import com.zoch.recipe_sharing.model.user;
import com.zoch.recipe_sharing.repository.recipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class recipeServiceImplementation implements recipeService{
    @Autowired
    recipeRepository RecipeRepository;



    @Override
    public recipe createRecipe(Optional<user> User, recipe Recipe) {
        recipe createdRecipe=new recipe();
        createdRecipe.setTitle(Recipe.getTitle());
        createdRecipe.setImage(Recipe.getImage());
        createdRecipe.setUser(Recipe.getUser());
        createdRecipe.setLikes(Recipe.getLikes());
        createdRecipe.setDescription((Recipe.getDescription()));
        createdRecipe.setCreatedAt(LocalDateTime.now());
        return RecipeRepository.save(createdRecipe);
    }

    @Override
    public recipe findRecipeById(Long id) throws Exception {
        Optional<recipe> Recipe=RecipeRepository.findById(id);

        if(Recipe.isPresent()){
        return Recipe.orElse(null);}
        throw new Exception("Recipe with "+id+" not found");

    }

    @Override
    public String deleteRecipe(Long id) throws Exception {
        Optional<recipe> Recipe=RecipeRepository.findById(id);
        if (Recipe.isPresent()){
            RecipeRepository.deleteById(id);
            return("Recipe deleted successfully");
        }
        throw new Exception("Recipe with id:"+ id+" not found");
    }

    @Override
    public List<recipe> findAllRecipe() {
        return RecipeRepository.findAll();
    }

    @Override
    public recipe updateRecipe(recipe Recipe, Long id) throws Exception {

        recipe updatedRecipe=findRecipeById(id);
        updatedRecipe.setTitle(Recipe.getTitle());
        updatedRecipe.setImage(Recipe.getImage());
        updatedRecipe.setUser(Recipe.getUser());
        updatedRecipe.setLikes(Recipe.getLikes());
        updatedRecipe.setDescription((Recipe.getDescription()));
        updatedRecipe.setCreatedAt(LocalDateTime.now());

        return RecipeRepository.save(updatedRecipe);
    }

    @Override
    public recipe likeRecipe(Long recipeId, Optional<user> User) throws Exception {

        recipe Recipe = findRecipeById(recipeId);
        if (Recipe.getLikes().contains(User.get().getId())) {
            Recipe.getLikes().remove(User.get().getId());
        } else {
            Recipe.getLikes().add(User.get().getId());
        }
        return RecipeRepository.save(Recipe);}


}


















