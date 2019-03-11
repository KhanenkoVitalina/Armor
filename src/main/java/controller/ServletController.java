package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class ServletController extends HttpServlet {
    private Controller controller;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        controller = new Controller(req, resp);
        Optional<String> typeOfArmor = Optional.ofNullable(req.getParameter("armor"));
        Optional<String> basket = Optional.ofNullable(req.getParameter("basket"));
        controller.setUpListOfIltems();
        basket.ifPresent(s -> controller.setBasketWindow());
        typeOfArmor.ifPresent(s -> controller.setListOfArmor(s));
        controller.getConnection();
        req.getRequestDispatcher("views/armorlist.jsp").forward(req, resp);
    }




}
