package service;

import java.util.List;
import java.util.Optional;

import app.Exception.LocationNotFoundException;
import dto.Subscription;

public interface Subservice2 {
	public String addSubscription(Subscription subscription);
	public String updateSubscription(String id);
	public Optional<Subscription> getSubscriptionById(String id) throws LocationNotFoundException;
	public List<Subscription> getAllSubscription();
	public String deleteSubscription(String id) throws LocationNotFoundException;
}
