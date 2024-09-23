package com.zoch.recipe_sharing.Services;

import com.zoch.recipe_sharing.model.recipe;
import com.zoch.recipe_sharing.model.user;

import java.util.List;
import java.util.Optional;

public interface recipeService {

    public recipe createRecipe(Optional<user> User, recipe Recipe);
    public recipe findRecipeById(Long id) throws Exception;
    public String deleteRecipe(Long id) throws Exception;
    public List<recipe> findAllRecipe();
    public recipe updateRecipe(recipe Recipe,Long id) throws Exception;
    public recipe likeRecipe(Long recipeId, Optional<user> User)throws Exception;


}
