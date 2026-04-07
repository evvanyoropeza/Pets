package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class PetResponse {

    private String transactionId;
    private LocalDateTime dateCreated;
    private Long id;
    private String name;
    private String status;

    public PetResponse(Long id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public PetResponse(String transactionId, LocalDateTime dateCreated, String status, String name) {
        this.transactionId = transactionId;
        this.dateCreated = dateCreated;
        this.status = status;
        this.name = name;
    }

}