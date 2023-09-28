package com.java_template.controller;

        import com.java_template.dto.UserDTO;
        import com.java_template.entities.User;
        import com.java_template.service.MicroserviceService;
        import jakarta.validation.Valid;
        import org.springframework.beans.factory.annotation.Autowired;

        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.http.ResponseEntity;
        import org.springframework.validation.annotation.Validated;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;


@RestController
@Validated

public class MicroserviceController {

    @Autowired
    private MicroserviceService userService;
    @GetMapping("/{id}")
    public @ResponseBody Optional<User> getId(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/findAll")
    public @ResponseBody List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserDTO user){
        return userService.createUser(user);
    }
}