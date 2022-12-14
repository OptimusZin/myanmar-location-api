package com.jdc.locationapi1.model.dto;

import com.jdc.locationapi1.model.entity.State;

public record StateDto(
        int id,
        String name,
        String region,
        String capital
) {

   public StateDto(State state){
       this(state.getId(), state.getName(), state.getRegion(), state.getCapital());
   }

}
