package edu.mum.coffee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.repository.OrderlineRepository;

@Service
@Transactional
public class OrderlineService {
	
	@Autowired
	private OrderlineRepository orderlineRepository;
	
	public Orderline save(Orderline orderline){
		return orderlineRepository.save(orderline);
	}
	
	public void delete(Orderline orderline){
		 orderlineRepository.delete(orderline);
	}

}
