<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../layouts/taglib.jsp" %>

<form role="form" class="form-horizontal addBookForm" action="/add/order"
      method="post">

  <div class="form-group">
    <label for="username" class="col-sm-2 control-label">Ф.И.О.:</label>

    <div class="col-sm-8">
      <input type="text" id="username" class="form-control" name="username" placeholder="Имя Фамилия">
    </div>
  </div>

  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email:</label>

    <div class="col-sm-8">
      <input type="email" id="email" class="form-control" name="email" placeholder="email">
    </div>
  </div>

  <div class="form-group">
    <label for="phone" class="col-sm-2 control-label">Телефон:</label>

    <div class="col-sm-8">
      <input type="text" id="phone" class="form-control" name="phone" placeholder="Телефон">
    </div>
  </div>

  <div class="form-group">
    <label for="city" class="col-sm-2 control-label">Город:</label>

    <div class="col-sm-8">
      <input type="text" id="city" class="form-control" name="city" placeholder="Город">
    </div>
  </div>

  <div class="form-group">
    <label for="address" class="col-sm-2 control-label">Адрес доставки:</label>

    <div class="col-sm-8">
      <textarea id="address" class="form-control" name="address" rows="3"></textarea>
    </div>
  </div>

  <div class="form-group">
    <div class="col-sm-10">
      <input type="submit" class="btn btn-primary pull-right" value="Добавить">
    </div>
  </div>
</form>