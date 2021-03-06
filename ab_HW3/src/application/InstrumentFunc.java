package application;
/**
 * @author Itai Cohen
 * @version 1
*/
public interface InstrumentFunc extends Cloneable, Comparable<MusicalInstrument> {

	Object clone() throws CloneNotSupportedException;
	
	int compareTo(MusicalInstrument o);

}
