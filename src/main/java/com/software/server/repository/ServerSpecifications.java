package com.software.server.repository;

import org.springframework.data.jpa.domain.Specification;

import com.software.server.model.Server;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ServerSpecifications{


    public static Specification<Server> getServerWithMultipleApplication(){
        return new Specification<Server>() {
            @Override
            public Predicate toPredicate(
                    Root<Server> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThan(
                        criteriaBuilder.size(root.get("applications")), 1);
            }
        };
    }

    public static Specification<Server> getServerByOperatingSystem(String operatingSystem) {
        return new Specification<Server>() {
            @Override
            public Predicate toPredicate(
                    Root<Server> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder criteriaBuilder
            ) {
                return criteriaBuilder.equal(
                    root.get("operatingSystem"),
                     operatingSystem);
            }
        };
    }
}