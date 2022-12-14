<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Transaction" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Meals</title>
</head>

<body>
<a href="meals?action=create">Add Meal</a>
<br><br>
<table>
    <caption>Calories table</caption>
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th colspan=2>Action</th>
    </tr>

<%--    <%--%>
<%--        ArrayList<Transaction> tran = (ArrayList<Transaction>) request.getAttribute("mealList");--%>
<%--        for(Transaction transaction : tran){--%>
<%--            System.out.println(transaction.getAccount_from());--%>
<%--        }--%>
<%--    %>--%>
    <c:forEach items="${mealList}" var="mealTo">
        <tr>
            <th>${mealTo.sum}</th>
            <th>${mealTo.currency_shortname}</th>
            <th>${mealTo.account_from}</th>
        </tr>
    </c:forEach>
</table>

</body>
</html>