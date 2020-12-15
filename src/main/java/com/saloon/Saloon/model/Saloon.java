package com.saloon.Saloon.model;


import com.saloon.Saloon.SaloonResponse;
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
@NoArgsConstructor
public final class Saloon {

    @Id
    private UUID tableId;

    @Column
    private int placeNum;

    @Column
    private String uniqueName;

    @Column
    private UUID occupiedTableId;

    @Column
    private UUID freeTableId;


    public Saloon(String uniqueName, int placeNum) {
        tableId = UUID.randomUUID();
        this.placeNum = placeNum;
        this.uniqueName = uniqueName;
    }


    public  SaloonResponse toSaloonResponse() {
        return SaloonResponse.newBuilder().
                setTableId(tableId.toString()).
                setPlaceNum(placeNum).
                setUniqueName(uniqueName).
                setOccupiedTableId(occupiedTableId.toString()).
                setFreeTableId(freeTableId.toString()).
                build();
    }

    public static Saloon fromSaloonRequest(SaloonResponse saloonResponse) {
        return new Saloon( UUID.fromString(saloonResponse.getTableId()),
                saloonResponse.getPlaceNum(),
                saloonResponse.getUniqueName(),
                UUID.fromString(saloonResponse.getOccupiedTableId()),
                UUID.fromString(saloonResponse.getFreeTableId()));

    }

}
