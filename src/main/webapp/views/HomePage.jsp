<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>Home</title>
        </head>

        <body>
            <jsp:include page="Navbar.jsp" />

            <main>
                <jsp:include page="Tagline.jsp" />
                <jsp:include page="PropertySearchBar.jsp" />

                <section>
                    <h2>Properties List</h2>
                    <div>
                        <c:forEach items="${properties}" var="property">
                            <!-- <h2 onclick="window.location='property-info'">${property.getTitle()}</h2> -->
                            <a href="property-info">
                                <form action="property-info" method="GET">
                                    <button type="submit">
                                        <h2>${property.getTitle()}</h2>
                                        <img src="${property.getCoverImageUrl()}" alt="${property.getTitle()}">
                                    </button>
                                    <input name="propertyId" type="hidden" value="${property.getId()}" />
                                </form>
                            </a>
                        </c:forEach>
                    </div>
                </section>
            </main>
        </body>

        </html>
