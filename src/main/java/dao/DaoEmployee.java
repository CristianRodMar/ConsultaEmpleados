package dao;

import datos.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class DaoEmployee {

    public static List<Employee> getEmpleesByFirstName(String firstName, Connection con) throws SQLException, Exception{
            ResultSet rs = null;
            String query = "select employees.emp_no, employees.first_name, employees.last_name, employees.gender, max(salaries.salary) salary from employees join salaries on employees.emp_no = salaries.emp_no where upper(employees.first_name) like upper(?) group by employees.emp_no limit 30";
            PreparedStatement ps = null;
            List<Employee> listaEmpleados = new ArrayList();

            try {
                ps = con.prepareStatement(query);
                ps.setString(1, "%" + firstName + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    Employee empleado = new Employee();
                    empleado.setEmpNo(rs.getInt("emp_no"));
                    empleado.setFirstName(rs.getString("first_name"));
                    empleado.setLastName(rs.getString("last_name"));
                    empleado.setGender(rs.getString("gender"));
                    empleado.setSalary(rs.getInt("salary"));
                    listaEmpleados.add(empleado);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            return listaEmpleados;
    }
    
}
