<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>get user info</title>
</head>
<body>

<form name="test" action='/reserve/user/getUserInfo'  method="get">
	<input type="text" name="user_id" />
	<br>
	<input type="submit" value="submit">
</form>

</body>
</html>
