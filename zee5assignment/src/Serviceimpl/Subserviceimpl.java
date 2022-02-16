package Serviceimpl;

import java.util.Optional;

import java.util.List;
import Repositoryimpl.Subrepoimpl;
import app.Exception.LocationNotFoundException;
import dto.Subscription;
import repository.Subrepo2;

import service.Subservice2;

public class Subserviceimpl implements Subservice2 {
   private Subserviceimpl() {
		
	}
	private static Subservice2 service4;
	public static Subservice2 getInstance() {
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
	public String updateSubscription(String id) {
		// TODO Auto-generated method stub
		return subRepository.updateSubscription(id);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		return subRepository.getSubscriptionById(id);
	}

	@Override
	public List<Subscription> getAllSubscription() {
		// TODO Auto-generated method stub
		return this.subRepository.getAllSubscription();
	}

	@Override
	public String deleteSubscription(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		return subRepository.deleteSubscription(id);
	}

}
