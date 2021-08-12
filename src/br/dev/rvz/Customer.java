package br.dev.rvz;

import java.util.ArrayList;

public class Customer {
	private String name;
	private ArrayList<Double> transctions;

	public Customer() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Double> getTransctions() {
		return transctions;
	}

	public void setTransctions(ArrayList<Double> transctions) {
		this.transctions = transctions;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", transctions=" + transctions + "]";
	}
}
