package ir.maktabsharif.onlinestoreproductviewer;

import ir.maktabsharif.model.Product;
import ir.maktabsharif.service.Product.ProductServiceImpl;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class AffordableProducts extends HttpServlet {
    private ProductServiceImpl service;

    public void init(ServletConfig config) throws ServletException {
        this.service = new ProductServiceImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();

        List<Product> products = service.AffordableProducts();

        out.println("<center>");

        out.println("<h2>All products</h2>");

        products.forEach(p -> out.println("<li>"+p+"</li>"));

        out.println("<a href=\"./index.jsp\">go back</a>");
        out.println("</center>");

    }
}
