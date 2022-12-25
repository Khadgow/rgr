package com.example.bd_rgr.controller;

import com.example.bd_rgr.dto.BasicDTO;
import com.example.bd_rgr.service.BasicCRUDService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class BasicController<Entity, Repo extends CrudRepository<Entity, Integer>, DTO extends BasicDTO<Entity>, Service extends BasicCRUDService<Entity, Repo, DTO>> {

    protected final Service service;

    public BasicController(Service service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Iterable<Entity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Entity> create(@RequestBody DTO dto) {
        var newStore = service.create(dto);
        return ResponseEntity.ok(newStore);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entity> getById(@PathVariable("id") Integer id) {
        var store = service.getById(id);
        return ResponseEntity.ok(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entity> updateById(@RequestBody DTO dto, @PathVariable("id") Integer id) {
        var newStore = service.update(dto, id);
        return ResponseEntity.ok(newStore);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteSellerById(@PathVariable("id") Integer id) {
        var storeId = service.delete(id);
        return ResponseEntity.ok(storeId);
    }
}
