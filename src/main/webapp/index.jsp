<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/style.css" rel="stylesheet" type="text/css"/>
        <title>Buscar empleado</title>
    </head>
    <body>
        <div class="container">
            <form method="get" action="ServletControlador">
                <h1>Buscar empleado:</h1>
                <input type="text"  name="busquedaEmpleado" required/>
                <input class="submitButton" type="submit" value="Buscar"/>
            </form>
        </div>
    </body>
</html>
