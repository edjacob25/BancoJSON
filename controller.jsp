<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "javax.swing.*" %>

<!DOCTYPE html>


<jsp:useBean id='bancodp' class='modelBanco.ClienteDP' />
<jsp:setProperty name = 'bancodp' property ='*' />
<jsp:useBean id='bancoad' class='modelBanco.ClienteAD' />
<jsp:setProperty name = 'bancoad' property ='*' />

<%
	/*if((request.getParameter("bCrear")==null)&&(request.getParameter("bConsultaGeneral")==null)&&(request.getParameter("bConsultaNocta")==null)&&(request.getParameter("bConsultarTipo")==null)&&(request.getParameter("bRetiro")==null)&&(request.getParameter("bDeposito")==null))
	{

	}*/
	if(request.getParameter("bConsultaGeneral")!=null)
	{
			String datos = bancoad.consultarDatos();
			if(datos.equals("")) datos="Tu consulta no generó resultados";
%>
			
			<jsp:forward page="toJSON.jsp">
				<jsp:param name="datos" value="<%= datos %>"/>
			</jsp:forward>
	<%
	}
	if(request.getParameter("bCapturar")!=null)
	{
		String datos = request.getParameter("datos");
		
		String respuesta = bancoad.capturar(datos);
		%>
			
			<jsp:forward page="toJSON.jsp">
				<jsp:param name="datos" value="<%= respuesta %>"/>
			</jsp:forward>
		<%
	}

	if(request.getParameter("bConsultarNocta")!=null)
	{
		String datos = request.getParameter("datos");
		String respuesta = bancoad.consultarNocta(datos);

	
	%>
			
			<jsp:forward page="toJSON.jsp">
				<jsp:param name="datos" value="<%= respuesta %>"/>
			</jsp:forward>
		<%
	}
	if(request.getParameter("bConsultarTipo")!=null)
	{
		String datos = request.getParameter("datos");
		String respuesta = bancoad.consultarTipo(datos);

	
	%>
			
			<jsp:forward page="toJSON.jsp">
				<jsp:param name="datos" value="<%= respuesta %>"/>
			</jsp:forward>
		<%
	}

	if(request.getParameter("ModificarSaldoView")!=null)
	{
		String datos = request.getParameter("datos");
		String url = "modificarSaldo.jsp?datos="+datos;
		response.sendRedirect(url);
	}

	if(request.getParameter("bActualizarSaldoAction")!= null)
	{
		String datos = request.getParameter("datos");
		String respuesta = bancoad.modificar(datos);

		%>
			
			<jsp:forward page="toJSON.jsp">
				<jsp:param name="datos" value="<%= respuesta %>"/>
			</jsp:forward>
		<%
	}
	if(request.getParameter("bRetirar")!=null)
	{
		String nocta = request.getParameter("nocta");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		String respuesta = bancoad.retirar(nocta,cantidad);

		%>
			
			<jsp:forward page="toJSON.jsp">
				<jsp:param name="datos" value="<%= respuesta %>"/>
			</jsp:forward>
		<%
	}
	%>
