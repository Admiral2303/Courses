<%@ page import="com.gmail.vadimv41.model.Publication" %>
<%@ page import="com.gmail.vadimv41.model.ScientificPublication" %>
<%@ page import="java.util.List" %>
<%@ page import="com.gmail.vadimv41.model.ScientificBook" %><%--
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
    <link rel="stylesheet" type="text/css" href="./css/page.css">

</head>
<body>
    <div class="container container-table text-center">
        <div class="row vertical-center-row">
            <div class="col-md-8 col-md-offset-2">
                <div class="jumbotron h-center" id="center">
                    <form action="searchPublication" method="GET">
                        <div class="form-group">
                            <label for="name" class="control-label">Search</label>
                            <input type="search" class="form-control" id="name" name="name"
                                   placeholder= "Enter data">
                            <b> Sort:</b>
                            <select name="sortCriteria" size="1">
                                <option value="" selected disabled hidden></option>
                                <option>date</option>
                                <option>page_count</option>
                            </select>
                            <b> Search param:</b>
                            <select name="searchCriteria" size="1">
                                <option>title</option>
                                <option>min page count</option>
                            </select>
                            <input style="margin-top: 1%;" type="submit" value="Search"/>
                        </div>

                        <hr style="border: 1px solid grey;" />
                    </form>
                    <%
                        String errorMessage = (String) request.getAttribute("error");
                        if(errorMessage != null) {
                            out.print("<p style=\"color:red;\">" + errorMessage + "</p>");
                        }
                    %>
                </div>
            </div>
        </div>
    </div>
    <%
        List<Publication> publicationList = (List<Publication>) request.getAttribute("publications");

        if (publicationList != null) {
            for(Publication pub: publicationList) {
                if(pub instanceof ScientificPublication) {
    %>
        <div class="col-md-6 col-xs-12 bookcontainer product">
            <div class="row">
                <div class="col-md-10 text-center" style="margin-top:-5%; margin-left: 5%; font-family: 'Oswald', sans-serif;font-weight: normal;text-transform: uppercase;">
                    <h2 class="book-name"><%=pub.getTitle()%></h2>
                    <p>Publish date - <%=pub.getPublishDate().toString()%><br></p>
                    <p>Author name - <%=pub.getAuthor().getName()%><br></p>
                    <p>Author surname - <%=pub.getAuthor().getSurname()%></p>
                    <p>Author birthday - <%=pub.getAuthor().getBirthday().toString()%></p>
                    <p>Page count - <%=pub.getPageCount()%></p>
                    <p>Subject - <%=((ScientificPublication) pub).getSubject()%></p>
                    <h4>Publication links</h4>
                    <%for(Publication p: ((ScientificPublication) pub).getListOfPublications()) {%>
                    <p>Publication Title - <%=p.getTitle()%></p>
                    <% } %>
                </div>

            </div>
        </div>
    <% } else if (pub instanceof ScientificBook) {%>
    <div class="col-md-6 col-xs-12 bookcontainer product">

        <div class="row">
            <div class="col-md-10 text-center" style="margin-top:-5%; margin-left: 5%; font-family: 'Oswald', sans-serif;font-weight: normal;text-transform: uppercase;">
                <h2 class="book-name"><%=pub.getTitle()%></h2>
                <p>Publish date - <%=pub.getPublishDate().toString()%><br></p>
                <p>Author name - <%=pub.getAuthor().getName()%><br></p>
                <p>Author surname - <%=pub.getAuthor().getSurname()%></p>
                <p>Author birthday - <%=pub.getAuthor().getBirthday().toString()%></p>
                <p>Page count - <%=pub.getPageCount()%></p>
                <p>Cost - <%=((ScientificBook) pub).getCost()%></p>
                <p>Introduction - <%=((ScientificBook) pub).getIntroduction()%></p>
            </div>
        </div>
    </div>
    <% } %>
   <%}
   }
   %>
</body>
</html>
