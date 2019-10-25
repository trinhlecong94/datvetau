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

        <div class="container col-8">
            <form>
                <div class="form-group">
                    <label for="exampleInputEmail1">Chọn Tàu Cần Kiểm Tra</label>
                    <input class="form-control" list="trainName" name="trainName">
                    <datalist id="trainName">
                        <c:forEach var="trains" items="${trains}">
                            <option value="${trains.tenTau}"> 
                            </c:forEach>
                    </datalist>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            
            <c:forEach var="time" items="${schedule.gioTauChays}">
                ${time.thoiGian}
            </c:forEach>
            
            
            
        </div>
        <div>



        </div>
    </body>
</html>
