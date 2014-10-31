<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "javax.swing.*" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Clientazo</title>
		<script src="js.js"></script>
	</head>

	<body>
		<%
			String datos = request.getParameter("datos");
			StringTokenizer st = new StringTokenizer(datos, "_");
			int nocta= Integer.parseInt(st.nextToken());
			String nombre= st.nextToken();
			String tipo= st.nextToken();
			int saldo= Integer.parseInt(st.nextToken());
		%>
		<div class="table">
			<table border="1px">
				<tr>
					<td>Cuenta: </td>
					<td><input type="text"  id = 'nocta' value = '<%= nocta %>' placeholder = '<%= nocta %>' readonly ></td>
				</tr>
				<tr>
					<td>Cliente: </td>
					<td><input type="text" id = 'nombre' value = '<%= nombre %>' placeholder = '<%= nombre %>' readonly ></td>
				</tr>
				<tr>
					<td>Tipo: </td>
					<td><input type="text" id = 'tipo' value = '<%= tipo %>' placeholder = '<%= tipo %>' readonly ></td>
				</tr>
				<tr>	
					<td>Saldo: </td>
					<td><input type="number" id = 'saldo' value = '<%= saldo %>'placeholder = '<%= saldo %>'></td>
				</tr>
			</table>
			<input type='button' id="bActualizarSaldo" value ='Actualizar' onclick="actualizarSaldo()">
			<input type='button' id="bRegresar" value ='Regresar' onclick="regresar()">
		</div>

		<div id ="resultado">
			
		</div>

	</body>

</html>