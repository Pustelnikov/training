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

@WebServlet("/calc")
public class CalculatingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String[] checked = request.getParameterValues("checked");
		if (checked != null) {
			HomeDeviceService service = new HomeDeviceService();
			HomeDeviceDao dao = new HomeDeviceDaoImpl();
			List<HomeDevice> devices = dao.getDevices();
            for (String s : checked) {
                int index = Integer.parseInt(s);
                devices.get(index).setStatus(true);
            }
			Integer sumPowerOfTurnedOnDevices = service.calculatePowerOfTurnedOnDevices(devices);
			request.setAttribute("devices", devices);
			request.setAttribute("sumPower", sumPowerOfTurnedOnDevices);
			request.getRequestDispatcher("/jsp/calc.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/jsp/start.jsp").forward(request, response);
		}
	}
}
