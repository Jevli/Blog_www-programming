<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../../init.jspf" %>


<body>

<div class="table">
    <table class="userDataTable">
        <tr><td colspan= "3" style="font-weight: bold !important;"><h3>Henkilötiedot</h3></td></tr>
        <tr><td>Nimi</td><td class="editable">${editUser.firstName} </td> <td class="editable"> ${editUser.lastName}</td></tr>
        <tr><td>S-posti</td><td colspan= "2" class="editable">${editUser.email}</td></tr>
        <tr><td>Puhelin</td><td colspan= "2" class="editable">${editUser.mobile}</td></tr>
        <tr><td>Synt.aika</td><td colspan= "2" class="editable"><joda:format pattern="dd.MM.yyyy" value="${editUser.dateOfBirth}" /></td></tr>

        <tr><td colspan="3" style="font-weight: bold !important;"><h3>Metatiedot</h3></td></tr>
        <tr><td>Luotu </td><td colspan= "2" class="editable"><joda:format pattern="dd.MM.yyyy" value="${editUser.createdOn}" />.</td></tr>

        <tr><td>Muokattu </td><td colspan= "2" class="editable"><joda:format pattern="dd.MM.yyyy" value="${editUser.modifiedOn}" />.</td></tr>

    </table>
</div>

<script>
    $('.editable').click(function(){
    alert('test!');
    return false;
});
</script>

</body>