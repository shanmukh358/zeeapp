package com.zee.zee5app.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.IdNotFoundException;
import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.InvalidEmailException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;
import com.zee.zee5app.Exception.InvalidPasswordException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.Subrepo;
import com.zee.zee5app.service.Subservice2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Subserviceimpl implements Subservice2 {
	@Autowired
	private Subrepo subRepository;
   public Subserviceimpl() throws IOException {
		
	}
//	private static Subservice2 service4;
//	public static Subservice2 getInstance() throws IOException {
//    	if(service4==null) {
//    		service4=new Subserviceimpl();
//    	}
//    	return service4;
//    }
	
	
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
      Subscription subscription2=subRepository.save(subscription);
		
		System.out.println(subscription2);
		if(subscription2!=null) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String updateSubscription(String id,Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws LocationNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
		return subRepository.findById(id);
	}
	@Override
	public Subscription[] getAllSubscription() throws LocationNotFoundException, InvalidAmountException{
		// TODO Auto-generated method stub
		List<Subscription> list=subRepository.findAll();
		Subscription[] array=new Subscription[list.size()];
		return list.toArray(array);
	}
	@Override
	public Optional<List<Subscription>> getAllSubscriptiondetails() throws LocationNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subRepository.findAll());
	}

	@Override
	public String deleteSubscription(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<Subscription> optional=this.getSubscriptionById(id);
			if(optional.isEmpty()) {
				throw new IdNotFoundException("record not found");
			}else {
				subRepository.deleteById(id);
			}
			return "success";
		} catch (IdNotFoundException | InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new LocationNotFoundException(e.getMessage());
		}
	}

}
