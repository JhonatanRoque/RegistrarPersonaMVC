<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de personas</h1>
        <!<!-- En el acction colocar el nombre del controlador, para este caso 
            es recibir.do (la extension.do no importa solo indica que es servlet)-->
        <form action="recibir.do" method="POST">
            DUI: <input type="text" name="txtDui" value="" /><br>
            Apellidos: <input type="text" name="txtApellidos" value="" /><br>
            Nombres: <input type="text" name="txtNombres" value="" /><br>
            <input type="submit" value="RegistrarNuevaPersona" />
        </form>
    </body>
</html>
