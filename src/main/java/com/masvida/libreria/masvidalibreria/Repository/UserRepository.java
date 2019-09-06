package com.masvida.libreria.masvidalibreria.Repository;

import com.masvida.libreria.masvidalibreria.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
