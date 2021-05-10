package datos;

import dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoJDBC {
    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo FROM cliente WHERE id_cliente = ?";
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, email, telefono, saldo) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre = ?, apellido = ?, email = ?, telefono = ?, saldo = ? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(ClienteDaoJDBC.SQL_SELECT);
            rs = pst.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            assert rs != null;
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }

        return clientes;
    }

    public Cliente encontrar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(ClienteDaoJDBC.SQL_SELECT_BY_ID);
            pst.setInt(1, cliente.getIdCliente());
            rs = pst.executeQuery();

            rs.absolute(1); //nos posicionamos en el primer registro devuleto
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            assert rs != null;
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(conn);
        }

        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pst = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(ClienteDaoJDBC.SQL_INSERT);

            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getEmail());
            pst.setString(4, cliente.getTelefono());
            pst.setDouble(5, cliente.getSaldo());

            rows = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            assert pst != null;
            Conexion.close(pst);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pst = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(ClienteDaoJDBC.SQL_UPDATE);

            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellido());
            pst.setString(3, cliente.getEmail());
            pst.setString(5, cliente.getTelefono());
            pst.setDouble(5, cliente.getSaldo());
            pst.setInt(6, cliente.getIdCliente());

            rows = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            assert pst != null;
            Conexion.close(pst);
            Conexion.close(conn);
        }

        return rows;
    }

    public int eliminar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement pst = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            pst = conn.prepareStatement(ClienteDaoJDBC.SQL_DELETE);

            pst.setInt(1, cliente.getIdCliente());

            rows = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            assert pst != null;
            Conexion.close(pst);
            Conexion.close(conn);
        }

        return rows;
    }
}
