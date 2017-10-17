package com.synisys.training.entities;

public abstract class Classifier extends Entity{
	private final String name;
	public String getName() {
		return name;
	}

	public Classifier(Integer id, String name) {
		super(id);
		this.name = name;
	}
}

