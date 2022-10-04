package com.jdc.locationapi1.model.repository;

import com.jdc.locationapi1.model.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepo extends JpaRepository<State , Integer>, JpaSpecificationExecutor<State> {



}
