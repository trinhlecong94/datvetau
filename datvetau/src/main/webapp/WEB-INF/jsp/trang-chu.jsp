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
            <h1>Thông tin hành trình</h1>
            <form>
                <div class="row">
                    <div class="form-group">
                        <input type="radio" name="age" value="30"> Khứ hồi
                        <input type="radio" name="age" value="60"> Một Chiều<br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">

                        <div class="form-group">
                            <label for="exampleInputPassword1">Ga đi</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Nhập mã ga đi">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Ga đên</label>
                            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Nhập mã ga đến">
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="exampleInputPassword1">Ngày đi</label>
                            <input type="date" class="form-control" id="exampleInputPassword1" placeholder="Nhập Ngày Đi">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Ngày về</label>
                            <input type="date" class="form-control" id="exampleInputPassword1" placeholder="Nhập Ngày về">
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
