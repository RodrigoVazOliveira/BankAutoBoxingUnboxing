package br.dev.rvz;

import java.util.ArrayList;
import java.util.Optional;

public class Bank {
	
	private String name;
	private ArrayList<Branch> branches;

	public Bank() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Branch> getBranches() {
		return branches;
	}

	public void setBranches(ArrayList<Branch> branches) {
		this.branches = branches;
	}
	
	public void addNewBranch(String name) {
		Branch branch = new Branch();
		branch.setName(name);
		branch.setCustormers(new ArrayList<Customer>());
		this.branches.add(branch);
	}
	
	public void addCustomerByBranch(String nameBranch, String nameCustomer, double initialValue) {
		Branch branch = findbranchByName(nameBranch);
		branch.addNewCustomer(nameCustomer, initialValue);
	}
	
	public void addTransactionByCusotmerByBranch(String customerName, String nameBranch, double value) {
		Branch branch = findbranchByName(nameBranch);
		branch.addNewTransactionByCustomerName(customerName, value);
	}
	
	private Branch findbranchByName(String name) {
		Optional<Branch> optionalBranch = Optional.empty();
		
		for (Branch branch : this.branches) {
			if (branch.getName().equalsIgnoreCase(name)) {
				optionalBranch = Optional.of(branch);
			}
		}
		
		if (optionalBranch.isEmpty()) {
			throw new RuntimeException("Nenhuma agencia com nome " + name + " foi localizada!");
		}
		
		return optionalBranch.get();
	}
}
