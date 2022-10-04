package com.jdc.locationapi1.model.service;


import com.jdc.locationapi1.model.dto.StateDto;
import com.jdc.locationapi1.model.entity.State;
import com.jdc.locationapi1.model.repository.StateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepo stateRepo;



    public List<StateDto> search(Optional<String> region , Optional<String> nameLike){

        Specification<State> spec = Specification.where(null);

       var specRegion = region.filter(StringUtils::hasLength)
                .map(val -> {
                    Specification<State> where = ((root, query, cb) ->
                            cb.equal(root.get("region"), val) );
                    return where;
                }).orElse(Specification.where(null));


       spec = spec.and(specRegion);

        var specNameLike = region.filter(StringUtils::hasLength)
                .map(val -> {
                    Specification<State> where = ((root, query, cb) ->
                            cb.like(cb.lower(root.get("name")), val.toLowerCase().concat("%")) );
                    return where;
                }).orElse(Specification.where(null));

        spec = spec.and(specNameLike);


        return stateRepo.findAll(spec)
                .stream()
                .map(StateDto::new)
                .toList();

     } //repo ka nay find yin entity ya lar mar ae dar ko dto change pee view ko pyan pay


    //dynamic query so cretia query ko use static query so jpql ko use

    public StateDto findById(int id) {

       return stateRepo.findById(id).map(StateDto::new)
               .orElseThrow(() -> new EntityNotFoundException("There is no state with id %d" . formatted(id)));
    }

}
