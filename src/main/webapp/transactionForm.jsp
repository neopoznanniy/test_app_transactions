<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Transaction</title>
  <style>
    dl {
      background: none repeat scroll 0 0 #FAFAFA;
      margin: 8px 0;
      padding: 0;
    }
    dt {
      display: inline-block;
      width: 170px;
    }
    dd {
      display: inline-block;
      margin-left: 8px;
      vertical-align: top;
    }
  </style>
</head>
<body>
<section>
  <h3><a href="index.html">Home</a></h3>
  <hr>
  <jsp:useBean id="transaction" type="model.Transaction" scope="request"/>
  <form method="post" action="transactions">
    <input type="hidden" name="id" value="${transaction.id}">
    <input type="hidden" name="userId" value="${transaction.userId}">
    <input type="hidden" name="dateTime" value="${transaction.datetime}">
    <dl>
      <dt>account_from:</dt>
      <dd><input type="number" value="${transaction.account_from}" size=10 name="account_from" required></dd>
    </dl>
    <dl>
      <dt>account_to:</dt>
      <dd><input type="number" value="${transaction.account_to}" size=10 name="account_to" required></dd>
    </dl>
    <dl>
      <dt>currency_shortname:</dt>
      <dd><input type="text" value="${transaction.currency_shortname}" size=10 name="currency_shortname" required></dd>
    </dl>
    <dl>
      <dt>sum:</dt>
      <dd><input type="number" step="0.01" value="${transaction.sum}" name="sum" required></dd>
    </dl>
    <dl>
      <dt>expense_category:</dt>
      <dd><input type="text" value="${transaction.expense_category}" size=10 name="expense_category" required></dd>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()" type="button">Cancel</button>
  </form>
</section>
</body>
</html>
