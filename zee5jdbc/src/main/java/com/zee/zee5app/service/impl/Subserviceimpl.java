package com.zee.zee5app.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.Subrepo2;
import com.zee.zee5app.repository.impl.Subrepoimpl;
import com.zee.zee5app.service.Subservice2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Subserviceimpl implements Subservice2 {
   private Subserviceimpl() throws IOException {
		
	}
	private static Subservice2 service4;
	public static Subservice2 getInstance() throws IOException {
    	if(service4==null) {
    		service4=new Subserviceimpl();
    	}
    	return service4;
    }
	
	Subrepo2 subRepository = Subrepoimpl.getInstance();
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		return subRepository.addSubscription(subscription);
	}

	@Override
	public String updateSubscription(String id,Subscription subscription) {
		// TODO Auto-generated method stub
		return subRepository.updateSubscription(id,subscription);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws LocationNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
		return subRepository.getSubscriptionById(id);
	}

	@Override
	public Optional<ArrayList<Subscription>> getAllSubscription() throws LocationNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
		return this.subRepository.getAllSubscription();
	}

	@Override
	public String deleteSubscription(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		return subRepository.deleteSubscription(id);
	}

}
