package br.com.roleout.controller;

import br.com.roleout.model.Role;
import br.com.roleout.service.RoleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/sugestoes")
public class SugestaoController extends HttpServlet {

    private final RoleService roleService = new RoleService();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String categoria = request.getParameter("categoria");
        String cidade = request.getParameter("cidade");
        String valorMaximoParam = request.getParameter("valorMaximo");

        // Se ainda não houver filtros, abre o formulário
        if (categoria == null || cidade == null || valorMaximoParam == null) {

            request.getRequestDispatcher(
                "/WEB-INF/views/sugestao-form.jsp"
            ).forward(request, response);

            return;
        }

        double valorMaximo = Double.parseDouble(valorMaximoParam);

        List<Role> sugestoes =
            roleService.buscarSugestoes(
                categoria,
                cidade,
                valorMaximo
            );

        request.setAttribute("sugestoes", sugestoes);

        request.setAttribute("categoriaSelecionada", categoria);
        request.setAttribute("cidadeSelecionada", cidade);
        request.setAttribute("valorMaximoSelecionado", valorMaximo);

        request.getRequestDispatcher(
            "/WEB-INF/views/sugestao-list.jsp"
        ).forward(request, response);
    }
}