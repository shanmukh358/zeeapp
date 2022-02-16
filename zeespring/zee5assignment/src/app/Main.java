package app;



import Serviceimpl.Movieserviceimpl;
import Serviceimpl.Seriesserviceimpl;
import Serviceimpl.Subserviceimpl;
import app.Exception.InvalidAmountException;
import app.Exception.LocationNotFoundException;
import app.Exception.NameNotFoundException;
import dto.Movie;
import dto.Series;
import dto.Subscription;
import service.Movieservice;
import service.Movieservice2;
import service.Seriesservice;
import service.Seriesservice2;
import service.Subservice;
import service.Subservice2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Subservice2 service1=Subserviceimpl.getInstance();
       Movieservice2 service2=Movieserviceimpl.getInstance();
       Seriesservice2 service3=Seriesserviceimpl.getInstance();
       
	    for(int i=1;i<=10;i++) {
	      Subscription subscription2=new Subscription();
	      try {
			subscription2.setId("sm03"+i);
		} catch (LocationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      subscription2.setType("premium"+i);
	      subscription2.setDop("05-08-2021"+i);
	      subscription2.setStatus("Active"+i);
	      subscription2.setCountry("India"+i);
	      try {
			subscription2.setPayAmount("499");
		} catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      subscription2.setPaymentmode("UPI"+i);
	      subscription2.setAutorenewal("INActive"+i);
	      subscription2.setDoe("04-08-2022"+i);
	      String result=service1.addSubscription(subscription2);
	      System.out.println(result);
	    
	    }
	    for(int i=1;i<=10;i++) {
		      Movie movie2=new Movie();
		      try {
				movie2.setMid("m003"+i);
			} catch (LocationNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      movie2.setMcat("Action"+i);
		      movie2.setMdor("09-08-2021"+i);
		      try {
				movie2.setMname("SLN"+i);
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      movie2.setMlanguage("Telugu"+i);
		      movie2.setMlength("2hrs"+i);
		      movie2.setMtrailer("www.youtube.com"+i);
		      movie2.setMcast("hero"+i);
		      String result=service2.addMovie(movie2);
		      System.out.println(result);
		    
		    }
	    for(int i=1;i<=10;i++) {
	    	  Series series2=new Series();
	    	  try {
				series2.setSid("s003"+i);
			} catch (LocationNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  series2.setScat("comedy"+i);
	    	  series2.setSdor("26-04-2021"+i);
	    	  try {
				series2.setSname("Baker&Beauty"+i);
			} catch (NameNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  series2.setSlanguage("Telugu"+i);
	    	  series2.setSlength("1hrs"+i);
	    	  series2.setStrailer("www.youtube.com"+i);
	    	  series2.setScast("heroine"+i);
		      String result=service3.addSeries(series2);
		      System.out.println(result);
		    
		    }
	    
	    //subscription
	    for(Subscription subscription3:service1.getAllSubscription()) {
	    	if(subscription3!=null)
	    	 System.out.println(subscription3);
	    }
	    System.out.println(service1.updateSubscription("sm031"));
	    
	    try {
	    	System.out.println(service1.getSubscriptionById("sm031"));
		    System.out.println(service1.deleteSubscription("sm031"));
			System.out.println(service1.getSubscriptionById("sm031"));
		} catch (LocationNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    System.out.println(service1.getAllSubscription());
	    
	    
	    //movie
	    for(Movie movie3:service2.getAllMovie()) {
	    	if(movie3!=null)
	    	 System.out.println(movie3);
	    }
	    System.out.println(service2.updateMovie("m0031"));
	    try {
			System.out.println(service2.getMovieById("m0031"));
			System.out.println(service2.deleteMovieById("m0031"));
			System.out.println(service2.getMovieById("m0031"));
		} catch (LocationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(service2.getAllMovie());
	    
	    
	    
	    //series
	    for(Series series3:service3.getAllSeries()) {
	    	if(series3!=null)
	    	 System.out.println(series3);
	    }
	    System.out.println(service3.updateSeries("s0031"));
	    try {
			System.out.println(service3.getSeriesById("s0031"));
			System.out.println(service3.deleteSeriesById("s0031"));
			System.out.println(service3.getSeriesById("s0031"));
		} catch (LocationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println(service3.getAllSeries());
	    
	   
	   
	}

}
