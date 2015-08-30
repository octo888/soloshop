<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layouts/taglib.jsp" %>

<div class="row">

  <div class="col-1"></div>

  <div class="col-3">
    <img src="/image/${book.image.id}" height="300" width="250">

  </div>

  <div class="col-3">
    <h5 class="well well-sm"><strong>Название:</strong> ${book.name}</h5>
    <h5 class="well well-sm"><strong>Автор:</strong> ${book.author}</h5>
    <h5 class="well well-sm"><strong>Издательство:</strong> ${book.publisher}</h5>
    <h5 class="well well-sm"><strong>Год издания:</strong> ${book.publishYear}</h5>
    
  </div>

  <div class="col-3">
    <h5 class="well well-sm"><strong>ISBN:</strong> ${book.isbn}</h5>
    <h5 class="well well-sm"><strong>Жанр:</strong> ${book.genre}</h5>
    <h5 class="well well-sm"><strong>Переплет:</strong> ${book.cover}</h5>
    <h5 class="well well-sm"><strong>Цена:</strong> ${book.price}</h5>
  </div>



</div>
<br />

<div class="row">

  <div class="col-1"></div>

  <div class="col-2" >

    <p><a href="#" class="btn btn-success btn-lg" role="button">Купить одним кликом</a></p>


    <p><a href="#" class="btn btn-success btn-lg" role="button">В корзину</a></p>

  </div>

  <div class="col-7 well">
    <p>
      ${book.longDesc}
    </p>
  </div>
</div>