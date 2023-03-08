<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/final.css" rel="stylesheet" type="text/css"/>
        <title>Empleados</title>
    </head>
    <body>
        <a href="index.jsp">Volver</a>
        <h1>Listado de empleados que coinciden con: ${busquedaEmpleado}</h1>
        <c:if test="${!empty listaEmpleados}">
            <table>
                <tr>
                    <th>Nº Empleado</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Género</th>
                    <th>Salario</th>
                </tr>
                <c:forEach items="${listaEmpleados}" var="empleado">
                    <tr>
                        <td>${empleado.empNo}</td>
                        <td>${empleado.firstName}</td>
                        <td>${empleado.lastName}</td>
                        <td>${empleado.gender}</td>
                        <td>${empleado.salary}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${empty listaEmpleados}">
            <h3>No se han encontrado coincidencias</h3>
        </c:if>
    </body>
</html>
