<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Search Property</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/design/style.css" type="text/css">
        </head>

        <body>
            <jsp:include page="Navbar.jsp" />

            <main>
                <h2>All properties</h2>

                <div>
                    <c:choose>
                        <c:when test="${properties.size() != 0}">
                            <c:forEach items="${properties}" var="property">
                                <h2>${property.getTitle()}</h2>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <h3>🙁 No properties available for this location.</h3>
                        </c:otherwise>
                    </c:choose>

                </div>
            </main>

            <jsp:include page="Footer.jsp" />
        </body>

        </html>
