
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>jQuery+Bootstrap手风琴折叠菜单代码</title>

<!--图标样式和布局-->
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
<script src="http://echarts.baidu.com/build/dist/echarts-all.js"></script>
<!-- <script src="./roma.js"></script> -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.bootcss.com/font-awesome/5.10.2/css/all.css" rel="stylesheet">

<!-- <link rel="stylesheet" type="text/css" href="menu.css"> -->
<!--公共样式-->
<link rel="stylesheet" type="text/css" href="./demo.css">

<style type="text/css">
	.demo{padding: 2em 0; background: #fff; left: 1px; width: 120px;}
	a:hover,a:focus{
		text-decoration: none;
		outline: none;
	}
	#accordion .panel{
		border: none;
		box-shadow: none;
		border-radius: 0;
		margin: 0 0 15px 10px;
	}
	#accordion .panel-heading{
		padding: 0;
		border-radius: 30px;
	}
	#accordion .panel-title a{
		display: block;
		padding: 12px 20px 12px 50px;
		background: #ebb710;
		font-size: 18px;
		font-weight: 600;
		color: #fff;
		border: 1px solid transparent;
		border-radius: 30px;
		position: relative;
		transition: all 0.3s ease 0s;
	}
	#accordion .panel-title a.collapsed{
		background: #fff;
		color: #0d345d;
		border: 1px solid #ddd;
	}
	#accordion .panel-title a:after,
	#accordion .panel-title a.collapsed:after{
		content: "\f107";
		font-family: fontawesome;
		width: 55px;
		height: 55px;
		line-height: 55px;
		border-radius: 50%;
		background: #ebb710;
		font-size: 25px;
		color: #fff;
		text-align: center;
		border: 1px solid transparent;
		box-shadow: 0 3px 10px rgba(0, 0, 0, 0.58);
		position: absolute;
		top: -5px;
		left: -20px;
		transition: all 0.3s ease 0s;
	}
	#accordion .panel-title a.collapsed:after{
		content: "\f105";
		background: #fff;
		color: #0d345d;
		border: 1px solid #ddd;
		box-shadow: none;
	}
	#accordion .panel-body{
		padding: 20px 25px 10px 9px;
		background: transparent;
		font-size: 14px;
		color: #8c8c8c;
		line-height: 25px;
		border-top: none;
		position: relative;
	}
	#accordion .panel-body p{
		padding-left: 25px;
		border-left: 1px dashed #8c8c8c;
	}
</style>
</head>
<body>

<div class="demo">
	<div class="container">
		<div class="row">
			<div class="col-md-offset-3 col-md-6">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
									Section 1
								</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nisl lorem, dictum id pellentesque at, vestibulum ut arcu. Curabitur erat libero, egestas eu tincidunt ac, rutrum ac justo. Vivamus condimentum laoreet lectus, blandit posuere tortor aliquam vitae. Curabitur molestie eros. </p>
							</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
									Section 2
								</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
							<div class="panel-body">
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nisl lorem, dictum id pellentesque at, vestibulum ut arcu. Curabitur erat libero, egestas eu tincidunt ac, rutrum ac justo. Vivamus condimentum laoreet lectus, blandit posuere tortor aliquam vitae. Curabitur molestie eros. </p>
							</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingThree">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
									Section 3
								</a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
							<div class="panel-body">
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent nisl lorem, dictum id pellentesque at, vestibulum ut arcu. Curabitur erat libero, egestas eu tincidunt ac, rutrum ac justo. Vivamus condimentum laoreet lectus, blandit posuere tortor aliquam vitae. Curabitur molestie eros. </p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>
