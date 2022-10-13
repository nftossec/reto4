package com.reto3_final.reto3_final.repository.crudRepository;

import com.reto3_final.reto3_final.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
