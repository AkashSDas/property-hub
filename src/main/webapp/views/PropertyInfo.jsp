<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Property Info</title>
        </head>

        <body>
            <jsp:include page="Navbar.jsp" />

            <main>
                <h2>${property.getTitle()}</h2>
                <p>${property.getDescription()}</p>
                <span>${property.getStatus()}</span>

                <div>
                    <c:forEach items="${propertyImageUrls}" var="url">
                        <img src="${url}" alt="${property.getTitle()}">
                    </c:forEach>
                </div>

                <p><strong>Address: </strong> ${property.address}</p>

                <div>
                    <img src="${propertyOwner.getOwnerImageUrl()}"
                        alt="${propertyOwner.getFirstName()} ${propertyOwner.getLastName()}">

                    <p>Owner of this property is ${propertyOwner.getFirstName()} ${propertyOwner.getLastName()} who can
                        be
                        contacted
                        using the owner's phone number ${propertyOwner.getPhoneNumber()}

                        <c:if test="${propertyOwner.getEmail() != null}">
                            or using email address ${propertyOwner.getEmail()}
                        </c:if>.
                    </p>
                </div>

                <div>
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
            </main>
        </body>

        </html>
