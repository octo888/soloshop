<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layouts/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>Заказчик</th>
        <th>Сумма к оплате</th>
        <th>Телефон</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <p>${order.username}</p>
            </td>

            <td>
                <p>${order.orderSum} грн.</p>
            </td>

            <td>
                <p>${order.phone}</p>
            </td>

            <td>
                <p>${order.email}</p>
            </td>

        </tr>
    </tbody>
</table>
