<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="../jsp/include/nav.jsp"/>

        <div class="container col-8">
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Chọn Tàu Cần Kiểm Tra</label>
                    <input class="form-control" list="trainName" name="trainName">
                    <datalist id="trainName">
                        <c:forEach var="train" items="${trains}">
                            <option value="${train.trainName}"> 
                            </c:forEach>
                    </datalist>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            <c:forEach var="time" items="${train.trainArrivalTime}">
                ${time.noStation}
                ${time.station.stationName}
                ${time.timeTrain}
                <br>
            </c:forEach>   
        </div>
        <div>
        </div>
    </body>
</html>
