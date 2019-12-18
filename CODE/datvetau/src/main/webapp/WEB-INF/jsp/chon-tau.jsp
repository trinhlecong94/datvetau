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
        <div class="container">
            <jsp:include page="../jsp/include/nav.jsp"/>
            <div class="my-3">  
                <img style='height: 100%; width: 100%; object-fit: contain' src="http://saigonrailway.com.vn/upload/images/2018/12/1349x565-1544083869-single_banner26-1tauqualc.jpg">  
            </div>
            <div class="row mx-auto">
                <div class="col-5 border">
                    <h5>Thông Tin Hành Trình</h5> 
                    <table class="table table-bordered">
                        <tr>
                            <th>Ga Xuất Phát</th>
                            <th>${fromStation}</th>
                        </tr>
                        <tr>
                            <th>Ga Đến</th>
                            <th>${toStation}</th>
                        </tr>
                        <tr>
                            <th>Ngày Đi</th>
                            <th>${departureDate}}</th>
                        </tr>
                    </table>
                    <form action="chon-ve" method="GET">
                        <h5>Các Tàu Phù Hợp Với Lịch Trình</h5>
                        <c:forEach var="train" items="${trains}">
                            <button class="btn btn-primary" type="submit" name="trainName" value="${train.trainName}">${train.trainName}</button>
                        </c:forEach>    
                    </form>  
                    <br>
                </div>
                <div class="col-7 bg-primary border">
                </div>
            </div>

            <jsp:include page="../jsp/include/footer.jsp"/>
        </div>
    </body>
</html>
