<%@ page import="java.util.StringTokenizer" %>
<%
    String datos = request.getParameter("datos");

    StringTokenizer st1 = new StringTokenizer(datos,"\n");
    StringTokenizer st = null;

    String strJson = "[";
    if (st1.countTokens > 1) {
    	while(st1.hasMoreTokens())
	    {
			st = new StringTokenizer(st1.nextToken(),"_");
			strJson =strJson + "{nocta:'"+st.nextToken()+"', nombre: '"+st.nextToken()+"', tipo:'"+st.nextToken()+"', saldo: '"+st.nextToken()+"'},";
		}	
		strJson = strJson +"]";
    }
    else
    {
		st = new StringTokenizer(st1.nextToken(),"_");
		if(st.counTokens > 1)
			strJson ="{nocta:'"+st.nextToken()+"', nombre: '"+st.nextToken()+"', tipo:'"+st.nextToken()+"', saldo: '"+st.nextToken()+"'}";
		else
			strJson = "{error:'Hubo un error'}";
	}  
    response.setContentType("text/plain");
    out.println(strJson);
    out.close();
    System.out.println(strJson);
%>
<%=strJson%>