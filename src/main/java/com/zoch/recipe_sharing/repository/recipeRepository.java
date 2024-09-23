package com.zoch.recipe_sharing.repository;

import com.zoch.recipe_sharing.model.recipe;
import com.zoch.recipe_sharing.model.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface recipeRepository extends JpaRepository<recipe,Long> {

}
