<%@ page import="com.simplonclone.simplonclone2.entity.Formateur" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.simplonclone.simplonclone2.entity.Apprenant" %>
<%@ page import="com.simplonclone.simplonclone2.entity.Promos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Admin Page</title>
</head>
<body>
<%@include file="../components/header.jsp" %>

<div class="w-full h-auto">
<div>
    <div class="container p-2 mx-auto sm:p-4 dark:text-gray-100">
        <h2 class="mb-4 text-2xl font-semibold leading-tight">Formateurs Table</h2>
        <div class="overflow-x-auto">
            <table class="w-full p-6 text-xs text-left whitespace-nowrap">
                <colgroup>
                    <col class="w-5">
                    <col>
                    <col>
                    <col class="w-5">
                </colgroup>
                <thead>
                <tr class="dark:bg-gray-700">
                    <th class="p-3 text-center">First Name</th>
                    <th class="p-3 text-center">Last Name</th>
                    <th class="p-3 text-center">Email</th>
                    <th class="p-3 text-center">Assign to promo</th>
                </tr>
                </thead>
                <tbody class="border-y dark:bg-gray-900 dark:border-gray-700 ">


       <% ArrayList<Formateur> formateurs = (ArrayList<Formateur>) request.getAttribute("formateurs");


            for (Formateur formateur : formateurs) {%>

                <tr>
                    <td class="px-3 py-2 text-center">
                        <p><%=formateur.getFirstname()%></p>
                    </td>
                    <td class="px-3 py-2 text-center">
                        <span><%=formateur.getLastname()%></span>
                    </td>
                    <td class="px-3 py-2 text-center">
                        <p><%=formateur.getEmail()%></p>
                    </td>
                    <td class="px-3 py-2 text-center">

                        <form action="/AdminServlet" method="post">
                            <input type="hidden" name="action" value="assignFormateurToPromo">
                            <input type="hidden" name="formateurId" value="<%=formateur.getId()%>">
                            <select name="promoId">
                                <option value="0">Select a promo</option>
                                <% ArrayList<Promos> promos = (ArrayList<Promos>) request.getAttribute("promos");
                                for (Promos promo : promos) {%>
                                <option value="<%=promo.getId()%>"><%=promo.getName()%></option>
                                <%}%>
                            </select>
                            <button type="submit" class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-black border border-transparent rounded-lg active:bg-gray-600 hover:bg-blue-700 focus:outline-none focus:shadow-outline-blue">Assign</button>
                        </form>

                    </td>
                </tr>

        <%}%>
                </tbody>
            </table>
        </div>
    </div>


    <div class="container p-2 mx-auto sm:p-4 dark:text-gray-100">
        <h2 class="mb-4 text-2xl font-semibold leading-tight">Apprenant Table</h2>
        <div class="overflow-x-auto">
            <table class="w-full p-6 text-xs text-left whitespace-nowrap">
                <colgroup>
                    <col class="w-5">
                    <col>
                    <col>
                    <col class="w-5">
                </colgroup>
                <thead>
                <tr class="dark:bg-gray-700">
                    <th class="p-3 text-center">First Name</th>
                    <th class="p-3 text-center">Last Name</th>
                    <th class="p-3 text-center">Email</th>
                    <th class="p-3 text-center">Assign to promo</th>
                </tr>
                </thead>
                <tbody class="border-y dark:bg-gray-900 dark:border-gray-700 ">


       <% ArrayList<Apprenant> apprenants = (ArrayList<Apprenant>) request.getAttribute("apprenants");


            for (Apprenant apprenant : apprenants) {%>

                <tr>
                    <td class="px-3 py-2 text-center">
                        <p><%=apprenant.getFirstname()%></p>
                    </td>
                    <td class="px-3 py-2 text-center">
                        <span><%=apprenant.getLastname()%></span>
                    </td>
                    <td class="px-3 py-2 text-center">
                        <p><%=apprenant.getEmail()%></p>
                    </td>
                    <td class="px-3 py-2 text-center">

                            <form action="/AdminServlet" method="post">
                                <input type="hidden" name="action" value="assignApprenantToPromo">
                                <input type="hidden" name="apprenantId" value="<%=apprenant.getId()%>">
                                <select name="promoId">
                                    <option value="0">Select a promo</option>
                                    <% ArrayList<Promos> promos = (ArrayList<Promos>) request.getAttribute("promos");
                                    for (Promos promo : promos) {%>
                                    <option value="<%=promo.getId()%>"><%=promo.getName()%></option>
                                    <%}%>
                                </select>
                                <button type="submit" class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-black border border-transparent rounded-lg active:bg-blue-600 hover:bg-gray-700 focus:outline-none focus:shadow-outline-blue">Assign</button>
                            </form>
                    </td>
                </tr>

        <%}%>
                </tbody>
            </table>
        </div>
    </div>

    <div class="container p-2 mx-auto sm:p-4 dark:text-gray-100">
        <h2 class="mb-4 text-2xl font-semibold leading-tight">Promos Table</h2>
        <div class="overflow-x-auto">
            <table class="w-full p-6 text-xs text-left whitespace-nowrap">
                <colgroup>
                    <col class="w-5">
                    <col>
                    <col>
                    <col>
                    <col>
                    <col>
                    <col class="w-5">
                </colgroup>
                <thead>
                <tr class="dark:bg-gray-700">
                    <th class="p-3">Name</th>
                    <th class="p-3 text-center">Add promo</th>
                </tr>
                </thead>
                <tbody class="border-y dark:bg-gray-900 dark:border-gray-700 ">


       <% ArrayList<Promos> promos = (ArrayList<Promos>) request.getAttribute("promos");


            for (Promos promo : promos) {%>

                <tr>
                    <td class="px-3 py-2">
                        <p><%=promo.getName()%></p>
                    </td>
                    <td class="px-3 py-2 text-center">
                        <p>add </p>
                    </td>
                </tr>

        <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>




<%--Add Formateur--%>
    <form action="../AdminServlet" method="post">
        <H1>create formateur</H1>
        <input type="hidden" name="action" value="addFormateur">
        <label >First Name:</label>
        <input type="text" name="firstname" >
        <label for="">Last Name:</label>
        <input type="text" name="lastname" >
        <label for="">Email</label>
        <input type="email" name="email" >
        <label for="">Password</label>
        <input type="password" name="password" >
        <input type="submit" value="Create Formateur">
    </form>


<%--Add Apprenant--%>
    <form action="../AdminServlet" method="post">
        <H1>create Apprenant</H1>
        <input type="hidden" name="action" value="addApprenant">
        <label >First Name:</label>
        <input type="text" name="firstname" >
        <label for="lastname">Last Name:</label>
        <input type="text" name="lastname" id="lastname">
        <label for="email">Email</label>
        <input type="email" name="email" id="email">
        <label for="password">Password</label>
        <input type="password" name="password" id="password">
        <input type="submit" value="Create Apprenant">
    </form>


<%--Add Promo--%>
    <form action="../AdminServlet" method="post">
        <H1>create Promo</H1>
        <input type="hidden" name="action" value="addPromo">
        <input type="text" name="name" value=""/>
        <input type="submit" value="submit"/>
    </form>

</div>
<%@include file="../components/footer.jsp" %>
</body>
</html>
