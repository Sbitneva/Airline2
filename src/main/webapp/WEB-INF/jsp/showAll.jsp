<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Airline</title>
    </head>
    <body>
        <c:forEach items=${aircrafts} var="aircraft">
            <b>${aircraft.name}</b>
        </c:forEach>
    </body>

</html>