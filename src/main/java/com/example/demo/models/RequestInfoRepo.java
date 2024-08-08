package com.example.demo.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestInfoRepo extends CrudRepository<RequestInfo, Long> {
    boolean existsByIp(String ip);
}
