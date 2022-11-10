<%@ page import="com.simplonclone.simplonclone2.entity.Brief" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.simplonclone.simplonclone2.entity.Rendus" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 05/11/2022
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rendus</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
</head>
<body class="bg-[#F0F0F0]">
<%@include file="../components/header.jsp" %>
<div class="w-full h-[90vh] pt-[10vh]">
    <% ArrayList<Rendus> rendus = (ArrayList<Rendus>) request.getAttribute("renduList");%>

    <div class=" w-full h-full flex">
<%--        sideBar--%>
        <div class="bg-gray-50 w-1/5 h-full shadow-r-[rgba(0,_0,_0,_0.24)_0px_3px_8px]">
            <ul class="text-white w-full h-auto flex flex-col items-center justify-evenly overflow-y-auto pt-6">
                <%if((ArrayList<Brief>) request.getAttribute("briefs")==null){%>
                <li class="border-t border-b w-full ">
                    <span class="m-0 p-4 pl-10 hover:bg-gray-500 rounded-xl text-gray-500 hover:text-white text-start text-lg font-semibold h-full w-full" >brief vide</span>
                </li>
                <%}else{%>
            <% ArrayList<Brief> briefs = (ArrayList<Brief>) request.getAttribute("briefs");
                for  (Brief brief : briefs) {%>
                <li class="border-t w-full">
                    <form action="../RenduServlet" method="post" class="m-0 p-4 pl-10 hover:bg-gray-500 rounded-xl text-gray-500 hover:text-white" href="">
                        <input type="hidden" name="action" value="getRendus">
                        <input type="hidden" name="briefId" value="<%=brief.getId()%>">
                        <input type="hidden" name="promoId" value="<%=brief.getPromoId()%>">
                        <input class="text-start text-lg font-semibold h-full w-full" type="submit" value="<%=brief.getName()%>">
                    </form>
                </li>
            <%}}%>
            </ul>
        </div>
        <!-- if messages == null -->
        <%if (rendus == null) {%>
        <div class=" w-full h-full flex items-center justify-center">
            select brief...
        </div>
        <%}else{%>
        <!-- if messages != null -->
        <div class="w-full h-full">
            <div class="w-full h-[70vh] py-[2%] px-[5%] overflow-y-auto">
<%--                <div class=" bg-gray-100 h-full flex items-center justify-center flex-col rounded-xl">--%>
                    <%for (Rendus rendu : rendus) {%>
<%--                    <h1><%=rendu.getMessage()%></h1>--%>
                    <div class="py-4">
                        <div class="flex items-end justify-end">
                            <div class="flex flex-col space-y-2 text-xs max-w-xs mx-2 order-1 items-end">
                                <div><span class="px-4 py-2 rounded-lg inline-block rounded-br-none bg-gray-600 text-white "><%=rendu.getApprenantByApprenantId().getFirstname()%> <%=rendu.getApprenantByApprenantId().getLastname()%> : <%=rendu.getMessage()%></span></div>
                            </div>
<%--                            <img src="https://images.unsplash.com/photo-1590031905470-a1a1feacbb0b?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=facearea&amp;facepad=3&amp;w=144&amp;h=144" alt="My profile" class="w-6 h-6 rounded-full order-2">--%>
                        </div>
                    </div>
                    <%}%>
<%--                </div>--%>
            </div>
            <div class="  h-[10vh] w-full ">
<%--                <form action="../RenduServlet" method="post" class="flex justify-between items-center h-full px-16">--%>
<%--                    <input type="hidden" name="action" value="addRendu">--%>
<%--                    <input type="hidden" name="briefId" value="<%=rendus.get(0).getBriefId()%>"/>--%>
<%--                    <input class="w-[90%] px-8 h-12 rounded-xl border-1 border-black bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block" type="text" name="message" placeholder=" Message...">--%>
<%--                    <input class="bg-black text-white px-6 py-3 rounded-xl" type="submit" value="Envoyer <%=rendus.get(0).getBriefId()%>">--%>
<%--                </form>--%>
            </div>
        </div>
        <%}%>
    </div>
</div>

<%@include file="../components/footer.jsp" %>
<script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
</body>
</html>
