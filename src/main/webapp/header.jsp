<header class="text-center text-black mb-0">
    <div class="jumbotron row">
        <img src="images/WoWlogo.png" class="col-2" alt="WoWlogo">
        <h1 class="col-10 align-self-center">WoW Quest Helper</h1>
    </div>
</header>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <h1 class="navbar-brand m-0 px-3">Questie</h1>
    <button type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" class="navbar-toggler" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle Navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse p-2" id="navbarNav">
        <ul class="navbar-nav">
            <li class="navbar-item"><a href="index.jsp" class="nav-link">Home</a></li>
            <li class="navbar-item"><a href="searchQuest" class="nav-link">Quests</a></li>
            <li class="navbar-item"><a href="searchUser" class="nav-link">Users</a></li>
            <li class="navbar-item"><a href="searchQuestAPI" class="nav-link">QuestsAPI</a></li>
        </ul>
        <ul class="navbar-nav ms-auto">
            <li class="navbar-item align-self-center">
                    <c:choose>
                    <c:when test="${empty userName}">
                        <a href = "logIn" class="navbar-link text-decoration-none"><i class="bi bi-pencil-square pe-1"></i>Log in</a>
                    </c:when>
                    <c:otherwise>
                        <h4 class="navbar-item">Welcome ${userName}</h4>
                    </c:otherwise>
                </c:choose></a>
            </li>
        </ul>
    </div>
</nav>

