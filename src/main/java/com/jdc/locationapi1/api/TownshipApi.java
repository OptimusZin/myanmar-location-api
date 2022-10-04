package com.jdc.locationapi1.api;

import com.jdc.locationapi1.model.dto.TownshipDto;
import com.jdc.locationapi1.model.service.TownshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("township")
public class TownshipApi {


    @Autowired
    private TownshipService service;



    @GetMapping
     List<TownshipDto> search(
           @RequestParam Optional<Integer> id,
           @RequestParam Optional<String> name
    ){
        return service.search(id, name);
    }

    @GetMapping("{id}")
    TownshipDto findById(@PathVariable  int id){
        return service.findById(id);
    }

}
