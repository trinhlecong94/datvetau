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
            <form action="ket-qua-kiem-tra" method="GET">

                <div class="form-group">
                    <label for="input-code">Mã vé</label>
                    <input type="number" name="code" class="form-control" id="input-code" aria-describedby="emailHelp" placeholder="Nhập mã vé bao gồm 8 hoặc 9 số">
                </div>
                <div class="form-group">
                    <label for="identity-Number">Số giấy tờ</label>
                    <input type="text" name="identityNumber" class="form-control" id="identity-Number" placeholder="Nhập giấy tờ các nhân ghi trên vé">
                </div>
                <div class="row justify-content-center">                           
                    <button type="submit" class="btn btn-primary">Submit</button>             
                </div>
            </form>
        </div>
    </body>
</html>
