<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>RolêOut</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>

<body>

    <main class="hero">

        <div class="hero-conteudo">

            <img
                src="${pageContext.request.contextPath}/images/logo-roleout.png"
                alt="Logo RolêOut"
                class="logo-principal"
            >

            <p>
                Encontre opções de lazer que combinam
                com suas preferências e seu orçamento.
            </p>

            <div class="acoes-iniciais">

                <a
                    href="${pageContext.request.contextPath}/sugestoes"
                    class="botao botao-principal">

                    Encontrar um Rolê
                </a>

                <a
                    href="${pageContext.request.contextPath}/roles"
                    class="botao botao-secundario">

                    Gerenciar Rolês
                </a>

            </div>

        </div>

    </main>

</body>
</html>