package web;

import model.Transaction;
import repository.InMemoryTransactionsRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Servlet который имитирует прием транзакций и отображает список всех транзакций.
 */
public class TransactionsServlet extends HttpServlet {
    private InMemoryTransactionsRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.repository = new InMemoryTransactionsRepository();
        this.repository.save(new Transaction(1, 1111111111L, 2222222222L,
                "USD",11.2, "product", LocalDateTime.now()), 1);
        this.repository.save(new Transaction(1, 3333333333L, 4444444444L,
                "KZT", 22.3, "service", LocalDateTime.now()), 1);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action == null ? "all" : action){
            case "create":
                Transaction transaction = repository.save(new Transaction(1, 0L, 0L,
                        "", 0.0, "", LocalDateTime.now()), 1);
                request.setAttribute("transaction", transaction);
                request.getRequestDispatcher("/transactionForm.jsp").forward(request, response);
                break;
            case "all":
            default:
                request.setAttribute("transactionsList", repository.getAll(1));
                request.getRequestDispatcher("/transactions.jsp").forward(request, response);
                break;
        }
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        Transaction transaction = new Transaction(Integer.parseInt(id),
                Integer.parseInt(request.getParameter("userId")),
                Long.parseLong(request.getParameter("account_from")),
                Long.parseLong(request.getParameter("account_to")),
                request.getParameter("currency_shortname"),
                Double.parseDouble(request.getParameter("sum")),
                request.getParameter("expense_category"),
                LocalDateTime.parse(request.getParameter("dateTime")));

        repository.save(transaction, 1);
        response.sendRedirect("transactions");
    }
}
