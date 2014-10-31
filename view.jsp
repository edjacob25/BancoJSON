<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang ='es'>
	<head>
		<script src="js.js"></script>
		<link rel="stylesheet" type="text/css" href="main.css">
		<link href='http://fonts.googleapis.com/css?family=Megrim' rel='stylesheet' type='text/css'>
		<link href='http://fonts.googleapis.com/css?family=Lato:300' rel='stylesheet' type='text/css'>

		<title>Clientazo</title>
	</head>

	<body>
		
		<section class="title">
		 
			<h1>BANCO CLIENTAZO</h1>	
		</section>
		<section class="nav">
			<input type='button' class="boton" id= 'crear' value='Crear Cuenta' onclick="crearCuenta()">
			<input type='button' class="boton" id= 'consultaGeneral' value='Consulta General' onclick="consultarGeneral()">
			<input type='button' class="boton" id= 'consultaNocta' value='Consulta por número' onclick="consultarNocta()">
			<input type='button' class="boton" id= 'consultaTipo' value='Consulta por Tipo' onclick="consultarTipo()">
		</section>

		<hr>

		<section class="form">
				<div class="etiqueta">Número de cuenta:</div>	 <input type='text' id= 'nocta' class="campo" value=''> <br>
				<div class="etiqueta">Cliente:</div> 			<input type='text' id= 'nombre' class="campo" value=''><br>
				<div class="etiqueta">Tipo de Cuenta:</div> 
				<select id='tipo' class="campo_select">
					<option value='' selected>Selecciona</option>
					<option value='AHORRO'>Ahorro</option>
					<option value='CREDITO'>Crédito</option>
					<option value='HIPOTECA'>Hipoteca</option>
					<option value='INVERSION'>Inversión</option>
				</select><br>
				<div class="etiqueta">Saldo:</div> 	<input type='text' id= 'saldo' class="campo" value=''><br>
				<br>
				
				
		</section>

		<section class= 'resultado'>
			<div id="resultado">
			</div>
		</section>

	</body>
</html>