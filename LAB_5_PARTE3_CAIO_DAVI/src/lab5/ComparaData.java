package lab5;

import java.util.Comparator;

/**
 * Método comparator que faz a comparação de duas Strings de compra e leva em
 * conta a data da Compra para ser ordenada.
 * 
 * @author Caio Davi Pereira da Silva - 119110875
 *
 */
public class ComparaData implements Comparator<String> {

	/**
	 * Método compare que compara duas Strings e retorna qual deve vir primeiro em
	 * uma lista ordenada. Nesse caso o critério de ordenação é pela data, ou seja,
	 * quem é mais antigo vem primeiro
	 */
	@Override
	public int compare(String o1, String o2) {
		String data1 = o1.substring(0, 10);
		String data2 = o2.substring(0, 10);

		int ano1 = Integer.parseInt(data1.substring(6, 10));
		int ano2 = Integer.parseInt(data2.substring(6, 10));
		if (ano1 > ano2) {

			return 1;

		} else if (ano1 < ano2) {

			return -1;

		} else {
			int mes1 = Integer.parseInt(data1.substring(3, 5));
			int mes2 = Integer.parseInt(data2.substring(3, 5));

			if (mes1 > mes2) {

				return 1;
			} else if (mes1 < mes2) {

				return -1;
			} else {
				int dia1 = Integer.parseInt(data1.substring(0, 2));
				int dia2 = Integer.parseInt(data2.substring(0, 2));

				if (dia1 > dia2) {

					return 1;
				} else if (dia1 < dia2) {

					return -1;
				} else {
					return o1.substring(12).compareTo(o2.substring(12));
				}
			}
		}

	}

}
