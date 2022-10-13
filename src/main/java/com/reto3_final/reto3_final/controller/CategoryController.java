package com.reto3_final.reto3_final.controller;

import com.reto3_final.reto3_final.entity.Category;
import com.reto3_final.reto3_final.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category postCategory(@RequestBody Category category){
        return categoryService.save(category);
    }

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Category postCategory2(@RequestBody Category category){

        return categoryService.save(category);
    }

   @PutMapping("/update")
   @ResponseStatus(HttpStatus.CREATED)
   public Category update(@RequestBody Category category){
        return categoryService.update(category);
   }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteCategory (@PathVariable("id")int id){
        return categoryService.deleteCategory(id);
    }



}
