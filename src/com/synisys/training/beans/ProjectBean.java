package com.synisys.training.beans;

import com.synisys.training.Holder;
import com.synisys.training.entities.Project;
import com.synisys.training.entities.Subsector;

import java.util.Set;

public class ProjectBean {

	private static Project project;

	public int getSectorId() {
		Set<Subsector> subsectors = Holder.getSubsectors();
		for (Subsector s : subsectors) {
			if (s.getId() == project.getSubSectorId()) {
				return s.getSectorId();
			}
		}
		return 0;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project p) {
		project = p;
	}
}
