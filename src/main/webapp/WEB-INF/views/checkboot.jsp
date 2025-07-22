<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
  <!--  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">-->
    <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap-4.3.1-dist/css/bootstrap.min.css" />" />
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
    <title>Hello, world!</title>
  </head>
  <body>
      <div class="container mb-3 mt-3">
         <table class="table table-striped table-bordered mydatatable" style="width:100%">
             <thead>
                 <tr>
                 <th>uu</th>
                 <th>First</th>
                 <th>Last</th>
                 <th>Handle</th>
                 <th>Last</th>
                 <th>Handle</th></tr>
             </thead>
             
             <tbody>
                 <tr>
                     <td>aaa</td>
                     <td>bbb</td>
                     <td>ccc</td>
                     <td>ddd</td>
                     <td>eee</td>
                     <td>fff</td>
                     
                 </tr>
                 <tr>
                     <td>ggg</td>
                     <td>hhh</td>
                     <td>iii</td>
                     <td>jjj</td>
                     <td>kkk</td>
                     <td>lll</td>
                     
                 </tr>
                 <tr>
                     <td>mmm</td>
                     <td>nnn</td>
                     <td>ooo</td>
                     <td>ppp</td>
                     <td>qqq</td>
                     <td>rrr</td>
                     
                 </tr>
                 <tr>
                     <td>sss</td>
                     <td>ttt</td>
                     <td>uuu</td>
                     <td>vvv</td>
                     <td>www</td>
                     <td>xxx</td>
                     
                 </tr>
             </tbody>
             
             
             <tfoot>
                 <tr>
                 <th>uu</th>
                 <th>First</th>
                 <th>Last</th>
                 <th>Handle</th>
                 <th>Last</th>
                 <th>Handle</th></tr>
             </tfoot>
          </table>
      </div>
      
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
      <!--  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>-->
      <script src="/resources/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
      
      
      <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
      <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
      
      <script>
           $('.mydatatable').DataTable();
      </script>
</body>
</html>