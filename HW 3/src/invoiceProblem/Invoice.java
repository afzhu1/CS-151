package invoiceProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * An invoice for a sale, consisting of line items.
 */
public class Invoice {

	/**
	 * Constructs a blank invoice.
	 */
	public Invoice() {
		items = new ArrayList<>();
		listeners = new ArrayList<>();
		itemMap = new HashMap<>();
	}

	/**
	 * Adds an item to the invoice.
	 * 
	 * @param item the item to add
	 */
	public void addItem(LineItem item) {

		items.add(item);
		Integer count = itemMap.get(item);

		if (count == null) {
			itemMap.put(item, 1);

		} else {
			itemMap.replace(item, count + 1);
		}

		// Notify all observers of the change to the invoice
		ChangeEvent event = new ChangeEvent(this);
		for (ChangeListener listener : listeners)
			listener.stateChanged(event);
	}

	/**
	 * Adds a change listener to the invoice.
	 * 
	 * @param listener the change listener to add
	 */
	public void addChangeListener(ChangeListener listener) {
		listeners.add(listener);
	}

	/**
	 * Gets an iterator that iterates through the items.
	 * 
	 * @return an iterator for the items
	 */
	public Iterator<LineItem> getItems() {
		return new Iterator<LineItem>() {
			public boolean hasNext() {
				return current < items.size();
			}

			public LineItem next() {
				return items.get(current++);
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}

			private int current = 0;
		};
	}

	public String format(InvoiceFormatter formatter) {

		ArrayList<String> printed = new ArrayList<>();
		String r = formatter.formatHeader();
		int count;

		Iterator<LineItem> iter = getItems();
		while (iter.hasNext()) {
			LineItem current = iter.next();
			count = itemMap.get(current);
			if (printed.contains(current.toString())) { // if item has already been printed, just update
				formatter.formatLineItem(current, count);
			} else { // else add the item to the final string
				r += formatter.formatLineItem(current, count);
				printed.add(current.toString());

			}

		}
		return r + formatter.formatFooter();
	}

	private ArrayList<LineItem> items;
	private ArrayList<ChangeListener> listeners;
	private HashMap<LineItem, Integer> itemMap;
}
