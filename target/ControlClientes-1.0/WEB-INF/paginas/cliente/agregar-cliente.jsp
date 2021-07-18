<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="es_PE"/>

<meta charset="UTF-8">
<div class="modal fade" id="agregarClienteModal" lang="es">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">
                    Agregar Cliente
                </h5>

                <button class="close" data-dismiss="modal">
                    <span>
                        &times;
                    </span>
                </button>
            </div>

            <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="post"
                  class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <%--@declare id="nombre"--%><label for="nombre">
                        Nombre
                    </label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>

                    <div class="form-group">
                        <%--@declare id="apellidos"--%><label for="apellidos">
                        Apellido
                    </label>
                        <input type="text" class="form-control" name="apellidos" required>
                    </div>

                    <div class="form-group">
                        <%--@declare id="email"--%><label for="email">
                        Email
                    </label>
                        <input type="email" class="form-control" name="email" required>
                    </div>

                    <div class="form-group">
                        <%--@declare id="telefono"--%><label for="telefono">
                        Teléfono
                    </label>
                        <input type="tel" class="form-control" name="telefono" required>
                    </div>

                    <div class="form-group">
                        <%--@declare id="saldo"--%><label for="saldo">
                        Saldo
                    </label>
                        <input type="number" class="form-control" name="saldo" required>
                    </div>
                </div>

                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">
                        Guardar
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
