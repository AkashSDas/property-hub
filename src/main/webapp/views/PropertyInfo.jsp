<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Property Info</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/design/style.css" type="text/css">
        </head>

        <body>
            <jsp:include page="Navbar.jsp" />

            <main>
                <section class="property-info">
                    <h2>${property.getTitle()}</h2>

                    <div class="hr"></div>

                    <p>${property.getDescription()}</p>

                    <div class="grid">
                        <c:forEach items="${propertyImageUrls}" var="url">
                            <img src="${url}" alt="${property.getTitle()}">
                        </c:forEach>
                    </div>

                    <p class="address"><strong>Address: </strong> ${property.address}</p>

                    <!-- Owner info -->
                    <div class="owner-info">
                        <img src="${propertyOwner.getOwnerImageUrl()}"
                            alt="${propertyOwner.getFirstName()} ${propertyOwner.getLastName()}">

                        <p>Owner of this property is ${propertyOwner.getFirstName()} ${propertyOwner.getLastName()} who
                            can
                            be
                            contacted
                            using the owner's phone number ${propertyOwner.getPhoneNumber()}

                            <c:if test="${propertyOwner.getEmail() != null}">
                                or using email address ${propertyOwner.getEmail()}
                            </c:if>.
                        </p>
                    </div>

                    <!-- Property status -->
                    <div class="status">
                        <c:choose>
                            <c:when test="${property.getStatus() == 'buy'}">
                                <button>Buy</button>
                            </c:when>
                            <c:when test="${property.getStatus() == 'rent'}">
                                <button>Rent</button>
                            </c:when>
                            <c:otherwise>
                                <button>Sold</button>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <div class="img-wrapper">
                        <img class="gif" src="${property.getGifUrl()}" alt="${property.getTitle()}">
                    </div>
                </section>
            </main>

            <jsp:include page="Footer.jsp" />
        </body>

        </html>
