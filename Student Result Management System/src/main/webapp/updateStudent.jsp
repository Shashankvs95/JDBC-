<%@page import ="Project.ConnectionProvider"%>
<%@page import ="java.sql.*"%>

<% 
String course = request.getParameter("course");
String branch = request.getParameter("branch");
String rollno = request.getParameter("rollno");
String name = request.getParameter("name");
String fathername = request.getParameter("fathername");
String gender = request.getParameter("gender");
Connection con = null;

try{
	con = ConnectionProvider.getCon();
	if(course!=null && branch!=null && rollno!=null && name!=null && fathername!=null && gender!=null){
	String qry = "update project1.student set course=?, branch=?,name=?,fathername=?, gender=? where rollno='"+rollno+"';";
	PreparedStatement pst = con.prepareStatement(qry);
	pst.setString(6, gender);
	pst.setString(3, rollno);
	pst.executeUpdate();
	response.sendRedirect("adminHome.jsp");
	}
}catch(Exception e){
	e.printStackTrace();
}


%>