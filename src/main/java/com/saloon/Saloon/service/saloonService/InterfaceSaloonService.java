package com.saloon.Saloon.service.saloonService;



import com.saloon.Saloon.dto.Visitors;
import com.saloon.Saloon.model.Saloon;

import java.util.List;
import java.util.UUID;

public interface InterfaceSaloonService {

    Saloon addSaloon(Saloon saloon);

    List<Saloon> getAll();

    Saloon getById(UUID id);

    Saloon getByPlaceNum(Visitors visitorsDto);

    void deleteSaloonById(UUID Id);
}
