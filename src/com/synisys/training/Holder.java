package com.synisys.training;

import com.synisys.training.entities.Currency;
import com.synisys.training.entities.Project;
import com.synisys.training.entities.Sector;
import com.synisys.training.entities.Subsector;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Holder implements Serializable {
	private final static Set<Currency> currencies;
	private final static Set<Sector> sectors;
	private final static Set<Subsector> subsectors;

	public static Set<Project> projects = new HashSet<>();

	private static int projectId = 0;

	static {
		Set<Currency> currencySet = new HashSet<>();
		currencySet.add(new Currency(1, "USD"));
		currencySet.add(new Currency(2, "AMD"));
		currencySet.add(new Currency(3, "RUB"));
		currencySet.add(new Currency(4, "EUR"));
		currencies = Collections.unmodifiableSet(currencySet);

		Set<Sector> sectorSet = new HashSet<>();
		sectorSet.add(new Sector(1, "Sector 1"));
		sectorSet.add(new Sector(2, "Sector 2"));
		sectorSet.add(new Sector(3, "Sector 3"));
		sectorSet.add(new Sector(4, "Sector 4"));
		sectors = Collections.unmodifiableSet(sectorSet);

		Set<Subsector> subsectorSet = new HashSet<>();
		subsectorSet.add(new Subsector(1, "Subsector 1.1", 1));
		subsectorSet.add(new Subsector(2, "Subsector 1.2", 1));
		subsectorSet.add(new Subsector(3, "Subsector 3.1", 3));
		subsectorSet.add(new Subsector(4, "Subsector 4.1", 4));
		subsectorSet.add(new Subsector(5, "Subsector 4.2", 4));
		subsectorSet.add(new Subsector(6, "Subsector 2.1", 2));
		subsectors = Collections.unmodifiableSet(subsectorSet);

		projects.add(new Project(++projectId, "Project 1",
				"Description 1", 20000, 2, 4));
		projects.add(new Project(++projectId, "Project 2",
				"Description 2", 24100, 4, 1));
		projects.add(new Project(++projectId, "Project 3",
				"Description 3", 20800, 1, 3));
		projects.add(new Project(++projectId, "Project 4",
				"Description 4", 20000, 3, 2));
	}

	public Holder() {}

	public static Set<Currency> getCurrencies() {
		return currencies;
	}

	public static Set<Sector> getSectors() {
		return sectors;
	}

	public static Set<Subsector> getSubsectors() {
		return subsectors;
	}

	public static Set<Project> getProjects() {
		return projects;
	}

	public static boolean deleteProject(int id) {
		return projects.removeIf((project -> project.getId() == id));
	}

	public static boolean addProject(Project pr){
		return projects.add(pr);
	}

	public static int getProjectId() {
		return ++projectId;
	}
}
