<!DOCTYPE html>
<jsp:useBean id='bancodp' class='modelBanco.ClienteDP' />
<jsp:setProperty name = 'bancodp' property ='*' />
<jsp:useBean id='bancoad' class='modelBanco.ClienteAD' />
<jsp:setProperty name = 'bancoad' property ='*' />

<%
	out.println(bancoad.consultarDatos());
%>
