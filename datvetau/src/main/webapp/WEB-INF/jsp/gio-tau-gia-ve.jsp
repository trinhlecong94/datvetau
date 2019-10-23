<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            table { border-collapse: collapse; }
            tr { display: block; float: left; }
            th, td { display: block; border: 1px solid black; }
        </style>
    </head>
    <body>
        <jsp:include page="../jsp/include/nav.jsp"/>
        <div class="container">
            <div class="s-dnews-2">
                <h1 class="s-dnews__title">Bảng giờ tàu áp dụng từ ngày 05/6/2019</h1>
                <h3 class="s-dnews__desc">Công ty CP Vận tải ĐS Sài Gòn thông báo tới khách hàng bảng giờ tàu mới nhất</h3>
                <div class="s-dnews__detail"><p><span style="color:rgb(28, 30, 33); font-family:helvetica,arial,sans-serif">Bảng giờ tàu áp dụng từ ngày 05/6/2019</span></p>
                    <p><span style="color:rgb(28, 30, 33); font-family:helvetica,arial,sans-serif">Đối với các mác tàu SE21, SE22, SE26, SNT1, SNT2:</span></p>
                    <p><span style="color:rgb(28, 30, 33); font-family:helvetica,arial,sans-serif">-&nbsp;Bổ sung ga đỗ nhận, trả khách là ga Dĩ An</span></p>
                    <p><span style="color:rgb(28, 30, 33); font-family:helvetica,arial,sans-serif">-&nbsp;Bãi bỏ ga Sóng Thần là ga đỗ nhận, trả khách</span></p>

                    <table class="table table-bordered">
                        <h1>Xuất phát tại Ga Hà Nội</h1>
                        <tr>
                            <th>Tên ga</th>
                                <c:forEach var="nhaGa" items="${nhaGaHaNoi}">
                                <th scope="col">${nhaGa.tenNhaGa}</th>
                                </c:forEach>
                        </tr>
                        <c:forEach var="lichtrinh" items="${lichTrinhHaNoi}">
                            <tr>
                                <td>${lichtrinh.tau.tenTau}</td>
                                <c:forEach var="giotauchay" items="${lichtrinh.gioTauChays}">
                                    <td>${giotauchay.thoiGian}</td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>
                    <table class="table table-bordered">
                        <h1>Xuất phát tại Ga Sài Gòn</h1>
                        <tr>
                            <th>Tên ga</th>
                                <c:forEach var="nhaGa" items="${nhaGaSaiGon}">
                                <th scope="col">${nhaGa.tenNhaGa}</th>
                                </c:forEach>
                        </tr>
                        <c:forEach var="lichtrinh" items="${lichTrinhSaiGon}">
                            <tr>
                                <td>${lichtrinh.tau.tenTau}</td>
                                <c:forEach var="giotauchay" items="${lichtrinh.gioTauChays}">
                                    <td>${giotauchay.thoiGian}</td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>

                </div>
            </div>
        </div>
        <div>



        </div>
    </body>
</html>
