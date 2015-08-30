<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layouts/taglib.jsp" %>

<div class="row">

    <div class="col-1"></div>
    <div class="col-sm-10">
        <ul class="thumbnails">

            <c:forEach items="${books}" var="book">
                <li class="col-4" >
                    <div class="thumbnail">
                        <a href="/book/${book.id}" >
                            <img  src="/image/${book.image.id}" height="300" width="200"
                                 align="center">
                        </a>

                        <div class="label label-success price">
                            <span class="glyphicon glyphicon-tag"></span> <sup>$</sup>${book.price}</div>

                        <div class="caption">
                            <h4 class="hideOverflow">${book.name}</h4>

                            <p id="desc" >${book.shortDesc}</p>

                            <p class="hideOverflow"><a href="/book/${book.id}" class="btn btn-primary" role="button">Купить</a>
                                <a href="/book/${book.id}" class="btn btn-success" role="button">В корзину</a>
                                <a href="/book/${book.id}" class="btn btn-small btn-link" role="button">Подробнее..</a></p>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </div>
    <div class="col-1"></div>
</div>
