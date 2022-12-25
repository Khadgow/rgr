package com.example.bd_rgr.controller;

import com.example.bd_rgr.dto.StoreDTO;
import com.example.bd_rgr.entity.storeDirection.StoreEntity;
import com.example.bd_rgr.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping
    public ResponseEntity<Iterable<StoreEntity>> getStores() {
        return ResponseEntity.ok(storeService.getAll());
    }

    @PostMapping
    public ResponseEntity<StoreEntity> createStore(@RequestBody StoreDTO storeDTO) {
        var newStore = storeService.create(storeDTO);
        return ResponseEntity.ok(newStore);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreEntity> getStoreById(@PathVariable("id") Integer id) {
        var store = storeService.getById(id);
        return ResponseEntity.ok(store);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreEntity> updateStoreById(@RequestBody StoreDTO storeDTO, @PathVariable("id") Integer id) {
        var newStore = storeService.update(storeDTO, id);
        return ResponseEntity.ok(newStore);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteStoreById(@PathVariable("id") Integer id) {
        var storeId = storeService.delete(id);
        return ResponseEntity.ok(storeId);
    }
}
