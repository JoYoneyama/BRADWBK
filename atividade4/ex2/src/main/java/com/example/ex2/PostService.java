package main.java.com.example.ex2;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> listar() {
        return repository.findAll();
    }

    public Post buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));
    }

    public Post criar(Post post) {
        post.setDataCriacao(LocalDateTime.now());
        return repository.save(post);
    }

    public Post atualizar(Long id, Post novoPost) {
        Post post = buscarPorId(id);

        post.setTitulo(novoPost.getTitulo());
        post.setConteudo(novoPost.getConteudo());

        return repository.save(post);
    }

    public Post deletar(Long id) {
        Post post = buscarPorId(id);
        repository.delete(post);
        return post;
    }
}