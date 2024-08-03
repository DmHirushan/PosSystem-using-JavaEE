package lk.ijse.gdse.pos.pos.cotroller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.pos.pos.bo.CustomerBo;
import lk.ijse.gdse.pos.pos.bo.CustomerBoImpl;
import lk.ijse.gdse.pos.pos.dto.CustomerDto;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer", loadOnStartup = 2)
public class CustomerController extends HttpServlet {

    Connection connection;
    CustomerBo customerBo = new CustomerBoImpl();

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Init method Invoked");
        try {
            InitialContext ctx = new InitialContext();
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/pos");
            this.connection = pool.getConnection();
            System.out.println("Connection initialized: " + this.connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost method Invoked");

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }else {
            try(var writer = resp.getWriter()){
                Jsonb jsonb = JsonbBuilder.create();
                CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);
                writer.write(customerBo.saveCustomer(customerDto, connection));
            }catch (Exception e){

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()){
            Jsonb jsonb = JsonbBuilder.create();
            var customerId = req.getParameter("id");
            resp.setContentType("application/json");
            jsonb.toJson(customerBo.getCustomer(customerId, connection), writer);
        }catch (Exception e){
            
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()){
            var customerId = req.getParameter("id");
            Jsonb jsonb = JsonbBuilder.create();
            CustomerDto customerDto = jsonb.fromJson(req.getReader(), CustomerDto.class);
            if (customerBo.updateCustomer(customerId, customerDto, connection)){
                writer.write("Customer Update Successfully!");
            }else {
                writer.write("Something went wrong!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(var writer = resp.getWriter()){
            var customerId = req.getParameter("id");
            if (customerBo.deleteCustomer(customerId, connection)){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                writer.write("Customer Deleted Successfully!");
            }else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.write("Something went wrong!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
