<%@include file="navigation.jsp"%>

<html><body text-align="center">

<br/>

<div class="container-fluid">

    <div class="center">

        <h2>New User Details</h2>

        <table>
            <tr>
                <th>First Name</th>
                <td>${firstname}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${lastname}</td>
            </tr>
            <tr>
                <th>Username</th>
                <td>${username}</td>
            </tr>
            <tr>
                <th>Password</th>
                <td>${password}</td>
            </tr>
        </table>

        <br /><br />

        <a class="btn btn-success btn-send" href="newUser.jsp">Back</a>

    </div>

</div>

</body>

</html>