package pe.isil.servlet;

import pe.isil.dao.ProductDAO;
import pe.isil.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/producto", loadOnStartup = 2, name = "producto")
public class ProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        crear(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        String action = req.getParameter("action");

        if (action == null){
            listar(req, resp);
        }else{
            switch (action){
                case "nuevo":
                    nuevo(req, resp);
                    break;
                case "update":
                    update(req, resp);
                    break;
                case "delete":
                    delete(req, resp);
                    break;
                default:
                    listar(req, resp);
                    break;
            }
        }

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));

        Product product = new Product();
        product.setId(id);
        ProductDAO.delete(product);
        listar(req, resp);
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void crear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("txtName");
        String category = req.getParameter("txtCategory");
        String price1 = req.getParameter("txtPrice");
        System.out.println("price1 = " + price1);

        Double price = Double.parseDouble(price1);
        Product product = new Product(null, name, category, price);
        ProductDAO.create(product);
        listar(req, resp);
    }

    private void nuevo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("product-create.jsp").forward(req, resp);
    }


    private void listar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = ProductDAO.getAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/product.jsp").forward(req, resp);
    }
}
