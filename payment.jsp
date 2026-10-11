
<!DOCTYPE html>
<html>
<head>
    <title>Movie Ticket Payment</title>
</head>
<body>
    <h2>Movie Ticket Payment</h2>

    <form action="PaymentServlet" method="POST">
        <label>Payment Method:</label>
        <select name="method" required>
            <option value="Card">Card</option>
            <option value="Cash">Cash</option>
        </select>

        <br><br>

        <label>Amount (Rs.):</label>
        <input type="number" name="amount"
               min="1" step="0.01" required>

        <br><br>

        <button type="submit">Pay</button>
    </form>
</body>
</html>
