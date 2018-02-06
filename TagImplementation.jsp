<%@taglib uri="myTagFile" prefix="cp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
</head>
<body>
		<cp:count subStringOccurance="${param.subString}" >${param.mainString}</cp:count>	
</body>
</html>