package com.saloon.Saloon.model;


import com.saloon.Saloon.FreeTableRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor

public final class FreeTable {

    @Id
    private UUID freeTableId;
    @Column
    private UUID saloonId;

    public FreeTable() {
        freeTableId = UUID.randomUUID();
    }

    public FreeTableRequest toFreeTableResponse() {
        return FreeTableRequest.newBuilder().
                setFreeTableId(freeTableId.toString()).
                setSaloonId(saloonId.toString()).
                build();
    }
}