package lab5;

import java.util.Comparator;

public class ComparatorCliente implements Comparator<Compra>{

	@Override
	public int compare(Compra o1, Compra o2) {
		return o1.getCliente().compareTo(o2.getCliente());
		
	}

}
