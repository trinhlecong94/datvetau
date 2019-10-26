<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
            <h1>Thông tin hành trình</h1>
            <form action="chon-ve" method="GET" accept-charset="UTF-8">
                <div class="row">
                    <div class="form-group">
                        <input type="radio" name="typeTicket" value="round-trip"> Khứ hồi
                        <input type="radio" name="typeTicket" value="one-way"> Một Chiều<br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <div class="form-group">
                                <label for="from-station">Ga đi</label>
                                <input id="from-station" class="form-control" list="fromStation" name="fromStation">
                                <datalist id="fromStation">
                                    <c:forEach var="station" items="${stations}">
                                        <option value="${station.stationName}"> 
                                        </c:forEach>
                                </datalist>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-group">
                                <label for="to-station">Ga đến</label>
                                <input id="to-station" class="form-control" list="toStation" name="toStation">
                                <datalist id="toStation">
                                    <c:forEach var="station" items="${stations}">
                                        <option value="${station.stationName}"> 
                                        </c:forEach>
                                </datalist>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="departure">Ngày đi</label>
                            <input id="departure" type="date" class="form-control" name="departureDate" placeholder="Nhập Ngày Đi">
                        </div>
                        <div class="form-group">
                            <label for="return">Ngày về</label>
                            <input id="return" type="date" class="form-control" name="returnDate" placeholder="Nhập Ngày về">
                        </div>

                    </div>
                </div>
                <div class="row justify-content-center">                           
                    <button type="submit" class="btn btn-primary">Submit</button>             
                </div>
            </form>
        </div>
    </body>
</html>
