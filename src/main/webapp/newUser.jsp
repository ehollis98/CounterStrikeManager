<%@include file="navigation.jsp"%>
<html>

<head>
    <title>New User Form</title>
</head>

<body>

<div>

    <h2 class="center">Enter New User Information</h2>

    <form action="newUser" method="post" id="userForm" class="center">

        <label class="control-label">First name:</label> <input class="form-control" type="text" name="firstName">

        <br/><br/>
        <label class="control-label">Last name:</label> <input class="form-control" type="text" name="lastName">

        <br/><br/>
        <label class="control-label">Username:</label> <input class="form-control" type="text" name="username">

        <br/><br/>
        <label class="control-label">Password:</label> <input class="form-control" type="text" name="password">

        <br/><br/>

        <input type="submit" class="btn btn-success" value="Submit">
        <input type="reset" class="btn btn-primary" value="Clear" />

    </form>

    <br/>

    <div class="center">
        <a href="logout.jsp" class="btn btn-success btn-send">Logout</a>
    </div>

</div>

</body>

</html>