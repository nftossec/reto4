package com.reto3_final.reto3_final.service;

import com.reto3_final.reto3_final.entity.Category;
import com.reto3_final.reto3_final.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int idCategory){
        return categoryRepository.getCategory(idCategory);
    }

    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        } else {
            Optional<Category> e=categoryRepository.getCategory(category.getId());
            if(e.isEmpty()){
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }

    /*  *****************update reto 2 ***************************************
    public Category update(Category category){
        if(category.getIdReservation()!=null){
            Optional<Category> q = categoryRepository.getCategory(category.getIdReservation());
            if(q.isPresent()){
                if(category.getName()!=null){
                    q.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    q.get().setDescription(category.getDescription());
                }

                categoryRepository.save(q.get());
                return q.get();

            }else {
                return category;
            }

        }else {
            return category;
        }
    }
    ********************************************************************************+
    */

        public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category> q = categoryRepository.getCategory(category.getId());
              if(q.isPresent()) {                              // **** if(q.isPresent()){
                  if (category.getName() != null) {
                      q.get().setName(category.getName());
                  }
                  if (category.getDescription() != null) {
                      q.get().setDescription(category.getDescription());
                  }
                  return categoryRepository.save(q.get());
              }                                                      /* ****  categoryRepository.save(q.get());
                                                                 return q.get();
                                                                 }else {
                                                                }
                                                            return category;
                                                            }
                                                            }else {
                                                                return category;

                                                           ********     */
        }
              return category;
    }

    /* ********en reto 2 **********************************
    public boolean delete(int id){
        Boolean flag=false;
        Optional<Category> category= categoryRepository.getCategory(id);
        if(category.isPresent()){
            categoryRepository.delete(category.get());
            flag=true;
        }

        return flag;
    }
    ********************************************************
*/
    public boolean deleteCategory(int id){
        Boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
}

