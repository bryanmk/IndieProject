<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<html>
    <body>
        <div class="container-fluid bg-light">
            <%@include file="header.jsp"%>
            <main class="p-3 row">
                <img src="images/WoW-map.jpg" class="col-md-9 mb-3" alt="WoWmap">
                <article class="card px-0 mb-3 col-md-3">
                    <h2 class="card-header bg-dark text-light text-center">99 Problems</h2>
                    <div class="card-body">
                        <p class="card-text">
                            In WoW classic you receive an immense amount of quests with nothing but a vague description to go on.
                            It can take eons to figure out where you need to go and specifically what you need to do in order to complete quests.

                            The purpose of this application is to make life for an old school gamer just a little bit easier.


                            As it currently stands, this site essentially serves as a large database with quests and some useful
                            information about them. In the future I have plans to do a number of things to continue to make things
                            in the realm easier and easier.
                        </p>
                        <ul class="card-text list-unstyled text-center">
                            <li class="fw-bold">Make this map to the left interactive </li>
                            <p>
                                I'd like to be able to click on a continent, which then zooms in, so you can view all areas.
                                From there you can select an area, and it will take you to the database filtered to view quests in that area.
                            </p>
                            <li class="fw-bold">Add a user profile page</li>
                            <p>
                                Here you can save things like completed quests, favorite quests, as
                                well as have a little bit of "what if" functionality. How much gold will I get if I complete
                                quests X, Y, and Z?
                            </p>
                            <li class="fw-bold">Add links to each quest</li>
                            <p>
                                Each quest will have its own page that contains a map with highlighted indicators of
                                where to start the quest and where to hand it in once you're finished, as well as have a
                                description of how to complete the quest and what you get for doing so.
                            </p>
                        </ul>
                    </div>
                </article>
                <article class="card">
                    <h2 class="card-header bg-dark text-light text-center">Matt Bryan Individual Project</h2>
                    <div class="card-body text-center">
                        <ul class="list-unstyled">### Project Technologies/Techniques
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
                            <li>JUnit tests to achieve 80%+ code coverage</li>
                            <li>IDE: IntelliJ IDEA</li>
                        </ul>
                    </div>
                </article>
            </main>
        </div>
    </body>
</html>