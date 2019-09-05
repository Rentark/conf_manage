<html>
<head>
    <title>Conference Management Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="../css/styles.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="images/favicon.ico">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <form action="register" method="POST" class="form-horizontal" style="margin:20px 0 200px 0">
                <fieldset>
                    <legend class="text-center">Registration Form</legend>
                    <div class="form-group">
                        <label class="col-md-2 control-label">userName</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="username"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">Password</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="password" name="userpass"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">firstName</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="firstName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-2 control-label">lastName</label>
                        <div class="col-md-8">
                            <input class="form-control input-md" type="text" name="lastName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-3 col-md-offset-2">
                            <button type="submit" name="register-btn" class="btn btn-primary form-control">Register</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>

</body>
</html>
