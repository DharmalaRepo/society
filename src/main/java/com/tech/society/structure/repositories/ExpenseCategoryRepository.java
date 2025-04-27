package com.tech.society.structure.repositories;

import com.tech.society.structure.models.ExpenseCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseCategoryRepository extends MongoRepository<ExpenseCategory, String> {

    List<ExpenseCategory> findBySocietyIdentifier(String societyIdentifer);
}
