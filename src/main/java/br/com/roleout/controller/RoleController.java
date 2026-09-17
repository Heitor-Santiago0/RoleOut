package br.com.roleout.controller;

import br.com.roleout.model.Role;
import br.com.roleout.service.RoleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/roles")
public class RoleController extends HttpServlet {

    private final RoleService roleService = new RoleService();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao == null) {
            acao = "listar";
        }

        switch (acao) {

            case "novo":
                request.getRequestDispatcher(
                    "/WEB-INF/views/role-form.jsp"
                ).forward(request, response);
                break;

            case "editar":

                int idEditar =
                    Integer.parseInt(request.getParameter("id"));

                Role role =
                    roleService.buscarPorId(idEditar);

                request.setAttribute("role", role);

                request.getRequestDispatcher(
                    "/WEB-INF/views/role-form.jsp"
                ).forward(request, response);

                break;

            case "excluir":

                int idExcluir =
                    Integer.parseInt(request.getParameter("id"));

                roleService.excluir(idExcluir);

                response.sendRedirect(
                    request.getContextPath() + "/roles"
                );

                break;

            default:

                request.setAttribute(
                    "roles",
                    roleService.listarTodos()
                );

                request.getRequestDispatcher(
                    "/WEB-INF/views/role-list.jsp"
                ).forward(request, response);
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        Role role = new Role();

        role.setNome(request.getParameter("nome"));
        role.setDescricao(request.getParameter("descricao"));
        role.setLocal(request.getParameter("local"));
        role.setCidade(request.getParameter("cidade"));

       String dataParam = request.getParameter("data");

if (dataParam != null && !dataParam.isBlank()) {
    role.setData(LocalDate.parse(dataParam));
} else {
    role.setData(null);
}

        role.setCategoria(
            request.getParameter("categoria")
        );

        role.setValor(
            Double.parseDouble(request.getParameter("valor"))
        );

        if (id == null || id.isBlank()) {

            roleService.cadastrar(role);

        } else {

            role.setId(Integer.parseInt(id));

            roleService.atualizar(role);
        }

        response.sendRedirect(
            request.getContextPath() + "/roles"
        );
    }
}