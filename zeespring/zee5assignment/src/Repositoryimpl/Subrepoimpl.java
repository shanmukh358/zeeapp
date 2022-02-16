package Repositoryimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import app.Exception.LocationNotFoundException;
import dto.Movie;
import dto.Series;
import dto.Subscription;
import repository.Subrepo2;

public class Subrepoimpl implements Subrepo2 {
	private List<Subscription> arraylist=new ArrayList<>();
   private Subrepoimpl() {
    	
    }
    private static Subrepo2 repository;
    public static Subrepo2 getInstance() {
    	if(repository==null) {
    		repository=new Subrepoimpl();
    	}
    	return repository;
    }
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		boolean result = this.arraylist.add(subscription);
		System.out.println(this.arraylist.size());
		if(result) {
			return "success";
		}
		return "fail";
	}

	@Override
	public String updateSubscription(String id) {
		// TODO Auto-generated method stub
		for (Subscription register1 : arraylist) {
			if(register1.getId().equals(id)) {
				register1.setStatus("Inactive");
			}
		}
		return "updated";
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
		for (Subscription subscription : arraylist) {
			if(subscription.getId().equals(id)) {
				return Optional.of(subscription);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<Subscription> getAllSubscription(){
		List<Subscription> arrlist=new ArrayList<Subscription>(arraylist);
		return arrlist;
	}

	@Override
	public String deleteSubscription(String id) throws LocationNotFoundException {
		// TODO Auto-generated method stub
     Optional<Subscription> optional = this.getSubscriptionById(id);
		
		if(optional.isPresent()) {
			// removal
			
			boolean result = arraylist.remove(optional.get());
			
			if(result) {
				return "success";
			}
			else
				return "fail";
		}
		return "fail";
	}
}


