package com.software.server.repository;

import org.springframework.data.jpa.domain.Specification;

import com.software.server.model.Application;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ApplicationSpecifications {
    
    public static Specification<Application> getApplicationByName(String name) {
        return new Specification<Application>() {
            @Override
            public Predicate toPredicate(Root<Application> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                Predicate equalPredicate = criteriaBuilder.equal(
                    root.get("name"),
                     name);
                return equalPredicate;
            }
        };
    }
}
