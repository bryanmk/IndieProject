<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<html>
<body>
<div class="container">

    <h2>Questie Searches</h2>
    <br><br>
        <c:choose>
            <c:when test="${empty userName}">
                <a href = "logIn">Log in</a>
            </c:when>
            <c:otherwise>
                <h3>Welcome ${userName}</h3>
            </c:otherwise>
        </c:choose>
    <br><br>
        <form action="searchUser" class="form-inline">
            <div class="form-group">
                <label for="userSearchTerm">User Search</label>
                <input type="text" class="form-control" id="userSearchTerm" name="userSearchTerm" aria-describedby="searchTermHelp" placeholder="">
            </div>
            <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
            <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all users</button>
        </form>
    <br><br>
        <form action="searchQuest" class="form-inline">
            <div class="form-group">
                <label for="questSearchTerm">Quest Search</label>
                <input type="text" class="form-control" id="questSearchTerm" name="questSearchTerm" aria-describedby="searchTermHelp" placeholder="">
            </div>
            <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
            <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all quests</button>
        </form>
    <br><br>
        <form action="searchQuestAPI" class="form-inline">
            <div class="form-group">
                <label for="questApiSearchTerm">API Quest Search</label>
                <input type="text" class="form-control" id="questApiSearchTerm" name="questApiSearchTerm" aria-describedby="searchTermHelp" placeholder="">
            </div>
            <button type="submit" name="submit" value="search" class="btn btn-primary">Search</button>
            <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View all quests</button>
        </form>
</div>
</body>
</html>