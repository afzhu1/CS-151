package invoiceProblem;

/**
 * A simple invoice formatter.
 */
public class SimpleFormatter implements InvoiceFormatter {

	public String formatHeader() {
		total = 0;

		String invoiceHeader = new String("<b><h1 style = 'color: red'; align = 'center' >"
										+ "<font size='+64'> " + "INVOICE" + "</font>"
										+ "</h1></b><br><br><br>");  
	return invoiceHeader;
	}

	public String formatLineItem(LineItem item, int count) {
		total += item.getPrice();

		String invoiceLineItem = new String ("<b><h1 style = 'color: black'; align = 'center' >"
				+ (String.format("-  %s: $%.2f    x%d  \n", item.toString(), item.getPrice()*count, count))
				+ "</h1></b><br><br><br>");
		 
		return invoiceLineItem;
	}

	public String formatFooter() {
		
		String invoiceFooter = new String ("<b><h1 style = 'color: green'; align = 'center' >"
				+ (String.format("\n\nTOTAL DUE: $%.2f\n", total))
				+ "</h1></b><br><br><br>");
		
		return invoiceFooter;
	}

	private double total;

}
