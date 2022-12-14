package web;

import model.Transaction;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionsServlet extends HttpServlet {
    private List<Transaction> repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.repository = new ArrayList<Transaction>();
        this.repository.add(new Transaction(1, 1.1, "USE", true));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action == null ? "all" : action){
//            case "create":
//            case "update":
//                String strId = request.getParameter("id");
//                Integer id = strId == null ? null : Integer.parseInt(strId);
//                Meal meal = id == null ? repository.save(new Meal(LocalDateTime.now(), "", 1)) :
//                        repository.getById(id);
//                request.setAttribute("meal", meal);
//                request.getRequestDispatcher("/mealForm.jsp").forward(request, response);
//                break;
//            case "delete":
//                repository.delete(Integer.parseInt(request.getParameter("id")));
            case "all":
            default:
//                LOG.info("getAll");
                repository.add(new Transaction(1, 1.4, "FOR", false));
                request.setAttribute("mealList", repository);
                request.getRequestDispatcher("/meals.jsp").forward(request, response);
                break;
        }
    }
}
