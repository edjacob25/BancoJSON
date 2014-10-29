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
      	html = html + "<table border='1px'>";
      	for(var i=0; i<datosJSon.length; i++)
      	{
          	html = html + "<tr>";
          		html = html + "<td>"+datosJSon[i].nocta+"</td>";
          		html = html + "<td>"+datosJSon[i].cliente+"</td>";
          		html = html + "<td>"+datosJSon[i].tipo+"</td>";
          		html = html + "<td>"+datosJSon[i].saldo+"</td>";
          	html = html + "</tr>";
        }
      html = html + "</table>";

      document.getElementById("resultado").innerHTML="<i>"+html+"</i>";
  }
  else
  	  document.getElementById("resultado").innerHTML="<i>"+"Obteniendo datos..."+"</i>";
}


		/*---- Comienzan funciones independientes ----*/


		function establecerConexionConsultaGeneral()
		{	
		      xhr.onreadystatechange=obtenerDatos;
		      xhr.open("GET","Controller.jsp?bConsultaGeneral=true",true);
		      xhr.send(null);
		}

		function consultarGeneral()
		{  		  		
		      // 1. Crear el objeto XMLHttpRequest
		      iniciarObjetoXmlHttpRequest();  

		      // 2. Establecer conexion con el server Http (Tomcat, WLS, Web Sphere)
		      establecerConexionConsultaGeneral();
		}