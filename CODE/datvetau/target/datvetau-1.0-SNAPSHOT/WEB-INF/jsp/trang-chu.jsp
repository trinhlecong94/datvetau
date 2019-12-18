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
        <div class="container">
            <jsp:include page="../jsp/include/nav.jsp"/>
            <div class="my-3">  
                <img style='height: 100%; width: 100%; object-fit: contain' src="http://saigonrailway.com.vn/upload/images/2018/12/1349x565-1544083869-single_banner26-1tauqualc.jpg">  
            </div>

            <div class="row mx-auto">
                <div class="col-3 border">
                    <br>
                    <h5 class="text-center">Thông tin hành trình</h5>
                    <form action="chon-tau" method="GET" accept-charset="UTF-8">
                        <div class="row ml-1">
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
                                    <label for="to-station">Ga đến</label>
                                    <input id="to-station" class="form-control" list="toStation" name="toStation">
                                    <datalist id="toStation">
                                        <c:forEach var="station" items="${stations}">
                                            <option value="${station.stationName}"> 
                                            </c:forEach>
                                    </datalist>
                                </div>
                                <div class="form-group">
                                    <label for="departure">Ngày đi</label>
                                    <input id="departure" type="date" class="form-control" name="departureDate" placeholder="Nhập Ngày Đi">
                                </div>
                                <div class="row justify-content-center">                           
                                    <button type="submit" class="btn btn-primary">Submit</button>             
                                </div>
                                <br>
                            </div>
                            <div class="col-sm">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-9 border bg-info">
                </div>
            </div>

            <jsp:include page="../jsp/include/footer.jsp"/>
        </div>
    </body>
</html>
