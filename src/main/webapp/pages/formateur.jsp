<%@ page import="com.simplonclone.simplonclone2.entity.Brief" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.simplonclone.simplonclone2.entity.Promos" %>
<%@ page import="com.simplonclone.simplonclone2.entity.Apprenant" %><%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 29/10/2022
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>formateur page</title>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.38.0/dist/full.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-[#F0F0F0]">
    <%@include file="../components/header.jsp" %>


        <div class="w-full h-auto flex flex-row-reverse pt-[15vh] mb-16" >

<%--            <div class="flex flex-col justify-center w-[10%] h-[90vh] fixed px-[20px] z-10">--%>
<%--                <a href="#my-modal-3" class="btn border-0 bg-red-600 my-6">Add Brief</a>--%>

<%--                --%>
<%--            </div>--%>

            <div class="w-full pr-28 pl-[15rem] tableContainer">

<%--                briefs table--%>
                <div class="container p-[5rem] rounded-xl mx-auto dark:text-gray-100 bg-white shadow-[rgba(0,_0,_0,_0.24)_0px_3px_8px]" id="brief">
                    <h2 class="mb-4 text-2xl font-semibold leading-tight">brief Table</h2>
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
                                <th class="p-3 text-center">Name</th>
                                <th class="p-3 text-center">Description</th>
                                <th class="p-3 text-center">promo</th>
                                <th class="p-3 text-center">Assign to promo</th>
                            </tr>
                            </thead>
                            <tbody class="border-y dark:bg-gray-900 dark:border-gray-700 ">


                            <% ArrayList<Brief> briefs = (ArrayList<Brief>) request.getAttribute("briefs");


                                for  (Brief brief : briefs) {%>
                            <tr class="dark:bg-gray-700">
                                <td class="p-3 text-center"><%= brief.getName() %></td>
                                <td class="p-3 text-center"><%= brief.getDescription() %></td>
                                <td class="p-3 text-center">
                                    <%if (brief.getPromosByPromoId() != null) {%>
                                    <p><%=brief.getPromosByPromoId().getName()%></p>
                                    <%} else {%>
                                    <p>Not assigned</p>
                                    <%}%>
                                </td>

                                <td class="p-3 text-center">
                                    <form action="/FormateurServlet" method="post" class="flex w-[16rem]">
                                        <input type="hidden" name="action" value="assignBriefToPromo">
                                        <input type="hidden" name="briefId" value="<%=brief.getId()%>">
                                        <select name="promoId" class="mr-4 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                                            <option value="0">Select a promo</option>
                                            <% ArrayList<Promos> promos = (ArrayList<Promos>) request.getAttribute("promos");
                                                for (Promos promo : promos) {%>
                                            <option value="<%=promo.getId()%>"><%=promo.getName()%></option>
                                            <%}%>
                                        </select>
                                        <button type="submit" class="px-3 py-1 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-black border border-transparent rounded-lg active:bg-blue-600 hover:bg-blue-700 focus:outline-none focus:shadow-outline-blue">Assign</button>
                                    </form>
                                </td>

                            </tr>
                            <% } %>
                            </tbody>
                        </table>
                    </div>
                </div>

<%--               apprenant table--%>
                <div class="container p-[5rem] rounded-xl mx-auto dark:text-gray-100 bg-white mt-16 shadow-[rgba(0,_0,_0,_0.24)_0px_3px_8px]" id="Apprenant">
                    <h2 class="mb-4 text-2xl font-semibold leading-tight">Apprenant Table</h2>
                    <div class="overflow-x-auto">
                        <table class="w-full p-6 text-xs text-left whitespace-nowrap">
                            <colgroup>
                                <col class="w-5">
                                <col>
                                <col>
                                <col>
                                <col class="w-5">
                            </colgroup>
                            <thead>
                            <tr class="dark:bg-gray-700">
                                <th class="p-3 text-center">First Name</th>
                                <th class="p-3 text-center">Last Name</th>
                                <th class="p-3 text-center">Email</th>
                                <th class="p-3 text-center">Promo</th>
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
                                    <%if (apprenant.getPromosByPromoId() != null) {%>
                                    <p><%=apprenant.getPromosByPromoId().getName()%></p>
                                    <%} else {%>
                                    <p>Not assigned</p>
                                    <%}%>
                                </td>
                                <td class="px-3 py-2 text-center">

                                    <form action="/FormateurServlet" method="post" class="flex w-[16rem]">
                                        <input type="hidden" name="action" value="assignApprenantToPromo">
                                        <input type="hidden" name="apprenantId" value="<%=apprenant.getId()%>">
                                        <select name="promoId" class="mr-4 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
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

            </div>

            <div class=" flex justify-end items-start w-[15%] h-[70vh] top-[10vh] left-[0] fixed ">
                <div class=" rounded w-[50%] h-[45vh] mt-[37px] mr-4">
                    <div class="flex flex-col justify-evenly items-center h-[100%] w-auto bg-white  rounded-xl shadow-[rgba(0,_0,_0,_0.24)_0px_3px_8px]" style="font-size:13px;font-family:'Nunito Sans',sans-serif;">

                        <a href="#brief" class="  w-full py-6 text-center rounded-2xl bg-white"><div class="flex flex-col items-center :bg-red-500">
                            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" class="sc-bf0a440d-0 jdUYLw">
                                <path d="M15 6h1.5c.398 0 .78.164 1.06.456.282.291.44.687.44 1.1v10.888c0 .413-.158.809-.44 1.1A1.474 1.474 0 0116.5 20h-9c-.398 0-.78-.164-1.06-.456a1.585 1.585 0 01-.44-1.1V7.556c0-.413.158-.809.44-1.1A1.473 1.473 0 017.5 6H9" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="colorStroke"></path>
                                <path d="M14.25 4h-4.5a.75.75 0 00-.75.75v1.5c0 .414.336.75.75.75h4.5a.75.75 0 00.75-.75v-1.5a.75.75 0 00-.75-.75zM9 11h6m-6 4h3.75" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="colorStroke"></path></svg
                            ><span class="sc-6a4c5dd9-0 sc-87c2614c-0 HdEwm jwTbEc">Briefs</span>
                        </div></a>
                        <a href="#Apprenant" class=" w-full py-6 text-center rounded-2xl bg-white">
                            <div class="flex flex-col items-center">
                            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" class="sc-bf0a440d-0 jdUYLw">
                                <path d="M17 21V19C17 17.9391 16.5786 16.9217 15.8284 16.1716C15.0783 15.4214 14.0609 15 13 15H5C3.93913 15 2.92172 15.4214 2.17157 16.1716C1.42143 16.9217 1 17.9391 1 19V21" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="colorStroke"></path>
                                <path d="M9 11C11.2091 11 13 9.20914 13 7C13 4.79086 11.2091 3 9 3C6.79086 3 5 4.79086 5 7C5 9.20914 6.79086 11 9 11Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="colorStroke"></path>
                                <path d="M23 21V19C22.9993 18.1137 22.7044 17.2528 22.1614 16.5523C21.6184 15.8519 20.8581 15.3516 20 15.13" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="colorStroke"></path>
                                <path d="M16 3.13C16.8604 3.35031 17.623 3.85071 18.1676 4.55232C18.7122 5.25392 19.0078 6.11683 19.0078 7.005C19.0078 7.89318 18.7122 8.75608 18.1676 9.45769C17.623 10.1593 16.8604 10.6597 16 10.88" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="colorStroke"></path>
                            </svg>
                            <span class="sc-6a4c5dd9-0 sc-87c2614c-0 HdEwm jwTbEc">Apprenants</span>
                            </div>
                        </a>

                        <a href="#my-modal-3" class=" w-full py-6 text-center rounded-2xl bg-white">
                            <div class="flex flex-col items-center">
                                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" focusable="false" class="sc-bf0a440d-0 jdUYLw">
                                    <line x1="12" y1="7" x2="12" y2="17" stroke="black" stroke-width="2" stroke-linecap="round" class="colorStroke"></line>
                                    <line x1="7" y1="12" x2="17" y2="12" stroke="black" stroke-width="2" stroke-linecap="round" class="colorStroke"></line>
                                </svg>
                                <span class="sc-6a4c5dd9-0 sc-87c2614c-0 HdEwm jwTbEc">Add Brief</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <div class="modal z-10" id="my-modal-3">
                <div class="modal-box  px-14">
                    <%--                        <label for="my-modal-3" class="btn btn-sm btn-circle absolute right-2 top-2">✕</label>--%>
                    <form action="../FormateurServlet" method="post">
                        <H1 class=" font-medium leading-tight text-xl mt-10 mb-2 text-gray-600 text-center">Create Brief</H1>
                        <div class="relative z-0 mb-6 mt-10 w-full group">
                            <input type="text" name="title" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                            <label class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Title:</label>
                        </div>
                        <div class="relative z-0 mb-6 w-full group">
                            <input type="text" name="description"  class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                            <label  class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Description:</label>
                        </div>
                        <div class="w-full flex justify-end  py-7">
                            <input class=" inline-block px-6 py-2.5 bg-gray-800 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-900 hover:shadow-lg focus:bg-gray-900 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-900 active:shadow-lg transition duration-150 ease-in-out" type="submit" value="Create Brief">
                        </div>
                        <input type="hidden" name="action" value="addBrief">
                    </form>
                </div>
            </div>

        </div>





        <%@include file="../components/footer.jsp" %>
    </form>

<script src="https://unpkg.com/flowbite@1.5.3/dist/flowbite.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        // Add smooth scrolling to all links
        $("a").on('click', function(event) {

            // Make sure this.hash has a value before overriding default behavior
            if (this.hash !== "") {
                // Prevent default anchor click behavior
                event.preventDefault();

                // Store hash
                var hash = this.hash;

                // Using jQuery's animate() method to add smooth page scroll
                // The optional number (800) specifies the number of milliseconds it takes to scroll to the specified area
                $('html, body').animate({
                    scrollTop: $(hash).offset().top
                }, 800, function(){

                    // Add hash (#) to URL when done scrolling (default click behavior)
                    window.location.hash = hash;
                });
            } // End if
        });
    });
</script>
</body>
</html>
