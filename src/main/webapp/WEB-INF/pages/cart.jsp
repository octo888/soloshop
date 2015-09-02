<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layouts/taglib.jsp" %>


    <table class="table table-bordered table-hover table-striped">
        <thead>
        <tr>
            <th>Номер</th>
            <th>Цена</th>
            <th>Действие</th>
            <th>Действие</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>
                    <a href="/book/${item.id}">${item.name}</a>
                </td>

                <td>
                    <p>${item.price}</p>
                </td>

                <td>
                    <a href="" class="btn btn-primary">Оформить</a>
                </td>

                <td>
                    <a href='<spring:url value="/cart/remove/${item.id}"  />'
                        class="btn btn-danger triggerRemove">
                        Удалить </a>

                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>
<h4><strong>Итого:</strong> ${sum} грн.</h4>

