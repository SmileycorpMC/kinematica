package net.smileycorp.kinematica.api.metal;

class MetalStack {
	final String name;
	final int amount;
	
	public MetalStack(String name, int amount) {
		this.name=name;
		this.amount=amount;
	}
		
	public int getAmount() {
		return amount;
	}
	
	public String getMetal() {
		return name;
	}
	
}
