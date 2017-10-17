package com.synisys.training.servlets;

import com.synisys.training.Holder;
import com.synisys.training.beans.ProjectBean;
import com.synisys.training.entities.Entity;
import com.synisys.training.entities.Project;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class EditServlet
		extends HttpServlet {

	public static final String TYPE_KEY = "com.synisys.training.type";
	public static final String OPERATION_TYPE_KEY = "com.synisys.training.operation_type";

	public static final String ADD_TYPE = "com.synisys.training.add";
	public static final String EDIT_TYPE = "com.synisys.training.edit";
	public static final String CLOSE_OPERATION_TYPE = "com.synisys.training.close";
	public static final String SAVE_OPERATION_TYPE = "com.synisys.training.save";
	public static final String GET_SUB_SECTORS_OPERATION_TYPE = "com.synisys.training.getSubSectors";

	@Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ProjectBean projectBean = new ProjectBean();
		int id;
		switch (req.getParameter(TYPE_KEY)) {
			case ADD_TYPE:
				id = Holder.getProjectId();
				projectBean.setProject(new Project(id, "Project " + id, "", 0, 1, 1));
				break;
			case EDIT_TYPE:
				id = Integer.valueOf(req.getParameter(Entity.ID_KEY));
				projectBean.setProject(
						new Project(Holder.getProjects().stream().filter(pr -> pr.getId() == id).findFirst().get()));
				break;
		}
		resp.sendRedirect("/Project.jsp");
	}

	@Override protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String opType = req.getParameter(OPERATION_TYPE_KEY);
		ProjectBean projectBean = new ProjectBean();
		switch (opType) {
			case CLOSE_OPERATION_TYPE:
				break;
			case SAVE_OPERATION_TYPE:
				Project newProject = new Project(Integer.valueOf(req.getParameter(Entity.ID_KEY)), req.getParameter(Project.TITLE_KEY),
						req.getParameter(Project.DESCRIPTION_KEY), Integer.valueOf(req.getParameter(Project.TOTAL_AMOUNT_KEY)),
						Integer.valueOf(req.getParameter(Project.CURRENCY_KEY)), Integer.valueOf(req.getParameter(Project.SUB_SECTOR_KEY)));
				if (!Holder.addProject(newProject)) {
					Holder.deleteProject(Integer.valueOf(req.getParameter(Entity.ID_KEY)));
					Holder.addProject(newProject);
				}
				break;
			case GET_SUB_SECTORS_OPERATION_TYPE:
				int sectorId = Integer.parseInt(req.getParameter(Project.SECTOR_KEY));
				String res = Holder.getSubsectors()
						.stream()
						.filter(ssc -> ssc.getSectorId() == sectorId)
						.map(ssc -> "{\"id\":\"" + ssc.getId() + "\",\"name\":\"" + ssc.getName() + "\"}")
						.collect(Collectors.joining(",.,"));
				resp.getWriter().write(res);
				break;
		}
		projectBean.setProject(null);
	}
}
