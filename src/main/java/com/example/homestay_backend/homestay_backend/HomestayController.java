package com.example.homestay_backend.homestay_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homestays")
@CrossOrigin(origins = "http://localhost:5173")  
public class HomestayController {

    @Autowired
    private HomestayRepository repo;

    // 🔹 GET ALL (READ)
    @GetMapping
    public List<Homestay> getAll() {
        return repo.findAll();
    }

    // 🔹 CREATE
    @PostMapping
    public Homestay add(@RequestBody Homestay h) {
        return repo.save(h);
    }

    // 🔹 UPDATE
    @PutMapping("/{id}")
    public Homestay update(@PathVariable Long id, @RequestBody Homestay h) {
        h.setId(id);
        return repo.save(h);
    }

    // 🔹 DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}