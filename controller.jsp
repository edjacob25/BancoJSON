<!DOCTYPE html>
<jsp:useBean id='bancodp' class='modelBanco.ClienteDP' />
<jsp:setProperty name = 'bancodp' property ='*' />
<jsp:useBean id='bancoad' class='modelBanco.ClienteAD' />
<jsp:setProperty name = 'bancoad' property ='*' />

<%
	if((request.getParameter("bCrear")==null)&&(request.getParameter("bConsultaGeneral")==null)&&(request.getParameter("bConsultaNocta")==null)&&(request.getParameter("bConsultarTipo")==null)&&(request.getParameter("bRetiro")==null)&&(request.getParameter("bDeposito")==null))
	{
	}
%>
