<%@ include file = "common/header.jspf" %>
<%@ include file = "common/navigation.jspf" %>


<div class = "container">

    <h1>Enter todo details</h1>
    <form:form method = "post" modelAttribute = "todo">

        <div class = "mb-3">

            <label for = "description" class = "form-label">Description</label>
            <form:input type = "text" path = "description" class = "form-control" id = "description" name = "description" required = "required"/>
            <form:errors path = "description" cssClass = "text-warning"/>
        </div>

        <div class = "mb-3">
            <label for = "targetDate" class = "form-label">Target Date</label>
            <form:input type = "date" path = "targetDate" class = "form-control" id ="targetDate" name = "targetDate" required = "required"/>

        </div>

        <button type = "submit" class = "btn btn-success w-100">Submit</button>

    </form:form>



</div>




<%@ include file = "common/footer.jspf" %>