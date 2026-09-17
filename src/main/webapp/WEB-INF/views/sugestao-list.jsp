<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>RolêOut - Sugestões</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

    <div class="container pagina">

        <div class="cabecalho-pagina">

            <div>
                <h1>Sugestões para você</h1>

                <p>
                    Encontramos rolês com base nas suas preferências.
                </p>
            </div>

            <a href="${pageContext.request.contextPath}/"
               class="botao botao-secundario">
                Voltar ao início
            </a>

        </div>

        <div class="card" style="margin-bottom: 24px;">

            <strong>Filtros utilizados:</strong>

            <p>
                Categoria:
                <strong>${categoriaSelecionada}</strong>
            </p>

            <p>
                Cidade:
                <strong>${cidadeSelecionada}</strong>
            </p>

            <p>
                Orçamento máximo:
                <strong>R$ ${valorMaximoSelecionado}</strong>
            </p>

        </div>

        <c:if test="${empty sugestoes}">

            <div class="mensagem-vazia">

                <h3>Nenhum rolê encontrado</h3>

                <p>
                    Não encontramos opções que correspondam
                    aos filtros selecionados.
                </p>

                <a href="${pageContext.request.contextPath}/sugestoes"
                   class="botao botao-principal">
                    Fazer outra busca
                </a>

            </div>

        </c:if>

        <c:if test="${not empty sugestoes}">

            <div class="resultados">

                <c:forEach var="role" items="${sugestoes}">

                    <div class="card-role">

                        <h3>${role.nome}</h3>

                        <p>
                            ${role.descricao}
                        </p>

                        <p>
                            <strong>Categoria:</strong>
                            ${role.categoria}
                        </p>

                        <p>
                            <strong>Local:</strong>
                            ${role.local}
                        </p>

                        <p>
                            <strong>Cidade:</strong>
                            ${role.cidade}
                        </p>

                        <p>
                            <strong>Data:</strong>
                            ${role.dataFormatada}
                        </p>

                        <p>
                            <strong>Valor:</strong>
                            R$ ${role.valor}
                        </p>

                    </div>

                </c:forEach>

            </div>

            <div class="acoes-formulario"
                 style="margin-top: 24px;">

                <a href="${pageContext.request.contextPath}/sugestoes"
                   class="botao botao-principal">
                    Fazer outra busca
                </a>

            </div>

        </c:if>

    </div>

</body>
</html>