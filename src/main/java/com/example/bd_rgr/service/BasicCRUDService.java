package com.example.bd_rgr.service;

import com.example.bd_rgr.dto.BasicDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BasicCRUDService<Entity, Repo extends CrudRepository<Entity, Integer>, DTO extends BasicDTO<Entity>> {

    protected final Repo repo;

    BasicCRUDService(Repo repo) {
        this.repo = repo;
    }

    public Entity create(DTO dto) {
        return repo.save(dto.toEntity());
    }

    public Iterable<Entity> getAll() {
        return repo.findAll();
    }

    public Entity getById(Integer id) {
        Entity entity = repo.findById(id).orElse(null);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        return entity;
    }

    public Integer delete(Integer id) {
        repo.deleteById(id);
        return id;
    }

    public Entity update(DTO newDto, Integer id) {
        Entity entity = repo.findById(id).orElse(null);
        if (entity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find");
        }
        var newEntity = repo.save(newDto.setToEntity(entity));
        return newEntity;
    }
}
