package com.saloon.Saloon.service.tableLeaving;


import com.saloon.Saloon.model.FreeTable;
import com.saloon.Saloon.repository.FreeTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TableLeavingService implements InterfaceTableLeavingService {
    @Autowired
    FreeTableRepository tableRepository;

    public FreeTable addTable(FreeTable table) {
        FreeTable savedTable = tableRepository.save(table);
        return savedTable;
    }

    public FreeTable setFree(FreeTable tableDto){
        FreeTable table = new FreeTable();
        table.setSaloonId(tableDto.getSaloonId());
        table = tableRepository.save(table);
        return table;
    }
    public List<FreeTable> getAll() {
        return tableRepository.findAll();
    }

    public FreeTable getById(UUID id) {
        return tableRepository.getOne(id);
    }

    public void deleteById(UUID id) {
        tableRepository.deleteById(id);
    }
}
