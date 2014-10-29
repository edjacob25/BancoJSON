
<head>
	<script src="js.js"></script>
	<meta charset="utf-8">

	<title>Banco</title>
	
</head>

<body>
	<div class= "header">
		
	</div>	
	
	<section class="title">
	 
		<h1>Banco</h1>	
	</section>

	<section class="form">
			<input type='text' id= 'nocta' value=''>
			<input type='text' id= 'nombre' value=''>
			<input type='text' id= 'tipo' value=''>
			<input type='text' id= 'saldo' value=''>
			<br><br>
			<input type='button' id= 'crear' value='Crear Cuenta' onclick="crearCuenta()">
			<input type='button' id= 'consultaGeneral' value='Consulta General' onclick="consultarGeneral()">
			<input type='button' id= 'consultaNocta' value='Consulta por número' onclick="consultarNocta()">
			<input type='button' id= 'consultaTipo' value='Consulta por Tipo' onclick="consultarTipo()">
			<input type='button' id= 'retiro' value='Retirar' onclick="retirar()">
			<input type='button' id= 'deposito' value='Depositar' onclick="depositar()">
	</section>

</body>
