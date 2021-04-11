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
                <h2>Search Results</h2>

                <div>
                    <c:choose>
                        <c:when test="${properties.size() != 0}">
                            <c:forEach items="${properties}" var="property">
                                <section class="home-page-property-list">
                                    <div class="property-list">
                                        <c:forEach items="${properties}" var="property">
                                            <!-- <h2 onclick="window.location='property-info'">${property.getTitle()}</h2> -->
                                            <form class="form" action="property-info" method="GET">
                                                <div class="wrapper">
                                                    <img src="${property.getCoverImageUrl()}"
                                                        alt="${property.getTitle()}">

                                                    <div class="property-info">
                                                        <h3>${property.getTitle()}</h3>
                                                        <p class="info">${property.getDescription()}</p>
                                                        <p class="price-info">$${property.getMinPrice()} -
                                                            $${property.getMaxPrice()}
                                                        </p>
                                                        <div class="btn-grp">
                                                            <button class="green-btn">${property.getStatus()}</button>
                                                            <button type="submit" class="black-btn">Read
                                                                more...</button>
                                                        </div>
                                                    </div>
                                                </div>
                                                <input name="propertyId" type="hidden" value="${property.getId()}" />
                                            </form>
                                        </c:forEach>
                                    </div>
                                </section>

                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <h3 class="no-result">🙁 No properties available for this location.</h3>
                        </c:otherwise>
                    </c:choose>

                </div>
            </main>

            <jsp:include page="Footer.jsp" />
        </body>

        </html>
