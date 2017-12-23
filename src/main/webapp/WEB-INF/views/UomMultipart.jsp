<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uom MultiPart</title>
</head>
<body>
	<h1>Welcome to UomMultipart Operations</h1>
	<a href="uomExport">Export UomData</a>
	<hr/>
	<h1>Import Data Using Excel</h1>
	<form action="uomImport" method="post" enctype="multipart/form-data">
	<pre>
	  Select File:<input type="file" name="eFile"/>
	  <input type="submit" value="Import Uoms"/>
	</pre>
	</form>
	${importMessage}
</body>
</html>