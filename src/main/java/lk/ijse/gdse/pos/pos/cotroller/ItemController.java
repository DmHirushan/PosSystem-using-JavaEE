package lk.ijse.gdse.pos.pos.cotroller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.pos.pos.bo.ItemBo;
import lk.ijse.gdse.pos.pos.bo.ItemBoImpl;
import lk.ijse.gdse.pos.pos.dao.ItemDaoImpl;
import lk.ijse.gdse.pos.pos.dto.CustomerDto;
import lk.ijse.gdse.pos.pos.dto.ItemDto;

import javax.naming.ConfigurationException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item")
public class ItemController extends HttpServlet {

    Connection connection;

    ItemBo itemBo = new ItemBoImpl();

    @Override
    public void init() throws ServletException {
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
        try{
            if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }else {
                try(var writer = resp.getWriter()){
                    Jsonb jsonb = JsonbBuilder.create();
                    ItemDto itemDto = jsonb.fromJson(req.getReader(), ItemDto.class);
                    writer.write(itemBo.saveItem(itemDto, connection));
                }catch (Exception e){

                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
