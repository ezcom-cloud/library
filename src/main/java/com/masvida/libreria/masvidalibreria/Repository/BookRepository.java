package com.masvida.libreria.masvidalibreria.Repository;

import com.masvida.libreria.masvidalibreria.Model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {}
