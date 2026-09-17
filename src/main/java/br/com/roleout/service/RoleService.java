package br.com.roleout.service;

import br.com.roleout.dao.RoleDAO;
import br.com.roleout.model.Role;

import java.util.List;

public class RoleService {

    private final RoleDAO roleDAO = new RoleDAO();

    public void cadastrar(Role role) {
        validar(role);
        roleDAO.inserir(role);
    }

    public List<Role> listarTodos() {
        return roleDAO.listarTodos();
    }

    public void atualizar(Role role) {
        if (role.getId() <= 0) {
            throw new IllegalArgumentException("ID do rolê inválido.");
        }

        validar(role);
        roleDAO.atualizar(role);
    }

    public void excluir(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do rolê inválido.");
        }

        roleDAO.excluir(id);
    }

    public Role buscarPorId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID do rolê inválido.");
        }

        return roleDAO.buscarPorId(id);
    }

    public List<Role> buscarSugestoes(
            String categoria,
            String cidade,
            double valorMaximo) {

        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("A categoria é obrigatória.");
        }

        if (cidade == null || cidade.isBlank()) {
            throw new IllegalArgumentException("A cidade é obrigatória.");
        }

        if (valorMaximo < 0) {
            throw new IllegalArgumentException("O orçamento não pode ser negativo.");
        }

        return roleDAO.buscarSugestoes(
            categoria,
            cidade,
            valorMaximo
        );
    }

    private void validar(Role role) {

        if (role == null) {
            throw new IllegalArgumentException("Rolê não pode ser nulo.");
        }

        if (role.getNome() == null || role.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do rolê é obrigatório.");
        }

        if (role.getCidade() == null || role.getCidade().isBlank()) {
            throw new IllegalArgumentException("A cidade é obrigatória.");
        }

        if (role.getValor() < 0) {
            throw new IllegalArgumentException("O valor não pode ser negativo.");
        }
    }
}
