<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>About Us</title>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/design/style.css"
      type="text/css"
    />
  </head>

  <body>
    <jsp:include page="Navbar.jsp" />

    <main>
      <h2 class="loans-h2">About Us</h2>

      <div class="hr"></div>

      <jsp:include page="Tagline.jsp" />

      <p class="about-us">
        Launched in 1999, PropertyHub is World's No. 1 property portal, deals
        with every aspect of the consumers needs in the real estate industry. It
        is an online forum where buyers, sellers and brokers/agents can exchange
        information about real estate properties quickly, effectively and
        inexpensively. At PropertyHub, you can advertise a property, search for
        a property, browse through properties, and keep yourself updated with
        the latest news and trends making headlines in the realty sector.
      </p>
    </main>

    <jsp:include page="Footer.jsp" />
  </body>
</html>
