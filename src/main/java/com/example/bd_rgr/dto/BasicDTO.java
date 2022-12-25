package com.example.bd_rgr.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;


public interface BasicDTO<Entity> {

    @ApiModelProperty(hidden = true)
    @JsonIgnore
    abstract Entity toEntity();
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    abstract Entity setToEntity(Entity entity);

}
