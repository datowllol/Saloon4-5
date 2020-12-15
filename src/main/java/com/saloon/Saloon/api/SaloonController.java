package com.saloon.Saloon.api;


import com.saloon.Saloon.dto.Visitors;
import com.saloon.Saloon.model.FreeTable;
import com.saloon.Saloon.model.Saloon;
import com.saloon.Saloon.service.saloonService.SaloonService;
import com.saloon.Saloon.service.tableLeaving.TableLeavingService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/saloon")
@AllArgsConstructor
@NoArgsConstructor
public class SaloonController {
    @Autowired
    SaloonService saloonService;
    @Autowired
    TableLeavingService tableLeavingService;

    @PostMapping()
    public Saloon addSaloon(@RequestBody Saloon saloon) {
        return saloonService.addSaloon(saloon);
    }

    @PostMapping("getbynum")
    public Saloon getByNumber(@RequestBody Visitors visitorsDTO) {
        return saloonService.getByPlaceNum(visitorsDTO);
    }

    @PostMapping("setfree")
    public FreeTable setFreeTable(@RequestBody FreeTable freeTable) {
        return tableLeavingService.setFree(freeTable);
    }

    @GetMapping()
    public List<Saloon> getAll() {
        return saloonService.getAll();
    }


    @GetMapping("/{tableID}")
    public Saloon getById(@PathVariable(value = "tableID") UUID id) {
        return saloonService.getById(id);
    }

    @DeleteMapping("/{tableID}")
    public ResponseEntity<Void> deleteSaloonById(@PathVariable(value = "tableID") UUID id) {
        saloonService.deleteSaloonById(id);
        return ResponseEntity.noContent().build();
    }
}