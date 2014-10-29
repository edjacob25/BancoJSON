<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang ='es'>
	<head>
		<script src="js.js"></script>
		<title>Banco</title>
		
	</head>

	<body>
		<div class= "header">
			
		</div>	
		
		<section class="title">
		 
			<h1>Banco</h1>	
		</section>

		<section class="form">
				Número de Cuenta: <input type='text' id= 'nocta' value=''> <br>
				Cliente: <input type='text' id= 'nombre' value=''><br>
				Tipo de Cuenta: <input type='text' id= 'tipo' value=''><br>
				Saldo: <input type='text' id= 'saldo' value=''><br>
				<br>
				<input type='button' id= 'crear' value='Crear Cuenta' onclick="crearCuenta()">
				<input type='button' id= 'consultaGeneral' value='Consulta General' onclick="consultarGeneral()">
				<input type='button' id= 'consultaNocta' value='Consulta por número' onclick="consultarNocta()">
				<input type='button' id= 'consultaTipo' value='Consulta por Tipo' onclick="consultarTipo()">
				<input type='button' id= 'retiro' value='Retirar' onclick="retirar()">
				<input type='button' id= 'deposito' value='Depositar' onclick="depositar()">
		</section>

	</body>
</html>