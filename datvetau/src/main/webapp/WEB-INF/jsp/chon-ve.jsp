<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../jsp/include/nav.jsp"/>

        <div>${typeTicket}</div>
        <div>${fromStation}</div>
        <div>${toStation}</div>
        <div>${departureDate}</div>
        <div>${returnDate}</div>

        <form action="thanh-toan" method="GET">
            <div>Tên Tàu</div>
            <c:forEach var="train" items="${trains}">
                <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo${train.trainName}">${train.trainName}</button>
                <div id="demo${train.trainName}" class="collapse">
                    <c:forEach var="carriageTrain" items="${train.carriageTrains}">
                        <button type="button" class="btn btn-dark" data-toggle="collapse" data-target="#demo2${carriageTrain.carriageName}">${carriageTrain.carriageName}</button>
                        <div id="demo2${carriageTrain.carriageName}" class="collapse">
                            <c:forEach var="seat" items="${carriageTrain.seats}">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="seatsID" value="${seat.id}" id="defaultCheck1">
                                    <label class="form-check-label" for="defaultCheck1">
                                        ${seat.id}
                                        ${seat.status}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>
            <input type="hidden" id="custId" name="train" value="SE1">
            <input type="hidden" id="custId" name="carriageTrain" value="10">
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </body>
</html>
