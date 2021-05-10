<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_PE"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>
                            Listado de clientes
                        </h4>
                    </div>

                    <table class="table table-striped">
                        <thead class="thead-dark">
                        <tr>
                            <th>
                                #
                            </th>
                            <th>
                                Nombre
                            </th>
                            <th>
                                Saldo
                            </th>
                            <th>
                            </th>
                        </tr>
                        </thead>

                        <tbody>
                        <c:forEach var="clientes" items="${clientes}">
                            <tr>
                                <td>
                                        ${clientes.idCliente}
                                </td>

                                <td>
                                        ${clientes.nombre} ${clientes.apellido}
                                </td>

                                <td>
                                    <fmt:formatNumber value="${clientes.saldo}" type="currency"/>
                                </td>

                                <td>
                                    <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idCliente=${clientes.idCliente}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right">
                                            Editar
                                        </i>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>
                            Saldo Total
                        </h3>

                        <h4 class="display-4">
                            <fmt:formatNumber value="${saldoTotal}" type="currency"/>
                    </div>
                </div>

                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>
                            Total Clientes
                        </h3>

                        <h4 class="display-4">
                            <i class="fas fa-users">
                            </i>
                            ${totalClientes}
                        </h4>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>

<!--Agregar cliente modal-->
<jsp:include page="/WEB-INF/paginas/cliente/agregar-cliente.jsp"/>
