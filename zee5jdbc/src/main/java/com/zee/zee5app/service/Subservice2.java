package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.LocationNotFoundException;
import com.zee.zee5app.dto.Subscription;



public interface Subservice2 {
	public String addSubscription(Subscription subscription);
	
	public Optional<Subscription> getSubscriptionById(String id) throws LocationNotFoundException, InvalidAmountException;
	public Optional<ArrayList<Subscription>> getAllSubscription() throws LocationNotFoundException, InvalidAmountException;
	public String deleteSubscription(String id) throws LocationNotFoundException;
	public String updateSubscription(String id, Subscription subscription);
}
