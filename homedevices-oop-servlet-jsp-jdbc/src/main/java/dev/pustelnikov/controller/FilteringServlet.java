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

@WebServlet("/filt")
public class FilteringServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int from = Integer.parseInt(request.getParameter("from"));
		int to = Integer.parseInt(request.getParameter("to"));
		HomeDeviceService service = new HomeDeviceService();
		HomeDeviceDao dao = new HomeDeviceDaoImpl();
		List<HomeDevice> sourceListOfDevices = dao.getDevices();
		List<HomeDevice> sortedByPowerDevices = service.sortByPower(sourceListOfDevices);
		List<HomeDevice> devices = service.filterByPowerRange(sortedByPowerDevices, from, to);
		request.setAttribute("from", from);
		request.setAttribute("to", to);
		request.setAttribute("devices", devices);
		request.getRequestDispatcher("/jsp/filt.jsp").forward(request, response);
	}
}
