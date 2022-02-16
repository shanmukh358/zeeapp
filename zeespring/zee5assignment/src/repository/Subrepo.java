package repository;

import java.util.HashMap;
import java.util.Map;

import dto.Subscription;

public class Subrepo {
	   private Subscription[] subscriptions=new Subscription[10];
	   private static int count=-1;
	   private Subrepo() {
		// TODO Auto-generated constructor stub
	  }
	   public Subscription[] getAllSubscription() {
		   return subscriptions;
	   }
	   
	   
	   //update subscription
       public String updateSubscription(String id) {
    	   for(Subscription subscription:subscriptions) {
  			 if(subscription.getId().equals(id)) {
  				 subscription.setStatus("InActive");
  			 }
	      }
    	   return "Updated";
       }
	   
	   //user details based on id
	 public Subscription getSubscriptionById(String id) {
		 //we need to traverse the array
		 for(Subscription subscription:subscriptions) {
			 if(subscription.getId().equals(id)) {
				 return subscription;
			 }
			 
		 }
		return null;
	 }
	   //add a new Subscription
	   public String addSubscription(Subscription subscription) {
		   
		   if(count==subscriptions.length-1) {
			   //array is full so we should go for dynamically increasing size of array.
			   Subscription temp[]=new Subscription[subscriptions.length*2];
			   System.arraycopy(subscriptions,0, temp, 0,subscriptions.length);
			   subscriptions=temp;
			   subscriptions[++count]=subscription;
			   return "success";
		   }
		   subscriptions[++count]=subscription;
		   return "success";
		   
		}
	   
	 //delete Subscription
	   public String deleteSubscription(String id) {
		   Subscription temp[]=new Subscription[subscriptions.length-1];
		   int index=0;
		   for(Subscription subscription:subscriptions) {
				 if(subscription.getId().equals(id)) {
					 break;
				 }
				 index++;
		   }
		   int rem=subscriptions.length-(index+1);
		   System.arraycopy(subscriptions,0, temp, 0,index);
		   System.arraycopy(subscriptions,index+1, temp, index,rem);
		   subscriptions=temp;
		   return "Deleted";
		   
	   }
	   
		   
	   
	  private static Subrepo repository1=null;
	   //this would be static only one copy.
	    public static Subrepo getInstance() {
	  	  //Because of static it becomes object independent.
	  	  if(repository1==null)
	  	   repository1=new Subrepo();
	  	  return repository1;
	    }  
}
