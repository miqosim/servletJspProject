package com.synisys.training.beans;

import com.synisys.training.Holder;
import com.synisys.training.entities.Currency;
import com.synisys.training.entities.Project;
import com.synisys.training.entities.Sector;
import com.synisys.training.entities.Subsector;

import java.util.ArrayList;
import java.util.List;

public class DataBean {
	private List<Project> projects;
	private List<Currency> currencies;
	private List<Sector> sectors;
	private List<Subsector> subSectors;

	public List<Project> getProjects() {
		if (projects == null) {
			projects = new ArrayList<>(Holder.getProjects());
		}
		return projects;
	}

	public List<Currency> getCurrencies() {
		if (currencies == null) {
			currencies = new ArrayList<>(Holder.getCurrencies());
		}
		return currencies;
	}

	public List<Sector> getSectors() {
		if (sectors == null) {
			sectors = new ArrayList<>(Holder.getSectors());
		}
		return sectors;
	}

	public List<Subsector> getSubSectors() {
		if (subSectors == null) {
			subSectors = new ArrayList<>(Holder.getSubsectors());
		}
		return subSectors;
	}
}
