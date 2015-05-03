<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<body>

<h3>${editUser.firstName} ${editUser.lastName} (${editUser.userName})</h3>

<table class="userDataTable">
    <tr><td colspan="2" style="font-weight: bold !important;"><h3>Henkilötiedot</h3></td></tr>
    <tr><td>Nimi</td><td>${editUser.firstName} ${editUser.lastName}</td></tr>
    <tr><td>S-posti</td><td>${editUser.email}</td></tr>
    <tr><td>Puhelin</td><td>${editUser.mobile}</td></tr>
    <tr><td>Synt.aika</td><td><joda:format pattern="dd.MM.yyyy" value="${editUser.dateOfBirth}" /></td></tr>

    <tr><td colspan="2" style="font-weight: bold !important;"><h3>Metatiedot</h3></td></tr>
    <tr><td>Luotu </td><td><joda:format pattern="dd.MM.yyyy" value="${editUser.createdOn}" />.</td></tr>

    <tr><td>Muokattu </td><td><joda:format pattern="dd.MM.yyyy" value="${editUser.modifiedOn}" />.</td></tr>

</table>

</body>