<%@include file="taglib.jsp"%>
<c:set var="title" value="Quest Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
  $(document).ready( function () {
    $( '#questTable').DataTable();
  } );
</script>

<html><body>

<div class="container-fluid">
  <h2>Quest Search Results: </h2>
  <table id="questTable" class="display" cellspacing="0" width="100%">
    <thead>
    <th>Name</th>
    <th>Area</th>
    <th>Level Requirement</th>
    <th>XP</th>
    <th>Reward</th>
    </thead>
    <tbody>
    <c:forEach var="quest" items="${quests}">
      <tr>
        <td>${quest.quest_name}</td>
        <td>${quest.quest_area}</td>
        <td>${quest.quest_level_requirement}</td>
        <td>${quest.quest_xp}</td>
        <td>${quest.quest_reward}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
