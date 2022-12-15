<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Transactions</title>
</head>
<body>
<a href="transactions?action=create">Add transaction</a>
<br><br>
<table>
    <caption>Transactions table</caption>
    <tr>
        <th>id</th>
        <th>userId</th>
        <th>account_from</th>
        <th>account_to</th>
        <th>currency_shortname</th>
        <th>sum</th>
        <th>expense_category</th>
        <th>datetime</th>
        <th>limit_exceeded</th>
        <th colspan=2>Action</th>
    </tr>
    <c:forEach items="${transactionsList}" var="transaction">
        <tr>
            <th>${transaction.id}</th>
            <th>${transaction.userId}</th>
            <th>${transaction.account_from}</th>
            <th>${transaction.account_to}</th>
            <th>${transaction.currency_shortname}</th>
            <th>${transaction.sum}</th>
            <th>${transaction.expense_category}</th>
            <th>${transaction.datetime}</th>
            <th>${transaction.limit_exceeded}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>