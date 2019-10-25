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
        <br>
        <div class="container col-6">
            <c:set var = "errorMessages" value = "${errorMessages}"/>
            <c:if test = "${errorMessages != null}">
                <div class="alert alert-danger" role="alert">
                    ${errorMessages}
                </div>
            </c:if>
            <c:if test = "${errorMessages == null}">
                <div class="alert alert-success" role="alert">
                    Tra Cứu Thành Công
                </div>
                <table class="table table-bordered">
                    <tr>
                        <td colspan="2">Thông Tin Vé Của Quý Khách</td>
                    </tr>
                    <tr>
                        <td>Ngày Khởi Hành</td>
                        <td>${ticketEntity.ngayKhoiHanh}</td>
                    </tr>
                    <tr>
                        <td>Mã Số Nhân Thân</td>
                        <td>${ticketEntity.maSoNhanThan}</td>
                    </tr>
                    <tr>
                        <td>Ga Khởi Hành</td>
                        <td>${ticketEntity.gaKhoiHanh.tenNhaGa}</td>
                    </tr>
                    <tr>
                        <td>Ga Đến</td>
                        <td>${ticketEntity.gaDen.tenNhaGa}</td>
                    </tr>
                    <tr>
                        <td>Mã Số Ghế Ngồi</td>
                        <td>${ticketEntity.gheNgoi.tenGheNgoi}</td>
                    </tr>
                    <tr>
                        <td>Tên Khách Hàng</td>
                        <td>${ticketEntity.tenKhachHang}</td>
                    </tr>
                </table>
            </c:if>
        </div>
    </body>
</html>
