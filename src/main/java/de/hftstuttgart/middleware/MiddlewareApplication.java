package de.hftstuttgart.middleware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class MiddlewareApplication {

    PostList postList = new PostList();

    public static void main(String[] args) {
        SpringApplication.run(MiddlewareApplication.class, args);
    }

    @GetMapping("/")
    public String greeting() {
        return "Hallo";
    }

    @GetMapping("/hello/{parameter}")
    public String greetingWithParameter(@PathVariable String parameter) {
        return "Hallo " + parameter + "!";
    }

    @GetMapping("/posts")
    public String getAllPosts() {
        return postList.getAllFormatted();
    }

    @PostMapping("/addPost")
    public ResponseEntity<String> persistPost(@RequestBody Post newPost) {
        postList.addPost(newPost);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Post hinzugefügt ");
    }

    @PostMapping("/deletePost")
    public ResponseEntity<String> deletePost(@RequestBody Post toDeleteID) {
        postList.deletePost(toDeleteID.getID());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Post gelöscht");
    }

    @PutMapping("/changePost")
    public ResponseEntity<String> changePost(@RequestBody Post newPost) {
        postList.updatePost(newPost);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Post mit ID: " + newPost.getID() + "geändert");
    }
}
