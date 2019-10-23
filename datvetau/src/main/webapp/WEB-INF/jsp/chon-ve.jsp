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

        <table class="table table-bordered">
            <h1>Xuất phát tại Ga Hà Nội</h1>
            <tr>
                <th>Tên Tàu</th>
                    <c:forEach var="taus" items="${taus}">
                    <th scope="col">${taus.tenTau}</th>
                    </c:forEach>
            </tr>
            <c:forEach var="tau" items="${taus}">
                <tr>
                    <c:forEach var="toaTau" items="${tau.toaTaus}">
                        <td>${toaTau.status}</td>
                        <c:forEach var="gheNgoi" items="${toaTau.gheNgoiEntitys}">
                            <td>${gheNgoi.tenGheNgoi}</td>

                        </c:forEach>

                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <h3>Checkbox</h3>
        <form action="thanh-toan" method="GET">
            <div class="btn-group" data-toggle="buttons">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="vitri" value="1" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        1
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="vitri" value="2" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        2
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="vitri" value="3" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        3
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="vitri" value="4" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        4
                    </label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="checkbox" name="vitri" value="5" id="defaultCheck1">
                    <label class="form-check-label" for="defaultCheck1">
                        5
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="1" id="defaultCheck2" disabled>
                    <label class="form-check-label" for="defaultCheck2">
                        6
                    </label>
                </div>	
                <input type="hidden" id="custId" name="tau" value="SE1">
                <input type="hidden" id="custId" name="toa" value="10">

            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>





    </body>
</html>
