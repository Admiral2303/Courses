<%@ page import="com.gmail.vadimv41.model.Publication" %>
<%@ page import="com.gmail.vadimv41.model.ScientificPublication" %><%--
  Created by IntelliJ IDEA.
  User: vadim
  Date: 16.06.19
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta charset="utf-8">
    <title>Пошук</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
            <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

</head>
<body>
<center>
    <div class="container container-table text-center">
        <div class="row vertical-center-row">
            <div class="col-md-8 col-md-offset-2">
                <div class="jumbotron h-center" id="center">
                    <form action="/searchbook" method="GET">
                        <div class="form-group">
                            <label for="name" class="control-label">Search</label>
                            <input type="search" class="form-control  " id="name" name="name"
                                   placeholder="Enter data">
                        </div>
                        <div class="form-group">
                            <select name="Type" size="1">
                                <option>WINE</option>
                                <option>WHISKY</option>
                                <option>BEER</option>
                            </select>
                        </div>
                        <input type="hidden" name="page" value="1">
                        <input type="submit" value="OK"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <h1>
        Select the type of Liquor
    </h1>
    <form method="post" action="SelectLiquor">
        <br>
        <select name="Type" size="1">
            <option>WINE</option>
            <option>WHISKY</option>
            <option>BEER</option>

        </select>
        <br><br>
        <input type="submit">
    </form>
    <%
        ScientificPublication pb = (ScientificPublication) request.getAttribute("publication");
        if (pb != null) {
            out.println("<b>" + pb.getTitle() + "</b>");
        }
    %>
</center>


</body>
</html>
