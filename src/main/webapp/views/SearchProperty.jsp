<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Search Property</title>
        </head>

        <body>
            <jsp:include page="Navbar.jsp" />

            <h2>All properties</h2>

            <main>
                <c:forEach items="${properties}" var="property">
                    <h2>${property.getTitle()}</h2>
                </c:forEach>
            </main>
        </body>

        </html>
