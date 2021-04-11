<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Loans</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/design/style.css" type="text/css">
        </head>

        <body>
            <jsp:include page="Navbar.jsp" />

            <main>
                <h2>Bank Loans</h2>

                <section class="loan">
                    <c:forEach items="${loans}" var="loan">
                        <div class="wrapper">
                            <img src="${loan.getBankLogoImageUrl()}" alt="${loan.getBankName()}">

                            <div class="info">
                                <h3>${loan.getBankName()}</h3>
                                <div class="description">${loan.getDescription()}</div>
                                <div class="price-info">
                                    $${loan.getMinLoanAmount()} - $${loan.getMaxLoanAmount()}
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </section>
            </main>

            <jsp:include page="Footer.jsp" />
        </body>

        </html>
