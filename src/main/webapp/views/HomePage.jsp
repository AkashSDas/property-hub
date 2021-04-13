<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <title>Home</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/design/style.css"
      type="text/css"
    />
  </head>

  <body>
    <jsp:include page="Navbar.jsp" />

    <main>
        <jsp:include page="Tagline.jsp" />

        <div class="hr"></div>

        <jsp:include page="PropertySearchBar.jsp" />

        <section class="home-page-property-list">
            <h2>Properties List</h2>

            <div class="property-list">
                <c:forEach items="${properties}" var="property">
                    <!-- <h2 onclick="window.location='property-info'">${property.getTitle()}</h2> -->
                    <form class="form" action="property-info" method="GET">
                        <div class="wrapper">
                            <img src="${property.getCoverImageUrl()}" alt="${property.getTitle()}">

                            <div class="property-info">
                                <h3>${property.getTitle()}</h3>
                                <p class="info">${property.getDescription()}</p>
                                <p class="price-info">$${property.getMinPrice()} - $${property.getMaxPrice()}
                                </p>
                                <div class="btn-grp">
                                    <button class="green-btn">${property.getStatus()}</button>
                                    <button type="submit" class="black-btn">Read more...</button>
                                </div>
                            </div>
                        </div>
                        <input name="propertyId" type="hidden" value="${property.getId()}" />
                    </form>
                </c:forEach>
            </div>
        </section>
    </main>

    <jsp:include page="Footer.jsp" />
  </body>
</html>
