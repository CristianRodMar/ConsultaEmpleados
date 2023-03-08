package controlador;

import dao.DaoEmployee;
import datos.Employee;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    @Resource(name="employees")
    DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String busquedaEmpleado = request.getParameter("busquedaEmpleado");
        try {
            List<Employee> listaEmpleados = DaoEmployee.getEmpleesByFirstName(busquedaEmpleado, dataSource.getConnection());
            request.setAttribute("listaEmpleados", listaEmpleados);
            request.setAttribute("busquedaEmpleado", busquedaEmpleado);
            request.getRequestDispatcher("vistafinal.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("vistafinal.jsp").forward(request, response);
        } finally {

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
