package edu.mum.coffee.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.coffee.domain.Orderline;

public interface OrderlineRepository extends JpaRepository<Orderline, Serializable> {

}
