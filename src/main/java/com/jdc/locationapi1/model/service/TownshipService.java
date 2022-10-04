package com.jdc.locationapi1.model.service;

import com.jdc.locationapi1.model.dto.TownshipDto;
import com.jdc.locationapi1.model.entity.State;
import com.jdc.locationapi1.model.entity.Township;
import com.jdc.locationapi1.model.repository.TownshipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TownshipService {


    @Autowired
    private TownshipRepo repo;


    public List<TownshipDto> search(Optional<Integer> divisionId , Optional<String > nameLike){
        Specification<Township> spec = Specification.where(null);


        var specDivisionId = divisionId.filter(id -> id > 0)
                .map(id -> {
                    Specification<Township> where = ((root, query, cb) ->
                            cb.equal(root.get("state").get("id"), id) );
                    return where;
                }).orElse(Specification.where(null));

        spec =spec.and(specDivisionId);


        var specNameLike = nameLike.filter(StringUtils::hasLength)
                .map(val -> {
                    Specification<Township> where = ((root, query, cb) ->
                            cb.like(cb.lower(root.get("name")), val.toLowerCase().concat("%")) );
                    return where;
                }).orElse(Specification.where(null));

        spec = spec.and(specNameLike);



        return repo.findAll().stream().map(TownshipDto::new).toList();

    }


    public TownshipDto findById(int id) {

        return  repo.findById(id).map(TownshipDto::new).orElseThrow(() -> new EntityNotFoundException("There is no township with id %d" . formatted(id)));
    }
}
