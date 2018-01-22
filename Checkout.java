import java.util.Vector;

public class Checkout {
	
	public Vector<Candy> candies= new Vector<Candy> (0,1);                                          //Here we instantiate a vector for the object candy//we can directly create the vector for dessert item instead of the individual objects.
	public Vector<Cookie> cookies= new Vector<Cookie> (0,1);                                        //Here we instantiate a vector for the object cookie
	public Vector<IceCream> iceCream= new Vector<IceCream> (0,1);                                   //Here we instantiate a vector for the object Ice cream
	public Vector<Sundae> Sundaes= new Vector<Sundae> (0,1);                                        //Here we instantiate a vector for the object Sundae
	
	int e=0,t=0,totalNumberOfItems=0;
	
	public Checkout(){
		
	}	
	
	public void clear(){                                                                       //Here we first clear the global parameters(checkout class) and the vectors.
		candies.clear();
		cookies.clear();
		iceCream.clear();
		Sundaes.clear();
		e=0;
		t=0;
		totalNumberOfItems=0;
		
	}
	 
	public void enterItem(Candy item){                                                                    //To the vectors created, we add their respective objects
		candies.addElement( item );
	}   
	
	public void enterItem(Cookie item){
		cookies.addElement(item);
	}
	
	public void enterItem(IceCream item){
		iceCream.addElement(item);
	}
	
	public void enterItem(Sundae item){
		Sundaes.addElement(item);
	}
	
	public int numberOfItems(){                                                                           //Here we try to find out the total number of items at the checkout.
		totalNumberOfItems=candies.size()+ cookies.size() + iceCream.size() + Sundaes.size();
		return totalNumberOfItems;
	}
   public java.lang.String toString(){                                                                   //To print the bill, we overload the toString() method of java.lang.String class
	   String k="";
	   int totalTax=0;
	   
	   int totalCost=totalCost();
	   
	   totalTax = (int) Math.round((totalCost*DessertShoppe.TAX_RATE)/100);
	   
	    System.out.println("Number of items:     " +(candies.capacity()+cookies.capacity()+iceCream.capacity()+Sundaes.capacity()));
	    System.out.println("Total cost:          " +totalCost +"\n\n");
	    System.out.println("Total tax:           " +totalTax +"\n\n");
	    System.out.println("Cost + Tax:          " +(totalTax+totalCost)+"\n\n");
	    
	    System.out.println("      " +DessertShoppe.STORE_NAME);
	    System.out.println("      --------------------");

	    
	    for(int i =0; i<candies.capacity() ;i++){
	    	System.out.println(candies.elementAt(i).getPounds() +"lbs " + DessertShoppe.cents2dollarsAndCents(candies.elementAt(i).getPrice()) +"/lbs");
	    	System.out.println(candies.elementAt(i).getName() +"\n\n"  +DessertShoppe.cents2dollarsAndCents(+candies.elementAt(i).getCost()));
	        }
	    for(int i =0; i<iceCream.capacity() ;i++){
	    	System.out.println(iceCream.elementAt(i).getName() +"\n\n" +DessertShoppe.cents2dollarsAndCents(iceCream.elementAt(i).getCost()));
	        }
	    for(int i =0; i<Sundaes.capacity() ;i++){
	    	System.out.println(Sundaes.elementAt(i).getName()+"\n\n"+"Choice of Topping");
	    	System.out.println(Sundaes.elementAt(i).getTopping() +"\n\n" +DessertShoppe.cents2dollarsAndCents(Sundaes.elementAt(i).getCost()));
	        }
	    for(int i =0; i<cookies.capacity() ;i++){
	    	System.out.println(cookies.elementAt(i).getNumber() +" at " + DessertShoppe.cents2dollarsAndCents(cookies.elementAt(i).getPrice()) +"/dozen");
	    	System.out.println(cookies.elementAt(i).getName() +"\n\n" +DessertShoppe.cents2dollarsAndCents(cookies.elementAt(i).getCost()));
	        }
	    System.out.println("Tax" +"\t" +"\t" +"\t" +DessertShoppe.cents2dollarsAndCents(totalTax));
	    System.out.println("Total Cost" +"\t" +"\t" +DessertShoppe.cents2dollarsAndCents(totalTax+totalCost));
		
	    return k;			
	}
   
   public int totalCost(){                                                                                       //Using this class, we calculate the total cost of all the objects
	   int candiesCost=0, cookiesCost=0, iceCreamsCost=0, sundaesCost=0;
	   int totalCost=0,totalTax=0,candiesSize=candies.size(),cookiesSize=cookies.size(),iceCreamSize=iceCream.size(),sundaesSize=Sundaes.size();
	   
	   for(int i=0; i<candiesSize; i++){
		   candiesCost += candies.elementAt(i).getCost();
	   }
	   for(int i=0; i<cookiesSize; i++){
		   cookiesCost += cookies.elementAt(i).getCost();
	   }
	   for(int i=0; i<iceCreamSize; i++){
		   iceCreamsCost += iceCream.elementAt(i).getCost();
	   }
	   for(int i=0; i<sundaesSize ; i++){
		   sundaesCost +=Sundaes.elementAt(i).getCost();
	   }
	   
	   totalCost= candiesCost + cookiesCost + iceCreamsCost + sundaesCost;
	   return totalCost;
   }
	
   public int totalTax(){                                                                                            //Total tax calculation
	   double w= (totalCost()*DessertShoppe.TAX_RATE)/100;
	   return (int) Math.round(w);
   }
}
