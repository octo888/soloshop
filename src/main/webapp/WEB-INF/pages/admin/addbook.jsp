<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../../layouts/taglib.jsp" %>

<form role="form" enctype="multipart/form-data" class="form-horizontal addBookForm" action="/admin/addbook"
      method="post">

    <div class="form-group">
        <label for="bookName" class="col-sm-2 control-label">Название:</label>

        <div class="col-sm-8">
            <input type="text" id="bookName" class="form-control" name="name" placeholder="Название">
        </div>
    </div>
    <div class="form-group">
        <label for="author" class="col-sm-2 control-label">Автор:</label>

        <div class="col-sm-8">
            <input type="text" id="author" class="form-control col-sm-8" name="author" placeholder="Автор">
        </div>
    </div>
    <div class="form-group">
        <label for="bookDescription" class="col-sm-2 control-label">Описание:</label>

        <div class="col-sm-8">
            <textarea id="bookDescription" class="form-control" name="description" rows="5"></textarea>
        </div>
    </div>

    <div class="form-group">
        <label for="price" class="col-sm-2 control-label">Цена:</label>

        <div class="col-sm-8">
            <input type="number" id="price" class="form-control" name="price" >
        </div>
    </div>

    <div class="form-group">
        <label for="publisher" class="col-sm-2 control-label">Издательство:</label>

        <div class="col-sm-8">
            <input type="text" id="publisher" class="form-control" name="publisher" placeholder="Издатель">
        </div>
    </div>

    <div class="form-group">
        <label for="publishYear" class="col-sm-2 control-label">Год издания:</label>

        <div class="col-sm-8">
            <input type="text" id="publishYear" class="form-control" name="publishYear" placeholder="Год">
        </div>
    </div>

    <div class="form-group">
        <label for="isbn" class="col-sm-2 control-label">ISBN:</label>

        <div class="col-sm-8">
            <input type="text" id="isbn" class="form-control" name="isbn" >
        </div>
    </div>

    <div class="form-group">
        <label for="cover" class="col-sm-2 control-label">Переплет:</label>

        <div class="col-sm-8">
            <input type="text" id="cover" class="form-control" name="cover" >
        </div>
    </div>

    <div class="form-group">
      <label for="selectGenre" class="col-sm-2 control-label">Жанр:</label>

      <div class="col-sm-8">
        <form:select path="genres"  name="selectGenre" cssClass="form-control">
          <form:option value="" label="--- Select ---"/>
          <form:options items="${genres}"/>
        </form:select>
      </div>
    </div>

    <div class="form-group">
        <label for="bookImage" class="col-sm-2 control-label">Изображение:</label>

        <div class="col-sm-8">
            <input class="form-control" type="file" id="bookImage" name="image"></div>
    </div>
    <div class="form-group">
        <div class="col-sm-10">
            <input type="submit" class="btn btn-primary pull-right" value="Добавить">
        </div>
    </div>
</form>
