<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>RolêOut - Rolê</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

    <div class="container pagina">

        <div class="cabecalho-pagina">

            <div>
                <h1>
                    ${role != null ? 'Editar Rolê' : 'Cadastrar Rolê'}
                </h1>

                <p>
                    Preencha os dados do rolê abaixo.
                </p>
            </div>

            <a href="${pageContext.request.contextPath}/"
               class="botao botao-secundario">
                Voltar ao início
            </a>

        </div>

        <div class="card formulario">

            <form action="${pageContext.request.contextPath}/roles"
                  method="post">

                <input type="hidden"
                       name="id"
                       value="${role.id}">

                <div class="campo">
                    <label>Nome</label>

                    <input
                        type="text"
                        name="nome"
                        value="${role.nome}"
                        required
                    >
                </div>

                <div class="campo">
                    <label>Descrição</label>

                    <textarea
                        name="descricao"
                        rows="4"
                    >${role.descricao}</textarea>
                </div>

                <div class="campo">
                    <label>Local</label>

                    <input
                        type="text"
                        name="local"
                        value="${role.local}"
                    >
                </div>

                <div class="campo">
                    <label>Cidade</label>

                    <input
                        type="text"
                        name="cidade"
                        value="${role.cidade}"
                        required
                    >
                </div>

                <div class="campo">
                    <label>Data</label>

                    <input
                        type="date"
                        name="data"
                        value="${role.data}"
                    >
                </div>

                <div class="campo">
                    <label>Categoria</label>

                    <select name="categoria" required>

                        <option value="">
                            Selecione uma categoria
                        </option>

                        <option value="Música"
                            <c:if test="${role.categoria == 'Música'}">selected</c:if>>
                            Música
                        </option>

                        <option value="Festa"
                            <c:if test="${role.categoria == 'Festa'}">selected</c:if>>
                            Festa
                        </option>

                        <option value="Gastronomia"
                            <c:if test="${role.categoria == 'Gastronomia'}">selected</c:if>>
                            Gastronomia
                        </option>

                        <option value="Cultura"
                            <c:if test="${role.categoria == 'Cultura'}">selected</c:if>>
                            Cultura
                        </option>

                        <option value="Esporte"
                            <c:if test="${role.categoria == 'Esporte'}">selected</c:if>>
                            Esporte
                        </option>

                        <option value="Natureza"
                            <c:if test="${role.categoria == 'Natureza'}">selected</c:if>>
                            Natureza
                        </option>

                        <option value="Cinema"
                            <c:if test="${role.categoria == 'Cinema'}">selected</c:if>>
                            Cinema
                        </option>

                        <option value="Outros"
                            <c:if test="${role.categoria == 'Outros'}">selected</c:if>>
                            Outros
                        </option>

                    </select>
                </div>

                <div class="campo">
                    <label>Valor</label>

                    <input
                        type="number"
                        name="valor"
                        step="0.01"
                        min="0"
                        value="${role.valor}"
                        required
                    >
                </div>

                <div class="acoes-formulario">

                    <button
                        type="submit"
                        class="botao botao-principal">
                        Salvar
                    </button>

                    <a href="${pageContext.request.contextPath}/roles"
                       class="botao botao-secundario">
                        Cancelar
                    </a>

                </div>

            </form>

        </div>

    </div>

</body>
</html>