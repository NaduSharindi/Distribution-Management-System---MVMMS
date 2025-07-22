<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<script >

$(document).ready(function () {
	  $('#dtBasicExample').DataTable();
	  $('.dataTables_length').addClass('bs-select');
	});
<!--

//-->
</script>
<html>
<head>
<style>
div.main{
	width: 400px;
	margin: 100px auto 0px auto;
}

h2{
	text-align: center;
	padding: 20px;
	font-family: sans-serif;
}

div.register{
	background-color: maroon;
	width: 100%;
	font-size: 18px;
	border-radius: 10px;
	border: 1px solid rgba(255,255,255,0.3);
	box-shadow: 2px 2px 15px rgba(0,0,0,0.3);
	color: #fff;
}

form#register{
	margin: 40px;
}

label{
	font-family: sans-serif;
	font-size: 18px;
	font-style: italic;
}

input#name{
	width: 300px;
	border: 1px solid #ddd;
	border-radius: 3px;
	outline: 0;
	padding: 7px;
	background-color: #fff;
	box-shadow: inset 1px 1px 5px rgba(0,0,0,0.3);
}

input#submit{
	width: 200px;
	padding: 7px;
	font-size: 16px;
	font-family: sans-serif;
	font-weight: 600;
	border-radius: 3px;
	background-color: maroon;
	color: #fff;
	cursor: pointer;
	border: 1px solid rgba255,255,255,0.3;
	box-shadow: 1px 1px 5px rgba(0,0,0,0.3);
}

label,span,h2{
	text-shadow: 1px 1px 5px rgba(0,0,0,0.3);
}


  .select,
  #locale {
    width: 100%;
  }
  .like {
    margin-right: 10px;
  }

</style>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/newstyles.css"/>" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/dataTables.bootstrap.min.css">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" />
	 <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/bootstrap-3.3.7-dist/css/dataTables.bootstrap.min.css"/>" />
	
 
  
  
  <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/font-awesome.css"/>" />
 
 <link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/font-awesome.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/nanoscroller.css"/>" />

<!-- global styles -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/compiled/theme_styles.css"/>" />

<!-- this page specific styles -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/fullcalendar.css"/>" />
<link rel="stylesheet" type="text/css" media="print"
	href="<c:url value="/resources/css/libs/fullcalendar.print.css" />" />
<link rel="stylesheet" type="text/css" media="screen"
	href="<c:url value="/resources/css/compiled/calendar.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/morris.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/daterangepicker.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/jquery-jvectormap-1.2.2.css"/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/libs/jquery-jvectormap-1.2.2.css"/>" />

<!-- Favicon -->
<link type="image/x-icon" href="favicon.png" rel="shortcut icon" />

<!-- google font libraries -->
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,600,700,300|Titillium+Web:200,300,400'
	rel='stylesheet' type='text/css'>
  <!--  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" href="https://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">-->
  
 
 <!-- <script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery.dataTables.min.js" type="text/javascript"></script>
  --> 
<script src="<c:url value="/resources/js/jquery.min.js"/>"></script>
<script type = "text/javascript" charset="utf8" src="/resources/js/jquery.dataTables.js"> </script>

 <script src="<c:url value="/resources/js/jquery.dataTables.min.js"/>"></script>
 
 

<%@ include file="sections/head.jsp"%>
<%@ include file="sections/dashboardCSS.jsp"%>

</head>
<body>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="https://unpkg.com/tableexport.jquery.plugin/tableExport.min.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table.min.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.18.3/dist/bootstrap-table-locale-all.min.js"></script>
<script src="https://unpkg.com/bootstrap-table@1.18.3/dist/extensions/export/bootstrap-table-export.min.js"></script>


<script src="/resources/js/bootstrap.min.js"></script>
	<script src="/resources/js/dataTables.bootstrap.min.js"></script>
	<script src="/resources/js/jquery.js"></script>
	<script src="/resources/js/jquery.dataTables.min.js"></script>
	
	<div id="theme-wrapper">

		<%@ include file="sections/header.jsp"%>

		<div id="page-wrapper" class="container">
			<div class="row">

				<%@ include file="sections/userLevels.jsp"%>

				<div id="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="col-lg-9">
								
							</div>

							<%@ include file="sections/userDetails.jsp"%>
						</div>
					</div>
					
					<!-- <div class="container">
					 --><div class="row">
						<div class="col-lg-12">
					
					
 					</div>
  					</div>
  					<div class="main">
		<div class="register">
			<h2> REGISTER HERE</h2>
			<form id = "register" method="post">
				<label> First Name: </label>
				<br>
				<input type="text" name="fname" id="name" placeholder="Enter Your First Name" required />
				<br><br>
				<label> Last Name: </label>
				<br>
				<input type="text" name="lname" id="name" placeholder="Enter Your Last Name" required />
				<br><br>
				<label> Age: </label>
				<br>
				<input type="number" name="age" id="name" placeholder="Your Age">
				<br><br>
				<label> NIC: </label>
				<br>
				<input type="number" name="nic" id="name" placeholder="Your NIC">
				<br><br>
				<label> Email: </label>
				<br>
				<input type="email" name="email" id="name" placeholder="Enter A Valid Email" 
				pattern="/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/" required />
				<br><br>
				<label> Address: </label>
				<br>
				<textarea id="w3review" name="w3review" rows="4" cols="30">
  				</textarea>
				<br><br>
				<label> University: </label>
				<br>
				<input type="text" name="uni" id="name" placeholder="Your University">
				<br><br>
				<label> Specialisation: </label>
				<br>
				<input type="text" name="specialisation" id="name" placeholder="Add Your Specialisation">
				<br><br>
				<label> Gender: </label>
				<br>
				&nbsp; &nbsp; &nbsp;
				<input type="radio" name="gender" id="male">
				&nbsp;
				<span id="male"> Male </span>
				&nbsp; &nbsp; &nbsp;
				<input type="radio" name="gender" id="female">
				&nbsp;
				<span id="female"> Female </span>
				<br><br>
				<label> Languages Known: </label>
				<br>
				&nbsp; &nbsp; &nbsp;
				<input type="checkbox" name="lang" id="english">
				&nbsp;
				<span id="male"> English </span>
				&nbsp; &nbsp; &nbsp;
				<input type="checkbox" name="lang" id="sinhala">
				&nbsp;
				<span id="male"> Sinhala </span>
				&nbsp; &nbsp; &nbsp;
				<input type="checkbox" name="lang" id="tamil">
				&nbsp;
				<span id="male"> Tamil </span>
				<br><br>
				<input type="submit" name="submit" value="Submit" id="submit">
			</form>
</div>
</div>
					
					<h1>Remarks</h1>
                     <textarea id="w3review" name="w3review" rows="20" cols="150"></textarea>
					
					<!-- hello 
					<div class="select">
  <select class="form-control" id="locale">
    <option value="af-ZA">af-ZA</option>
    <option value="ar-SA">ar-SA</option>
    <option value="ca-ES">ca-ES</option>
    <option value="cs-CZ">cs-CZ</option>
    <option value="da-DK">da-DK</option>
    <option value="de-DE">de-DE</option>
    <option value="el-GR">el-GR</option>
    <option value="en-US" selected>en-US</option>
    <option value="es-AR">es-AR</option>
    <option value="es-CL">es-CL</option>
    <option value="es-CR">es-CR</option>
    <option value="es-ES">es-ES</option>
    <option value="es-MX">es-MX</option>
    <option value="es-NI">es-NI</option>
    <option value="es-SP">es-SP</option>
    <option value="et-EE">et-EE</option>
    <option value="eu-EU">eu-EU</option>
    <option value="fa-IR">fa-IR</option>
    <option value="fi-FI">fi-FI</option>
    <option value="fr-BE">fr-BE</option>
    <option value="fr-FR">fr-FR</option>
    <option value="he-IL">he-IL</option>
    <option value="hr-HR">hr-HR</option>
    <option value="hu-HU">hu-HU</option>
    <option value="id-ID">id-ID</option>
    <option value="it-IT">it-IT</option>
    <option value="ja-JP">ja-JP</option>
    <option value="ka-GE">ka-GE</option>
    <option value="ko-KR">ko-KR</option>
    <option value="ms-MY">ms-MY</option>
    <option value="nb-NO">nb-NO</option>
    <option value="nl-NL">nl-NL</option>
    <option value="pl-PL">pl-PL</option>
    <option value="pt-BR">pt-BR</option>
    <option value="pt-PT">pt-PT</option>
    <option value="ro-RO">ro-RO</option>
    <option value="ru-RU">ru-RU</option>
    <option value="sk-SK">sk-SK</option>
    <option value="sv-SE">sv-SE</option>
    <option value="th-TH">th-TH</option>
    <option value="tr-TR">tr-TR</option>
    <option value="uk-UA">uk-UA</option>
    <option value="ur-PK">ur-PK</option>
    <option value="uz-Latn-UZ">uz-Latn-UZ</option>
    <option value="vi-VN">vi-VN</option>
    <option value="zh-CN">zh-CN</option>
    <option value="zh-TW">zh-TW</option>
  </select>
</div>

<div id="toolbar">
  <button id="remove" class="btn btn-danger" disabled>
    <i class="fa fa-trash"></i> Delete
  </button>
</div>
<div>
<table
  id="table"
  data-toolbar="#toolbar"
  data-search="true"
  data-show-refresh="true"
  data-show-toggle="true"
  data-show-fullscreen="true"
  data-show-columns="true"
  data-show-columns-toggle-all="true"
  data-detail-view="true"
  data-show-export="true"
  data-click-to-select="true"
  data-detail-formatter="detailFormatter"
  data-minimum-count-columns="2"
  data-show-pagination-switch="true"
  data-pagination="true"
  data-id-field="id"
  data-page-list="[10, 25, 50, 100, all]"
  data-show-footer="true"
  data-side-pagination="server"
  data-url="https://examples.wenzhixin.net.cn/examples/bootstrap_table/data"
  data-response-handler="responseHandler">
</table>
</div>
<script>
  var $table = $('#table')
  var $remove = $('#remove')
  var selections = []

  function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
      return row.id
    })
  }

  function responseHandler(res) {
    $.each(res.rows, function (i, row) {
      row.state = $.inArray(row.id, selections) !== -1
    })
    return res
  }

  function detailFormatter(index, row) {
    var html = []
    $.each(row, function (key, value) {
      html.push('<p><b>' + key + ':</b> ' + value + '</p>')
    })
    return html.join('')
  }

  function operateFormatter(value, row, index) {
    return [
      '<a class="like" href="javascript:void(0)" title="Like">',
      '<i class="fa fa-heart"></i>',
      '</a>  ',
      '<a class="remove" href="javascript:void(0)" title="Remove">',
      '<i class="fa fa-trash"></i>',
      '</a>'
    ].join('')
  }

  window.operateEvents = {
    'click .like': function (e, value, row, index) {
      alert('You click like action, row: ' + JSON.stringify(row))
    },
    'click .remove': function (e, value, row, index) {
      $table.bootstrapTable('remove', {
        field: 'id',
        values: [row.id]
      })
    }
  }

  function totalTextFormatter(data) {
    return 'Total'
  }

  function totalNameFormatter(data) {
    return data.length
  }

  function totalPriceFormatter(data) {
    var field = this.field
    return '$' + data.map(function (row) {
      return +row[field].substring(1)
    }).reduce(function (sum, i) {
      return sum + i
    }, 0)
  }

  function initTable() {
    $table.bootstrapTable('destroy').bootstrapTable({
      height: 550,
      locale: $('#locale').val(),
      columns: [
        [{
          field: 'state',
          checkbox: true,
          rowspan: 2,
          align: 'center',
          valign: 'middle'
        }, {
          title: 'Item ID',
          field: 'id',
          rowspan: 2,
          align: 'center',
          valign: 'middle',
          sortable: true,
          footerFormatter: totalTextFormatter
        }, {
          title: 'Item Detail',
          colspan: 3,
          align: 'center'
        }],
        [{
          field: 'name',
          title: 'Item Name',
          sortable: true,
          footerFormatter: totalNameFormatter,
          align: 'center'
        }, {
          field: 'price',
          title: 'Item Price',
          sortable: true,
          align: 'center',
          footerFormatter: totalPriceFormatter
        }, {
          field: 'operate',
          title: 'Item Operate',
          align: 'center',
          clickToSelect: false,
          events: window.operateEvents,
          formatter: operateFormatter
        }]
      ]
    })
    $table.on('check.bs.table uncheck.bs.table ' +
      'check-all.bs.table uncheck-all.bs.table',
    function () {
      $remove.prop('disabled', !$table.bootstrapTable('getSelections').length)

      // save your data, here just save the current page
      selections = getIdSelections()
      // push or splice the selections if you want to save all data selections
    })
    $table.on('all.bs.table', function (e, name, args) {
      console.log(name, args)
    })
    $remove.click(function () {
      var ids = getIdSelections()
      $table.bootstrapTable('remove', {
        field: 'id',
        values: ids
      })
      $remove.prop('disabled', true)
    })
  }

  $(function() {
    initTable()

    $('#locale').change(initTable)
  })
</script>
-->
					<%@ include file="sections/footer.jsp"%>
					
					</div>
					</div>
					 </div>
					 </div>
				

	<%@ include file="sections/global_scripts.jsp"%>


</body>
</html>