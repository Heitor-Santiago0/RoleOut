<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>RolêOut - Encontrar Rolê</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

    <div class="container pagina">

        <div class="cabecalho-pagina">

            <div>
                <h1>Encontrar um Rolê</h1>
                <p>
                    Informe suas preferências e o RolêOut buscará opções compatíveis.
                </p>
            </div>

            <a href="${pageContext.request.contextPath}/"
               class="botao botao-secundario">
                Voltar ao início
            </a>

        </div>

        <div class="card formulario">

            <form action="${pageContext.request.contextPath}/sugestoes"
                  method="get">

                <div class="campo">

                    <label>Categoria</label>

                    <select name="categoria" required>

                        <option value="">
                            Selecione uma categoria
                        </option>

                        <option value="Música">Música</option>
                        <option value="Festa">Festa</option>
                        <option value="Gastronomia">Gastronomia</option>
                        <option value="Cultura">Cultura</option>
                        <option value="Esporte">Esporte</option>
                        <option value="Natureza">Natureza</option>
                        <option value="Cinema">Cinema</option>
                        <option value="Outros">Outros</option>

                    </select>

                </div>

                <div class="campo">

                    <label>Cidade</label>

                    <input
                        type="text"
                        name="cidade"
                        placeholder="Ex.: Uberaba"
                        required
                    >

                </div>

                <div class="campo">

                    <label>Orçamento máximo</label>

                    <input
                        type="number"
                        name="valorMaximo"
                        step="0.01"
                        min="0"
                        placeholder="Ex.: 50,00"
                        required
                    >

                </div>

                <div class="acoes-formulario">

                    <button
                        type="submit"
                        class="botao botao-principal">

                        Encontrar Rolê
                    </button>

                    <a href="${pageContext.request.contextPath}/"
                       class="botao botao-secundario">

                        Cancelar
                    </a>

                </div>

            </form>

        </div>

    </div>

</body>
</html>
