<html>
<head>
<link rel="stylesheet" href="css/wro.css"/>
</head>
<body>
<#if RequestParameters['error']??>
	<div class="alert alert-danger">
		There was a problem logging in. Please try again.
	</div>
</#if>
	<div class="container">
		<form role="form" action="login" method="post">
		  <div class="form-group">
		    <label for="username">用户名:</label>
		    <input type="text" class="form-control" id="username" name="username"/>
		  </div>
		  <div class="form-group">
		    <label for="password">密码:</label>
		    <input type="password" class="form-control" id="password" name="password"/>
		  </div>
		  <button type="submit" class="btn btn-primary">提交</button>
		  
		</form>
	</div>
	<script src="js/wro.js" type="text/javascript"></script>
</body>
</html>