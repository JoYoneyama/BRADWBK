package com.bradwbk.atividade3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // GET /user
    @GetMapping
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("API funcionando");
    }

    // GET /user/{login}
    @GetMapping("/{login}")
    public ResponseEntity<?> getUser(@PathVariable String login) {
        User user = userService.find(login);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    // POST /user
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        userService.add(user);

        return ResponseEntity.created(
                URI.create("/user/" + user.getLogin())
        ).body(user);
    }

    // PUT /user
    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        User existing = userService.find(user.getLogin());

        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        userService.remove(user.getLogin());
        userService.add(user);

        return ResponseEntity.ok(user);
    }

    // DELETE /user/{login}
    @DeleteMapping("/{login}")
    public ResponseEntity<String> delete(@PathVariable String login) {
        boolean removed = userService.remove(login);

        if (removed) {
            return ResponseEntity.ok("Usuário removido");
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado");
        }
    }
}