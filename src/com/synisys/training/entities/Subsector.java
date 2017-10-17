package com.synisys.training.entities;

public class Subsector
		extends Classifier {
	private final int sectorId;

	public Subsector(int id, String name, int sectorId) {
		super(id, name);
		this.sectorId = sectorId;
	}

	public int getSectorId() {
		return sectorId;
	}
}
