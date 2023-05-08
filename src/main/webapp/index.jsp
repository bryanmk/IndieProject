<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<html>
    <body>
        <div class="container-fluid bg-light">
            <%@include file="header.jsp"%>

            <div class="row justify-content-center">
                <img src="images/WoW-map.jpg" class="col-md-9 mb-3 p-3" alt="WoWmap">
                <article class="card px-0 mb-3 col-md-3">
                    <h2 class="card-header text-white text-center">99 Problems</h2>
                    <div class="card-body">
                        <p>
                            In WoW classic you receive an immense amount of quests with nothing but a vague description to go on.
                            It can take eons to figure out where you need to go and specifically what you need to do in order to complete quests.
                        </p>
                    </div>
                </article>
        <%--        <form action="searchUser" class="form-inline mb-3 col-6">--%>
        <%--            <div class="form-group">--%>
        <%--                <label for="userSearchTerm">User Search</label>--%>
        <%--                <input type="text" class="form-control" id="userSearchTerm" name="userSearchTerm" aria-describedby="searchTermHelp" placeholder="">--%>
        <%--            </div>--%>
        <%--            <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>--%>
        <%--            <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all users</button>--%>
        <%--        </form>--%>
            <div>
                <article class="justify-content-center">
                    <h2>Matt Bryan Individual Project</h2>

                    <ul>### Project Technologies/Techniques (Not going to edit just yet)
                        <li>Security/Authentication</li>
                        <li>Tomcat's JDBC Realm Authentication</li>
                        <li>Database - MySQL 8.0.33</li>
                        <li>ORM Framework</li>
                        <li>Hibernate 5</li>
                        <li>Dependency Management</li>
                        <li>Maven</li>
                        <li>Web Services consumed using Java - A zillion Battlenet API's</li>
                        <li>Data Validation</li>
                        <li>Bootstrap and a little custom CSS for the front end</li>
                        <li>Logging - Log4J2</li>
                        <li>Hosting - AWS</li>
                        <li>CI tools in AWS</li>
                        <li>Materialize</li>
                        <li>Unit Testing</li>
                        <li>JUnit tests to achieve 80%+ code coverage</li>
                        <li>IDE: IntelliJ IDEA</li>
                    </ul>

                    <ul>### Design

                        <li>[User Stories](DesignDocuments/userStories.md)</li>
                        <li>[Tasks](DesignDocuments/tasks.md)</li>
                        <li>[Screen Design](DesignDocuments/Screens.md)</li>
                        <li>[Application Flow](DesignDocuments/applicationFlow.md)</li>
                        <li>[Database Design](DesignDocuments/databaseDiagram.png)</li>
                    </ul>
                </article>
            </div>
        </div>
    </body>
</html>