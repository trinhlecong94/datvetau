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
        <div class="container">
            <div>${typeTicket}</div>
            <div>${fromStation}</div>
            <div>${toStation}</div>
            <div>${departureDate}</div>
            <div>${returnDate}</div>
            <form action="thanh-cong" method="GET">
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">Họ Tên</th>
                            <th scope="col">Số Chứng Minh Nhân Dân</th>
                            <th scope="col">Đối Tượng</th>
                            <th scope="col">Vị Trí</th>
                            <th scope="col">Giá Vé</th>
                            <th scope="col">Giảm Giá</th>
                            <th scope="col">Thành Tiền</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="seat" items="${seatsID}">
                            <tr>
                                <td><input type="text" name="fullName"></td>
                                <td><input type="number" name="identityNumber"></td>
                                <td><input type="hidden" name="seatID" value="${seat}"></td>
                                <td> 
                                    <div class="form-group">
                                        <select class="form-control">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </select>
                                    </div>
                                </td>
                                <td>${seat} ${carriageTrain} ${train}</td>
                                <td>1.754.333.000</td>
                                <td>1.000</td>
                                <td>1.754.333.000</td>
                            </tr>
                        </c:forEach>                  
                    </tbody>
                </table>
                <input type="hidden" id="custId" name="soluong" value="3">
                <button type="submit" class="btn btn-primary">Thanh Toán</button>
            </form>
        </div>
    </body>
</html>
