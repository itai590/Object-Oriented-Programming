
/**
*Itai cohen
**version 2
 */
import java.util.ArrayList;

public interface InventoryManagement<E extends MusicalInstrument> {

	void addAllStringInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> to);

	void addAllWindInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> to);

	void SortByBrandAndPrice(ArrayList<E> list);

	int binnarySearchByBrandAndPrice(ArrayList<E> src, String brand, Number price);

	void addInstrument(ArrayList<E> src, E m);

	boolean removeInstrument(ArrayList<E> src, String brand, Number price);

	boolean removeAll(ArrayList<E> src);
}
