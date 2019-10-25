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

        <div>${loaiVe}</div>
        <div>${gaDi}</div>
        <div>${gaDen}</div>
        <div>${ngayDi}</div>
        <div>${ngayDen}</div>

        <form action="thanh-toan" method="GET">
            <div>Tên Tàu</div>
            <c:forEach var="tau" items="${taus}">
                <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo${tau.tenTau}">${tau.tenTau}</button>
                <div id="demo${tau.tenTau}" class="collapse">
                    <c:forEach var="toaTau" items="${tau.toaTaus}">
                        <button type="button" class="btn btn-dark" data-toggle="collapse" data-target="#demo2${toaTau.status}">${toaTau.status}</button>
                        <div id="demo2${toaTau.status}" class="collapse">
                            <c:forEach var="gheNgoi" items="${toaTau.gheNgoiEntitys}">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" name="vitri" value="${gheNgoi.id}" id="defaultCheck1">
                                    <label class="form-check-label" for="defaultCheck1">
                                        ${gheNgoi.id}
                                    </label>
                                </div>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>
            </c:forEach>
            <input type="hidden" id="custId" name="tau" value="SE1">
            <input type="hidden" id="custId" name="toa" value="10">
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        <h3>Checkbox</h3>
    </body>
</html>
