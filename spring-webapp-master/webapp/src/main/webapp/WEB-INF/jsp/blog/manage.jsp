<%@ include file="../../init.jspf" %>

<h1>List of oll database users</h1>

<table>
<tr><th>Id</th><th>Username</th><th>Role</th><th>New role</th><th>Delete</th></tr>

<c:forEach items="${users}" var="user" >

<tr><td>${user.id}</td><td>${user.userName}</td><td>${user.securityRoles}</td>
    <td>
    <a href='<spring:url value="/account/assignrole" htmlEscape="true"/>/${user.id}/ROLE_SUPERUSER'>Superuser</a><br />
    <a href='<spring:url value="/account/assignrole" htmlEscape="true"/>/${user.id}/ROLE_USER'>User</a><br />
    </td>
    <td><a href='<spring:url value="/blog/editAccount" htmlEscape="true"/>/${user.id}'>Edit</a></td>
    <td><a href='<spring:url value="/account/deleteUser" htmlEscape="true"/>/${user.id}'>Delete</a></td>
</tr>




</c:forEach>
</table>