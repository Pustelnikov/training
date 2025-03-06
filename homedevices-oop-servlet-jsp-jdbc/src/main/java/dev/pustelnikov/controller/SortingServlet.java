package dev.pustelnikov.controller;

import java.io.IOException;
import java.util.List;
import dev.pustelnikov.dao.HomeDeviceDao;
import dev.pustelnikov.dao.impl.HomeDeviceDaoImpl;
import dev.pustelnikov.model.HomeDevice;
import dev.pustelnikov.service.HomeDeviceService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sort")
public class SortingServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HomeDeviceService service = new HomeDeviceService();
		HomeDeviceDao dao = new HomeDeviceDaoImpl();
		List<HomeDevice> sourceListOfDevices = dao.getDevices();
		List<HomeDevice> devices = service.sortByPower(sourceListOfDevices);
		request.setAttribute("devices", devices);
		request.getRequestDispatcher("/jsp/sort.jsp").forward(request, response);
	}
}
