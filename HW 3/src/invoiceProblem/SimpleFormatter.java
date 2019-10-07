package invoiceProblem;
import java.util.HashMap; 

/**
A simple invoice formatter.
*/
public class SimpleFormatter implements InvoiceFormatter
{
	
	
	public SimpleFormatter() {
		// items  = new HashMap<>();
		// hammerCount = 0;
		// comboCount = 0;
	}
	
public String formatHeader()
{
   total = 0;
   hammerCount = 0;
	 comboCount = 0;
   return "     I N V O I C E\n\n\n";
}

public HashMap<LineItem, Integer> getHashmap(){
	return items;
}

public String formatLineItem(LineItem item)
{
	//Integer count = items.get(item);
   total += item.getPrice();
  if (item.toString)

   
   //if (count == null) { 
	//   items.put(item, 1);
	//   count = 1;

  // } else { 
	//   items.put(item, count + 1);
  // }
   
 //  System.out.println(count);   
   System.out.println(items.get(item));

	   return (String.format("%s: $%.2f    x%d  \n",item.toString(),item.getPrice(), items.get(item)));
    
   }


public void update(LineItem item)
{
	Integer count = items.get(item);
   total += item.getPrice();
  

   
  
	   items.put(item, count + 1);
   
   
 //  System.out.println(count);   
   System.out.println(items.get(item));
   }



public String formatFooter()
{
   return (String.format("\n\nTOTAL DUE: $%.2f\n", total));
}

private double total;
private HashMap<LineItem, Integer> items;
private int hammerCount;
private int comboCount;
}
