package com.jdc.locationapi1.model.dto;


import com.jdc.locationapi1.model.entity.Township;

public record TownshipDto(

        int id,
        String name,
        int stateId,
        String stateName
) {

    public  TownshipDto(Township township){
        this(township.getId(), township.getName(), township.getState().getId() , township.getState().getName());
    }



}
