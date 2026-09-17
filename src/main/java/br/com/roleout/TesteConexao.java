package br.com.roleout;

import br.com.roleout.dao.RoleDAO;
import br.com.roleout.model.Role;

import java.util.List;

public class TesteConexao {

    public static void main(String[] args) {

        RoleDAO dao = new RoleDAO();

        // READ
        List<Role> roles = dao.listarTodos();

        System.out.println("=== LISTA DE ROLÊS ===");

        for (Role role : roles) {
            System.out.println(
                role.getId() + " - " +
                role.getNome() + " - " +
                role.getCidade() + " - R$ " +
                role.getValor()
            );
        }

        // UPDATE
        if (!roles.isEmpty()) {

            Role role = roles.get(0);

            role.setNome("Noite de Rock Atualizada");
            role.setValor(35.00);

            dao.atualizar(role);

            System.out.println("Rolê atualizado com sucesso!");

            // DELETE
             dao.excluir(role.getId());
             System.out.println("Rolê excluído com sucesso!");
        }
    }
}