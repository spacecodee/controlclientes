package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
        System.out.println("Esto solo es una advertencia");
        req.setAttribute("clientes", clientes);
        req.setAttribute("totalClientes", clientes.size());
        req.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
        req.getRequestDispatcher("clientes.jsp").forward(req, resp);
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente :
                clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }
}