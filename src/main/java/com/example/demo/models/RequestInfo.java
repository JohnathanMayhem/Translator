package com.example.demo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("requests_info")
public class RequestInfo {
    @Id
    long id;
    String ip;

    public RequestInfo(String ip) {
        this.ip = ip;
    }
}
