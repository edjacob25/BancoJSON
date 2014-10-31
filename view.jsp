<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang ='es'>
	<head>
		<script src="js.js"></script>
		<link rel="stylesheet" type="text/css" href="main.css">
		<title>Clientazo</title>
	</head>

	<body>
		<div class= "header">
			
		</div>	
		
		<section class="title">
		 
			<h1>CLIENTAZO</h1>	
		</section>

		<section class="form">
				Número de Cuenta: <input type='text' id= 'nocta' value=''> <br>
				Cliente: <input type='text' id= 'nombre' value=''><br>
				Tipo de Cuenta: 
				<select id='tipo'>
					<option value='' selected>Selecciona</option>
					<option value='AHORRO'>Ahorro</option>
					<option value='CREDITO'>Crédito</option>
					<option value='HIPOTECA'>Hipoteca</option>
					<option value='INVERSION'>Inversión</option>
				</select><br>
				Saldo: <input type='text' id= 'saldo' value=''><br>
				<br>
				<input type='button' id= 'crear' value='Crear Cuenta' onclick="crearCuenta()">
				<input type='button' id= 'consultaGeneral' value='Consulta General' onclick="consultarGeneral()">
				<input type='button' id= 'consultaNocta' value='Consulta por número' onclick="consultarNocta()">
				<input type='button' id= 'consultaTipo' value='Consulta por Tipo' onclick="consultarTipo()">
				
		</section>

		<div id="resultado">
		</div>

	</body>
</html>