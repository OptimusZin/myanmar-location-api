package com.jdc.locationapi1.api;

import com.jdc.locationapi1.model.dto.StateDto;
import com.jdc.locationapi1.model.entity.State;
import com.jdc.locationapi1.model.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("state")
public class StateApi {

    @Autowired
    private StateService service;



    @GetMapping
    List<StateDto> search(
            @RequestParam Optional<String> region,
            @RequestParam Optional<String> name
    ){
        return service.search(region, name);
    }


    @GetMapping("{id}")
    StateDto findById(@PathVariable int id){
        return service.findById(id);
    }


}
