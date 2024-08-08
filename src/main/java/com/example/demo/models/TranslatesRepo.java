package com.example.demo.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslatesRepo extends CrudRepository<Translate, Long> {
}
