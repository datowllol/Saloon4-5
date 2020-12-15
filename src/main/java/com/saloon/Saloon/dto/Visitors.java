package com.saloon.Saloon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class Visitors {


    private UUID visitorId;
    private int visitorsNum;
    private UUID occupiedTableID;



}