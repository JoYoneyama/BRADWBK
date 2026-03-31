package main.java.com.example.ex2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Post buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Post criar(@RequestBody Post post) {
        return service.criar(post);
    }

    @PutMapping("/{id}")
    public Post atualizar(@PathVariable Long id, @RequestBody Post post) {
        return service.atualizar(id, post);
    }

    @DeleteMapping("/{id}")
    public Post deletar(@PathVariable Long id) {
        return service.deletar(id);
    }
}