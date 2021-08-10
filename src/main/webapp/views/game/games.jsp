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
    <link rel="stylesheet" href="${context}/assets/dist/css/dialogos.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>

<div class="d-flex">
    <div class="col-sm-12">
        <button type="button" class="btn btn-success" id="btn-registar"><i class="fas fa-plus"></i>Agregar</button>
        <table class="table" id="container" >
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
            </tbody>
        </table>
    </div>
</div>

<dialog id="Registrar" class="col-sm-5 dialogo">
    <div class="d-flex">
        <div class="card col-sm-12 border-0">
            <div class="card-header align-content-end">
                <button class="btn btn-light" id="cerrar" type="reset"><i class="fas fa-times"></i></button>
            </div>
            <div class="card-body">
                <form  class="row g-3" id="fregistrar">
                    <%--<input type="hidden" name="action" value="create">--%>
                    <div class="form-group col-md-6">
                        <label>Nombre(s)</label>
                        <input type="text" class="form-control campo" name="txtname" onkeyup="" pattern="^[a-zA-ZáéíóúÁÉÍÓÚÑñüÜ ]+" title="Sólo letras" />
                    </div>
                    <div class="form-group col-md-6">
                        <label>Imagen</label>
                        <input type="file" class="form-control campo" name="txtimage" onkeyup="" pattern="^[a-zA-ZáéíóúÁÉÍÓÚÑñüÜ ]+" title="Sólo letras"/>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Fecha Estreno </label>
                        <input type="text" class="form-control" name="txtdate" onkeyup="" />
                    </div>
                    <div class="col-md-6">
                        <label>Categoria </label>
                        <div class="row">
                            <div class="">
                                <select class="form-select" name="txtidCategory" onchange="" >
                                    <option value="1">Accion</option>
                                    <option value="2">RPG</option>
                                    <option value="3">Plataforma</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <menu>
                        <br>
                        <button type="submit" class="btn btn-success"><i class="fas fa-plus"></i>Registrar</button>
                    </menu>
                </form>
            </div>
        </div>
    </div>
</dialog>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/funtions.js"></script>
</body>
</html>
