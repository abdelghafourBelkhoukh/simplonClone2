<%@ page import="com.simplonclone.simplonclone2.entity.Brief" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.simplonclone.simplonclone2.entity.Promos" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 29/10/2022
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>apprenant</title>
</head>
<body>
<%@include file="../components/header.jsp" %>

<div class="container mx-auto  dark:text-gray-100 h-[90vh] px-60 pt-10">
    <h2 class="mb-4 text-2xl font-semibold leading-tight">brief Table</h2>
    <div class="overflow-x-auto">
        <table class="w-full p-6 text-xs text-left whitespace-nowrap">
            <colgroup>
                <col class="w-5">
                <col>
                <col class="w-5">
            </colgroup>
            <thead>
            <tr class="dark:bg-gray-700">
                <th class="p-3 text-center">Name</th>
                <th class="p-3 text-center">Description</th>
                <th class="p-3 text-center">promo</th>
            </tr>
            </thead>
            <tbody class="border-y dark:bg-gray-900 dark:border-gray-700 ">


            <% ArrayList<Brief> briefs = (ArrayList<Brief>) request.getAttribute("briefs");


                for  (Brief brief : briefs) {%>
                <tr class="dark:bg-gray-700">
                    <td class="p-3 text-center"><%= brief.getName() %></td>
                    <td class="p-3 text-center"><%= brief.getDescription() %></td>
                    <td class="p-3 text-center"><%= brief.getPromosByPromoId().getName() %></td>

<%--                    <td class="p-3 text-center">--%>
<%--                        <form action="/ApprenantServlet" method="post">--%>
<%--                            <input type="hidden" name="action" value="assignBriefToPromo">--%>
<%--                            <input type="hidden" name="briefId" value="<%=brief.getId()%>">--%>
<%--                            <select name="promoId">--%>
<%--                                <option value="0">Select a promo</option>--%>
<%--                                <% ArrayList<Promos> promos = (ArrayList<Promos>) request.getAttribute("promos");--%>
<%--                                    for (Promos promo : promos) {%>--%>
<%--                                <option value="<%=promo.getId()%>"><%=promo.getName()%></option>--%>
<%--                                <%}%>--%>
<%--                            </select>--%>
<%--                            <button type="submit" class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-black border border-transparent rounded-lg active:bg-blue-600 hover:bg-blue-700 focus:outline-none focus:shadow-outline-blue">Assign</button>--%>
<%--                        </form>--%>
<%--                    </td>--%>

                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>



<%@include file="../components/footer.jsp" %>
</body>
</html>
