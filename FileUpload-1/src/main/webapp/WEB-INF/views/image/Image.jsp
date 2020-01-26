<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spr"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<table border="1">
		<tr>

			<th>Id</th>
			<th>Name</th>
			<th>Surname</th>
			<th>File name</th>
		</tr>

		<c:forEach var="user" items="${users}">
			<tr>

				<td>${user.id}</td>
				<td>${user.name}</td>
				<td>${user.surname}</td>
				<td>${user.file}</td>

			</tr>
		</c:forEach>
	</table>

	<spr:form action="${pageContext.request.contextPath}/uploadFile"
		method="post" modelAttribute="user" enctype="multipart/form-data">

		<table>
			<tr>
				<td><spr:label path="file"> Select a file to upload </spr:label>
				</td>
				<td><spr:input type="file" path="file" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>

		</table>    
</spr:form>

	<br>
	<hr />
	<br>


	<spr:form action="${pageContext.request.contextPath}/uploadMultiFile"
		method="post" modelAttribute="user" enctype="multipart/form-data">
		<table>
			<tr>
				<td>Select a file to upload</td>
				<td><input type="file" name="files" /></td>
			</tr>
			<tr>
				<td>Select a file to upload</td>
				<td><input type="file" name="files" /></td>
			</tr>
			<tr>
				<td>Select a file to upload</td>
				<td><input type="file" name="files" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</spr:form>


</body>
</html>