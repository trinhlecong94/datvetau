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
            <form>
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Mã vé</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nhập mã vé bao gồm 8 hoặc 9 số">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Ga đến</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Nhập mã ga đến">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Ga đi</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Nhập mã ga đi">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="exampleInputPassword1">Mác Tàu</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Nhập Mác Tàu Ví dụ SE1, TN1, SE2, SE6">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Ngày đi</label>
                            <input type="date" class="form-control" id="exampleInputPassword1" placeholder="Nhập Ngày Đi">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Số giấy tờ</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Nhập giấy tờ các nhân ghi trên vé">
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
