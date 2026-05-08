package main.java.com.atividade7.atividade7.repository;

import com.biblioteca.model.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}