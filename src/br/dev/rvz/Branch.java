package br.dev.rvz;

import java.util.ArrayList;
import java.util.Optional;

public class Branch {
	private String name;
	private ArrayList<Customer> custormers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Customer> getCustormers() {
		return custormers;
	}

	public void setCustormers(ArrayList<Customer> custormers) {
		this.custormers = custormers;
	}
	
	public void addNewCustomer(String name, double initialValueTransction) {
		Customer customer = new Customer();
		customer.setName(name);
		customer.setTransctions(new ArrayList<Double>());
		customer.getTransctions().add(Double.valueOf(initialValueTransction));
		
		this.custormers.add(customer);
	}
	
	public void addNewTransactionByCustomerName(String name, double value) {
		Customer customer = searchCustomerByName(name);
		customer.getTransctions().add(Double.valueOf(value));
	}
	
	private Customer searchCustomerByName(String name) {
		Optional<Customer> optionalCustomer = Optional.empty();
		
		for (Customer customer : this.custormers) {
			if (customer.getName().equalsIgnoreCase(name)) {
				optionalCustomer = Optional.of(customer);
			}
		}
		
		if (optionalCustomer.isEmpty()) {
			throw new RuntimeException("Nenhum cliente com nome " + name + " foi encontrado na agência " + this.name);
		}
		
		return optionalCustomer.get();
	}
}
