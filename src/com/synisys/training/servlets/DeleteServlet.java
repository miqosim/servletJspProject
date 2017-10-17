package com.synisys.training.servlets;

import com.synisys.training.Holder;
import com.synisys.training.entities.Entity;
import com.synisys.training.filters.LoginFilter;

import java.io.IOException;

public class DeleteServlet
		extends javax.servlet.http.HttpServlet {

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {

		Holder.deleteProject(Integer.parseInt(request.getParameter(Entity.ID_KEY)));
		response.sendRedirect("/ProjectList.jsp?"
				+ LoginFilter.USERNAME_FIELD_NAME
				+ "="
				+ LoginFilter.USERNAME
				+ "&"
				+ LoginFilter.PASSWORD_FIELD_NAME
				+ "="
				+ LoginFilter.PASSWORD);
	}
}
