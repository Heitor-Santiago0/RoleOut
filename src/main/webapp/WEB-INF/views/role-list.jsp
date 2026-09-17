<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>RolêOut - Gerenciar Rolês</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

    <div class="container pagina">

        <div class="cabecalho-pagina">

            <div>
                <h1>Gerenciar Rolês</h1>
                <p>Cadastre, edite e organize os rolês disponíveis no sistema.</p>
            </div>

            <a href="${pageContext.request.contextPath}/"
               class="botao botao-secundario">
                Voltar ao início
            </a>

        </div>

        <div class="acoes-formulario">

            <a href="${pageContext.request.contextPath}/roles?acao=novo"
               class="botao botao-principal">
                + Cadastrar novo rolê
            </a>

        </div>

        <br>

        <c:if test="${empty roles}">

            <div class="mensagem-vazia">
                Nenhum rolê cadastrado ainda.
            </div>

        </c:if>

        <c:if test="${not empty roles}">

            <div class="tabela-container">

                <table>

                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome</th>
                            <th>Cidade</th>
                            <th>Data</th>
                            <th>Categoria</th>
                            <th>Valor</th>
                            <th>Ações</th>
                        </tr>
                    </thead>

                    <tbody>

                        <c:forEach var="role" items="${roles}">

                            <tr>
                                <td>${role.id}</td>
                                <td>${role.nome}</td>
                                <td>${role.cidade}</td>
                                <td>${role.dataFormatada}</td>
                                <td>${role.categoria}</td>
                                <td>R$ ${role.valor}</td>

                                <td>

                                    <a href="${pageContext.request.contextPath}/roles?acao=editar&id=${role.id}"
                                       class="link-editar">
                                        Editar
                                    </a>

                                    &nbsp; | &nbsp;

                                    <a href="${pageContext.request.contextPath}/roles?acao=excluir&id=${role.id}"
                                       class="link-excluir"
                                       onclick="return confirm('Deseja realmente excluir este rolê?');">
                                        Excluir
                                    </a>

                                </td>
                            </tr>

                        </c:forEach>

                    </tbody>

                </table>

            </div>

        </c:if>

    </div>

</body>
</html>