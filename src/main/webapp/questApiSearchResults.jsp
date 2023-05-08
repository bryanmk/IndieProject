<%@include file="taglib.jsp"%>
<c:set var="title" value="Quest Search Results" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $( '#questTable').DataTable();
    } );
</script>

<html><body>

<div class="container-fluid bg-light">
    <h2>Quest Search Results: </h2>
    <table id="questTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>ID</th>
        <th>Title</th>
        <th>Level Requirement</th>
        <th>Area</th>
        <th>Experience</th>
        <th>Gold</th>
        <th>Silver</th>
        <th>Copper</th>
        </thead>
        <tbody>
        <c:forEach var="quest" items="${quests}">
            <tr>
                <td>${quest.id}</td>
                <td>${quest.title}</td>
                <td>${quest.levelRequirement}</td>
                <td>${quest.area}</td>
                <td>${quest.experience}</td>
                <td>${quest.gold}</td>
                <td>${quest.silver}</td>
                <td>${quest.copper}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>

