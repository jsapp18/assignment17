import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ComputeLoanServlet")
public class ComputeLoanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //gets the inputs
        double amount = Double.parseDouble(request.getParameter("amount"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        int years = Integer.parseInt(request.getParameter("years"));
        //makes the loan
        Loan loan = new Loan(rate, years, amount);

        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();
        //output
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Loan Calculator Result</title></head><body>");
        out.println("<h1>Loan Calculator Result</h1>");
        out.println("<p>Loan Amount: " + amount + "</p>");
        out.println("<p>Annual Interest Rate: " + rate + "</p>");
        out.println("<p>Number of Years: " + years + "</p>");
        out.println("<p>Monthly Payment: " + String.format("%.2f", monthlyPayment) + "</p>");
        out.println("<p>Total Payment: " + String.format("%.2f", totalPayment) + "</p>");
        out.println("</body></html>");
    }
}