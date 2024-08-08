package lk.ijse.gdse.pos.pos.controller;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.pos.pos.bo.OrderBo;
import lk.ijse.gdse.pos.pos.bo.OrderBoImpl;
import lk.ijse.gdse.pos.pos.bo.OrderDetailBo;
import lk.ijse.gdse.pos.pos.bo.OrderDetailBoImpl;
import lk.ijse.gdse.pos.pos.dto.OrderDetailDto;
import lk.ijse.gdse.pos.pos.dto.OrderDto;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/placeorder")
public class PlaceOrderFormController extends HttpServlet {
    Connection connection;
    OrderBo orderBo = new OrderBoImpl();
    OrderDetailBo orderDetailBo = new OrderDetailBoImpl();

    public void init() throws ServletException {
        System.out.println("Place Order Init method Invoked");
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
        if (req.getParameter("type").equals("order")){

            try{
                if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                }else {
                    try(var writer = resp.getWriter()){
                        Jsonb jsonb = JsonbBuilder.create();
                        OrderDto orderDto = jsonb.fromJson(req.getReader(), OrderDto.class);
                        System.out.println("order ek");
                        writer.write(orderBo.saveOrder(orderDto, connection));
                    }catch (Exception e){

                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else {
            try{
                if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                }else {
                    try(var writer = resp.getWriter()){
                        Jsonb jsonb = JsonbBuilder.create();
                        OrderDetailDto orderDetailDto = jsonb.fromJson(req.getReader(), OrderDetailDto.class);
                        writer.write(orderDetailBo.saveOrderDetail(orderDetailDto, connection));
                    }catch (Exception e){

                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }

}
