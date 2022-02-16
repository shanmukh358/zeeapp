package service;

import dto.Subscription;
import lombok.Data;
import repository.Subrepo;

@Data
public class Subservice {
	private Subrepo repository1=Subrepo.getInstance();
	 //service is consuming the Repository
	 private Subservice() {
		// TODO Auto-generated constructor stub
	 }
	 //if we want to create that singleton object then we have to create it inside same class.
	 //and we have share reference with others.
	 //to do the same we have to declare a method.
	 
	  private static Subservice service1=null;
	 //this would be static only one copy.
	  public static Subservice getInstance() {
		  //Because of static it becomes object independent.
		  if(service1==null)
		   service1=new Subservice();
		  return service1;
	  }
	  public String updateSubscription(String id) {
		  return this.repository1.updateSubscription(id);
	  }
	  public String deleteSubscription(String id) {
		  return this.repository1.deleteSubscription(id);
	  }
	  public String addSubscription(Subscription subscription) {
		  //we need to consume repository
		  return this.repository1.addSubscription(subscription);
	  }
	  public Subscription getSubscription(String id) {
		  return repository1.getSubscriptionById(id);
	  }

	public Subscription[] getAllsubscription() {
		// TODO Auto-generated method stub
		return this.repository1.getAllSubscription();
	}

}
