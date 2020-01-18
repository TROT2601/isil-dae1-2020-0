package pe.isil.servlet;

import pe.isil.dao.UserDAO;
import pe.isil.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1, name = "login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        String txtLogin = req.getParameter("txtLogin");
        String txtPassword = req.getParameter("txtPassword");

        req.setAttribute("login", txtLogin);
        req.setAttribute("password", txtPassword);

        User user =  UserDAO.isValidLogin(txtLogin, txtPassword);

        if(user != null){

            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            req.getRequestDispatcher("/home.jsp").forward(req, resp);

        }else{

            req.setAttribute("errorMessage", "bad credentials");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);

        }

    }



}
