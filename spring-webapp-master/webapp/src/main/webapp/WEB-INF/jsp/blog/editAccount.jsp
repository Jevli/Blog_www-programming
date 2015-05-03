<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../../init.jspf" %>


<body>

<div class="table">
    <table class="userDataTable">
        <tr><td colspan= "3" style="font-weight: bold !important;"><h3>Henkilötiedot</h3></td></tr>
        <tr><td>Nimi</td><td class="editable" id="first name">${editUser.firstName} </td> <td class="editable" id="last name"> ${editUser.lastName}</td></tr>
        <tr><td>S-posti</td><td colspan= "2" class="editable" id="email address">${editUser.email}</td></tr>
        <tr><td>Puhelin</td><td colspan= "2" class="editable" id="mobile number">${editUser.mobile}</td></tr>

        <tr><td colspan="3" style="font-weight: bold !important;"><h3>Metatiedot</h3></td></tr>
        <tr><td>Luotu </td><td colspan= "2"><joda:format pattern="dd.MM.yyyy" value="${editUser.createdOn}" /></td></tr>

        <tr><td>Muokattu </td><td colspan= "2"><joda:format pattern="dd.MM.yyyy" value="${editUser.modifiedOn}" /></td></tr>

    </table>
</div>

<script>
    $('.editable')
        .css('cursor', 'pointer')
        .click(
            function(e){
                input = prompt("Change: " + e.target.id);
                if(input === null) {
                    return;
                }

                switch(e.target.id) {
                    case "first name":
                        updateFirstName(input);
                        break;
                    case "last name":
                        updateLastName(input);
                        break;
                    case "email address":
                        updateEmail(input);
                        break;
                    case "mobile number":
                        updateMobile(input);
                        break;
                }
            }
        )
        .hover(
            function () {
                $(this).css('background', '#ff00ff');
            },
            function(){
                $(this).css('background', '');
            }
        ) ;

    function updateFirstName(input) {
        $.ajax({
            url: "${pageContext.request.contextPath}/user/updateFirstName/${editUser.id}/" + input,
            type: 'POST'
        });
        window.location.reload();
    }

    function updateLastName(input) {
        $.ajax({
            url: "${pageContext.request.contextPath}/user/updateLastName/${editUser.id}/" + input,
            type: 'POST'
        });
        window.location.reload();
    }

    function updateEmail(input) {
        $.ajax({
            url: "${pageContext.request.contextPath}/user/updateEmail/${editUser.id}/" + input,
            type: 'POST'
        });
        window.location.reload();
    }

    function updateMobile(input) {
        $.ajax({
            url: "${pageContext.request.contextPath}/user/updateMobile/${editUser.id}/" + input,
            type: 'POST'
        });
        window.location.reload();
    }

</script>

</body>