package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import manager.PaymentManager;
import model.CardPayment;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String method = req.getParameter("method");
        String amountText = req.getParameter("amount");

        try {
            if (method == null || method.trim().isEmpty() ||
                    amountText == null || amountText.trim().isEmpty()) {
                res.sendError(400, "Please enter all payment details.");
                return;
            }

            double amount = Double.parseDouble(amountText);

            if (amount <= 0) {
                res.sendError(400, "Enter a valid amount.");
                return;
            }

            CardPayment payment = new CardPayment(amount, method);
            new PaymentManager().addPayment(payment);

            res.sendRedirect(req.getContextPath() + "/payment.jsp?status=success");

        } catch (NumberFormatException e) {
            res.sendError(400, "Amount must be a valid number.");
        }
    }
}


