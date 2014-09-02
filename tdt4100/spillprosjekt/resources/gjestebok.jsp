<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
	 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link REL="SHORTCUT ICON" HREF="tango/favicon.ico">
<meta http-equiv="charset=utf-8" />
<title>
Nordmoen Gjestebok
</title>
</head>
<body>
<%@ page import ="java.sql.*" %>
<%
	String navn =" ";
	String epost =" ";
	String titel =" ";
	String innlegg =" ";
%>
<%! String htmlEntity(String tekst) {
	// En liten ekstrafunksjon dere kan bruke i deres
	// egne gjestebøker, for å hindre at spesialtegn
	// ødelegger SQL-setningene.
	// (Det finnes sikkert penere løsninger, men dette
	// var det kjappeste jeg kom på i farta :-)
	// 
	// Merk at denne funksjonen også
	// konverterer linjeskift til <br>.

	StringBuffer sb = new StringBuffer(tekst);
	
	// Endrer enkelte spesialtegn til HTML-entiteter
	for(int i = 0; i < sb.length(); i++) {
		char c = sb.charAt(i);

		if(c == '\'') {
			sb.replace(i, i+1, "&apos;");
			i = i+5;
		} else if(c == '"') {
			sb.replace(i, i+1, "&quot;");
			i = i+5;
		} else if(c == '&') {
			sb.replace(i, i+1, "&amp;");
			i = i+4;
		} else if(c == '<') {
			sb.replace(i, i+1, "&lt;");
			i = i+3;
		} else if(c == '>') {
			sb.replace(i, i+1, "&gt;");
			i = i+3;
		} else if(c == '\n') {
			sb.replace(i, i+1, "<br>\n");
			i = i+4;
		}
	}
	
	return sb.toString();
}
%>
<%!
String byttSmil(String tekst){
	String resultat = tekst;
	String[] smileFjes = {":utrop:",":engel:",":sint:",":kul:",":gråt:",":djevel:",":rødme:",":kyss:",":le:",":ape:",":meh:",":P",":lei:",":smil:",":D",":O",":usikker:",":vink:",":S",":ide:",":spørsmål:",":pil:"};
	String[] smilSted = {"exclaim","face-angel","face-angry","face-cool","face-crying","face-devilish","face-embarrassed","face-kiss","face-laugh","face-monkey","face-plain","face-raspberry","face-sad","face-smile","face-smile-big","face-surprise","face-uncertain","face-wink","face-worried","idea","question","stock_right"};
		
	for(int i = 0; i < smileFjes.length; i++){
		resultat = resultat.replaceAll(smileFjes[i],"<img src=\"tango/" + smilSted[i] + ".png\">");
	}
	return resultat;
}
%>
<%
	int tilfeldig = (int) (Math.random()*3333);
%>
	<h2>Velkommen til min gjestebok!</h2>
	<h4>Vi har nå støtte for enkle smilefjes</h4>
	<fieldset style="width:35em">
	<legend>Fyll ut:</legend>
	<form action="gjestebok.jsp" method="post">
	<table widht="600">
	<tr><td>Navn:</td><td> <input type="text" name="navn" value="Navn" size="20"></td> </tr>
	<tr><td>Epost:</td><td> <input type="text" name="epost" value="dinEpost@epost.no" size="20"></td> </tr>
	<tr><td>Titel:</td><td> <input type="text" name="titel" value="Ingen titel" size="20"></td> </tr>
	</table>
	<p>Innlegg:<br>
	<textarea name="innlegg" rows="7" cols="40">Skriv her...</textarea> <a href="face.jsp" target="_blank"><img src="tango/screenshot-2.png" alt="faces"></a></p>
	<table widht="600">
	<tr><td>Send inn:</td><td> <input type="checkbox" name="send" value="1"></td></tr>
	<tr><td>Skriv inn <%=tilfeldig%>:</td><td><input type="text" name="superTest1" value="" size="5"></td></tr>
	</table>
	<p><input type="submit" value="Legg til">
	<input type="reset" value="Tøm skjema">
	<input type="hidden" value="<%=tilfeldig%>" name="hei"></p>
	<p>Oppdatert: <a href="sok.html" >Søk i innlegg</a></p>
	</fieldset>
	</form>
	
	<%
		navn = request.getParameter("navn");
		epost = request.getParameter("epost");
		titel = request.getParameter("titel");
		innlegg = request.getParameter("innlegg");
		String send = request.getParameter("send");
		String ip = request.getRemoteHost();
		String testMot = "1";
		
		Class.forName("org.gjt.mm.mysql.Driver").newInstance();
			Connection db = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/jorgno_oving9data", "jorgno_oving9", "oving9");
			Statement st = db.createStatement();
			ResultSet rs;
		
		if(testMot.equals(send) && (request.getParameter("superTest1").equals(request.getParameter("hei"))) ){
		navn = htmlEntity(navn);
		epost = htmlEntity(epost);
		titel = htmlEntity(titel);
		innlegg = htmlEntity(innlegg);
			
			String kommando = "INSERT INTO innlegg (id,navn,epost,ip,titel,innlegg) VALUES(''" + "," + "'" + navn + "'" + "," + "'" + epost + "'" +"," + "'" + ip + "'" + "," + "'" + titel + "'" + "," + "'" + innlegg + "')";
			//out.println(kommando);
			
			st.executeQuery(kommando);			
		}else if(!testMot.equals(send)){
			out.println("<b>Du glemte å velge avkrysningsboksen 'Send inn'</b>");
		}else{
		}
		rs = st.executeQuery("SELECT * FROM innlegg ORDER BY id ASC");
		out.println("<h4>Tidligere innlegg:</h4>");
		out.println("<div style=\"word-wrap: break-word\">");
		while(rs.next()){
			String navn1 = rs.getString("navn");
			String epost1 = rs.getString("epost").replaceFirst("@","[at]");
			//String ipAdress = rs.getString("ip");
			String titel1 = rs.getString("titel");
			String innlegg1 = rs.getString("innlegg");
			String tid1 = rs.getString("tid");
			int id = rs.getInt("id");
			
			titel1 = byttSmil(titel1);
			innlegg1 = byttSmil(innlegg1);
			
			out.println("<table width=\"300\"");
			out.println("<tr><td> Innlegg #" + id +"</td></tr>");
			out.println("<tr><td>Skrevet av: " +"<u>" +"<a href=\"http://folk.ntnu.no/jorgno/sok.jsp?sokeOrd="+navn1 + "&sokI=WHERE+navn+LIKE+&ordne=\" target=\"_blank\">" + navn1 +"</a></u></td></tr>");
			out.println("<tr><td>Epost: " + epost1 + "</td></tr>");
			out.println("<tr><td><i><font size=\"2\">Skrevet: " + tid1 + "</font></i></td></tr>");
			out.println("<tr><td><b>"+titel1+"</b></td></tr>");
			out.println("<tr><td><hr></td></tr>");
			out.println("<tr><td>"+ innlegg1+"</td></tr>");
			out.println("<tr><td><hr></td></tr>");
			out.println("</table>");
			out.println("<br>");
		}
		out.println("</div>");
		
	%>
</body>
</html>
