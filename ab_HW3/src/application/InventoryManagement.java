package application;
/**
 * @author Itai Cohen
 * @version 3 - SearchByKey added
 * @version 4 - removeInstrument added
*/
import java.util.ArrayList;

public interface InventoryManagement<E extends MusicalInstrument> {

	void addAllStringInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> to);

	void addAllWindInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> to);

	void SortByBrandAndPrice(ArrayList<E> list);

	int binnarySearchByBrandAndPrice(ArrayList<E> src, String brand, Number price);
	
	ArrayList<E> SearchByKey(ArrayList<E> src, String key);
	
	void addInstrument(ArrayList<E> src, E m);

	boolean removeInstrument(ArrayList<E> src, String brand, Number price);
	
	String removeAll(ArrayList<E> src);
}
