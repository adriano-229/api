package com.example.client.persistence.rest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public abstract class BaseRestDao<D, ID> {

    protected final RestTemplate restTemplate;
    private final String resourcePath;
    private final Class<D> dtoClass;
    private final ParameterizedTypeReference<List<D>> listType;

    protected BaseRestDao(RestTemplate restTemplate,
                          String resourcePath,
                          Class<D> dtoClass,
                          ParameterizedTypeReference<List<D>> listType) {
        this.restTemplate = restTemplate;
        this.resourcePath = resourcePath;
        this.dtoClass = dtoClass;
        this.listType = listType;
    }

    public List<D> list() {
        ResponseEntity<List<D>> response = restTemplate.exchange(resourcePath, HttpMethod.GET, null, listType);
        return response.getBody();
    }

    public D get(ID id) {
        return restTemplate.getForObject(resourcePath + "/{id}", dtoClass, id);
    }

    public D create(D entity) {
        return restTemplate.postForObject(resourcePath, entity, dtoClass);
    }

    public D update(ID id, D entity) {
        restTemplate.put(resourcePath + "/{id}", entity, id);
        return get(id);
    }

    public void delete(ID id) {
        restTemplate.delete(resourcePath + "/{id}", id);
    }
}
