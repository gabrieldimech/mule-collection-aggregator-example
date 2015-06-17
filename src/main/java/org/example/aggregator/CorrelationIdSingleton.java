package org.example.aggregator;

public class CorrelationIdSingleton {
	
	public CorrelationIdSingleton() {
		this.correlationId = java.util.UUID.randomUUID().toString();
	}

	private String correlationId;

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
	
	public void updateCorrelationId(){
		this.correlationId = java.util.UUID.randomUUID().toString();
	}

}
