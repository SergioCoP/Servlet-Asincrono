<%--
  Created by IntelliJ IDEA.
  User: Sergio Cortes
  Date: 04/08/2021
  Time: 11:58:a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>

<div class="d-flex">
    <div class="col-sm-12">
        <button type="button" class="btn btn-success" id="btn-registar"><i class="fas fa-plus"></i>Agregar</button>
        <table class="table" id="table" >
            <thead class="table-light" >
            <tr>
                <th>No.</th><!--Enbcabezado-->
                <th>Imagen</th>
                <th>Nombre</th>
                <th>Categoria</th>
                <th>Fecha de Estreno</th>
                <th>Status</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ listGames }" var="game" varStatus="status"><!--iterar cada usuario-->
            <tr>
                <td>${ status.count } </td>
                <td><img src="data:image/jpeg;base64,${ game.imgGame }" alt="ss"></td><!--datos del bean person-->
                <td>${ game.nameGame }</td>
                <td>${ game.Category_idCategory.nameCategory }</td>
                <td>${ game.datePremiere }</td>
                <td><c:if test="${ game.Status == 1 }">
                    <span class="badge rounded-pill bg-success">Activo</span>
                </c:if>
                    <c:if test="${ game.Status == 0 }">
                        <span class="badge rounded-pill bg-danger">Inactivo</span>
                    </c:if>
                </td>
                <td>
                    <a  class="btn btn-primary btn-sm btn-modificar"><i class="fas fa-edit"></i></a>
                    <a  class="btn btn-danger btn-sm btn-eliminar"><i class="fas fa-trash-alt"></i></a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/funtions.js"></script>
</body>
</html>
