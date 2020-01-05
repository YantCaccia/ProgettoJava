package utils;

import esterno.Cliente;

public class ClienteByNameComparator implements Comparator<Cliente> {
	public int compare(Cliente c1, Cliente c2) {
		return c1.getNome().compareTo(c2.getNome());
	}
}
