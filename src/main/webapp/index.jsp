<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>

<%@page import="model.Client"%>
<%@page import="persistence.ClientData"%>

<%@page contentType="application/json;charset=iso-8859-1" language="java" pageEncoding="iso-8859-1" session="true"%>

<%
  String res = "{";
  List<String> clientsMethods = new ArrayList<>();
  clientsMethods.add("getAllClients");
  
  String proccess = request.getHeader("proccess");

  if(clientsMethods.contains(proccess)) {
    res += "\"ok\": true,";
    ClientData clientData = new ClientData();

    switch(proccess) {
      case "getAllClients":
        try {
          List<Client> clients = clientData.getAllClients();
          res += "\"" + proccess + "\": true,\"Clients\":" + new Gson().toJson(clients); 

        } catch (Exception ex) {
          res += "\"" + proccess + "\": true,\"Clients\":[]";
          Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  } else {
    res += "\"ok\": false,";
    res += "\"error\": \"INVALID\",";
    res += "\"errorMsg\": \"This request has invalid or incorrect fields.\",";
  }

  res += "}";
  response.setContentType("application/json;charset=iso-8859-1");
  out.print(res);
%>
