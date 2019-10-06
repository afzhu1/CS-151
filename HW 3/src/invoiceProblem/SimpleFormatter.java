package invoiceProblem;
import java.util.HashMap; 

/**
A simple invoice formatter.
*/
public class SimpleFormatter implements InvoiceFormatter
{
	HashMap<LineItem, Integer> items;
	
	public SimpleFormatter() {
		 items  = new HashMap<>();
	}
	
public String formatHeader()
{
   total = 0;
   return "     I N V O I C E\n\n\n";
}

public String formatLineItem(LineItem item)
{
	Integer count = items.get(item);
   total += item.getPrice();
  

   
   if (count == null) { 
	   items.put(item, 1);
	   
   } else { 
	   items.put(item, count + 1);
   }
   
   
	   return (String.format("%s: $%.2f    x%d  \n",item.toString(),item.getPrice(), items.get(item)));
    
   }


public void update(LineItem item)
{
	Integer count = items.get(item);
   total += item.getPrice();
  

   
   if (count == null) { 
	   items.put(item, 1);
	   
   } else { 
	   items.put(item, count + 1);
   }
   
   
    
   }



public String formatFooter()
{
   return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
}

private double total;
}
