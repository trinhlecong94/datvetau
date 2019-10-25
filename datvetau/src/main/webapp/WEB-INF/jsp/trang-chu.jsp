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
            <form action="chon-ve" method="GET">
                <div class="row">
                    <div class="form-group">
                        <input type="radio" name="loaiVe" value="khuHoi"> Khứ hồi
                        <input type="radio" name="loaiVe" value="motChieu"> Một Chiều<br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <div class="form-group">
                                <label for="exampleInputPassword1">Ga đi</label>
                                <input class="form-control" list="browsers2" name="gaDi">
                                <datalist id="browsers2">
                                    <c:forEach var="ga" items="${nhaGa}">
                                        <option value="${ga.tenNhaGa}"> 
                                        </c:forEach>
                                </datalist>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-group">
                                <label for="exampleInputPassword1">Ga đến</label>
                                <input class="form-control" list="browsers2" name="gaDen">
                                <datalist id="browsers2">
                                    <c:forEach var="ga" items="${nhaGa}">
                                        <option value="${ga.tenNhaGa}"> 
                                        </c:forEach>
                                </datalist>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="exampleInputPassword1">Ngày đi</label>
                            <input type="date" class="form-control" name="ngayDi" id="exampleInputPassword1" placeholder="Nhập Ngày Đi">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Ngày về</label>
                            <input type="date" class="form-control" name="ngayVe" id="exampleInputPassword1" placeholder="Nhập Ngày về">
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
