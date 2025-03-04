package dev.pustelnikov.controller;

import java.io.IOException;
import java.util.List;
import dev.pustelnikov.model.HomeDevice;
import dev.pustelnikov.service.HomeDeviceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HomeDeviceService service = new HomeDeviceService();
		List<HomeDevice> devices = service.getDevices();
		request.setAttribute("devices", devices);
		request.getRequestDispatcher("/jsp/actions.jsp").forward(request, response);
	}
}
