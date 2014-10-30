/*--- Declaración de variables globales ---*/
var xhr;

/*--- Inicializando objeto XMLHttpRequest ---*/
function iniciarObjetoXmlHttpRequest()
{
  if((window.XMLHttpRequest) || ((typeof XMLHttpRequest) != undefined))
  {
      xhr = new XMLHttpRequest();
  }
  else
  {
      xhr = new ActiveXObject(Microsoft.XMLHTTP);
  }
}

/*--- Funcion para desplegar datos en formato de tabla ----*/

function obtenerDatos()
{	  		
  if(xhr.readyState==4) // && xhr.status==200)
  {
		var datosJSon = eval("("+xhr.responseText+")");

     	var html="";
     	if (datosJSon[0].nocta != undefined) {
	      	html = html + "<table border='1px'>";
	      	for(var i=0; i<datosJSon.length; i++)
	      	{
	          	html = html + "<tr>";
	          		html = html + "<td>"+datosJSon[i].nocta+"</td>";
	          		html = html + "<td>"+datosJSon[i].nombre+"</td>";
	          		html = html + "<td>"+datosJSon[i].tipo+"</td>";
	          		html = html + "<td>"+datosJSon[i].saldo+"</td>";
	          	html = html + "</tr>";
	        }
        	html = html + "</table>";
    	}
    	else{
    		html= datosJSon[0].message;
    	}
      

      document.getElementById("resultado").innerHTML="<i>"+html+"</i>";
  }
  else
  	  document.getElementById("resultado").innerHTML="<i>"+"Obteniendo datos..."+"</i>";
}

function capturarDatos(op)
{
  		var datos="";
  		
			  //alert("Algun campo esta vacio...");	  			
	  			if (op=="todos")
	  			{

  					if(document.getElementById("nocta").value=="" || document.getElementById("nombre").value=="" || document.getElementById("tipo").value=="" || 
  		   			document.getElementById("saldo").value=="")
  					{
  						 document.getElementById("resultado").innerHTML="<i>Algun campo esta vacio...</i>";
  					}
  					else
  					{
  						var nocta = document.getElementById("nocta").value;
  						var saldo = document.getElementById("saldo").value;
  						var nombre     = document.getElementById("nombre").value;
	  					var tipo      = document.getElementById("tipo").value;
  						if(parseInt(nocta) >= 0 && parseInt(saldo) >= 0 )
	  						datos = "datos="+nocta+"_"+nombre+"_"+tipo+"_"+saldo;
	  					else
	  						document.getElementById("resultado").innerHTML="La cuenta y el saldo deben ser numerico..";
	  				}
	  			}
	  			if (op=="nocta") 
	  			{
	  			
					var nocta = document.getElementById("nocta").value;
					if(parseInt(nocta) >= 0)
						datos= "datos="+nocta;
					else
	  					document.getElementById("resultado").innerHTML="Hay un error en el número de cuenta";
	  					
  				
	  			}
	  			if (op=="tipo") 
	  			{	if(document.getElementById('tipo').value!="")
	  				{
	  					var tipo      = document.getElementById("tipo").value;
	  					datos= "datos="+tipo;
	  				}
	  				else
	  				{
	  					document.getElementById("resultado").innerHTML="Hay un error en el tipo de cuenta";
	  				}
	  			}
  		
  		return datos;
}


		/*---- Comienzan funciones independientes ----*/


		/*--- comienza Consulta General*/
		function establecerConexionConsultaGeneral()
		{	
		      xhr.onreadystatechange=obtenerDatos;
		      xhr.open("GET","controller.jsp?bConsultaGeneral=true",true);
		      xhr.send(null);
		}

		function consultarGeneral()
		{  		  		
		      // 1. Crear el objeto XMLHttpRequest
		      iniciarObjetoXmlHttpRequest();  

		      // 2. Establecer conexion con el server Http (Tomcat, WLS, Web Sphere)
		      establecerConexionConsultaGeneral();
		}
		/*--- Termina Consulta General ---*/

		/*--- Comienza Captura ---*/
		function establecerConexionCaptura(datos)
		{
			xhr.onreadystatechange=obtenerDatos;
		    xhr.open("GET","controller.jsp?bCapturar=true&"+datos,true);
		    xhr.send(null);
		}

		function crearCuenta()
		{
			iniciarObjetoXmlHttpRequest();
			var datos = capturarDatos("todos");
			if (datos!="")
				establecerConexionCaptura(datos);
		}

		
		/*--- Termina Captura ---*/


		/*--- Comienza Consulta por número de cuenta ---*/
		function establecerConexionConsultaNocta(datos)
		{
			xhr.onreadystatechange=obtenerDatos;
		    xhr.open("GET","controller.jsp?bConsultarNocta=true&"+datos,true);
		    xhr.send(null);
		}


		function consultarNocta()
		{
			iniciarObjetoXmlHttpRequest();
			var datos = capturarDatos("nocta");
			if (datos!="")
				establecerConexionConsultaNocta(datos);
		}

		
		function establecerConexionConsultaTipo(datos)
		{
			xhr.onreadystatechange=obtenerDatos;
		    xhr.open("GET","controller.jsp?bConsultarTipo=true&"+datos,true);
		    xhr.send(null);
		}


		function consultarTipo()
		{
			iniciarObjetoXmlHttpRequest();
			var datos = capturarDatos("tipo");
			if (datos!="")
				establecerConexionConsultaTipo(datos);
		}