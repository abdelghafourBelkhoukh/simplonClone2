<%@ page import="com.simplonclone.simplonclone2.entity.Formateur" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.simplonclone.simplonclone2.entity.Apprenant" %>
<%@ page import="com.simplonclone.simplonclone2.entity.Promos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.38.0/dist/full.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://unpkg.com/flowbite@1.5.3/dist/flowbite.min.css" />
    <script src="https://cdn.tailwindcss.com"></script>
    <title>Admin Page</title>
</head>
<body class="bg-[#F0F0F0]">
<%@include file="../components/header.jsp" %>

<div class="w-full h-auto flex flex-row-reverse pt-[18vh]">

    <div class="flex flex-col justify-end w-[10%] h-[70vh] fixed px-[20px] pb-16 z-[10]">
        <a href="#my-modal-2" class="btn border-0 bg-red-600 my-6">Add Formateur</a>
        <a href="#my-modal-3" class="btn border-0 bg-red-600 my-6">Add Apprenant</a>
        <a href="#my-modal-4" class="btn border-0 bg-red-600 my-6">Add Promo</a>
        <!-- Put this part before </body> tag -->
        <div class="modal" id="my-modal-2">
            <div class="modal-box px-14">
                <form action="../AdminServlet" method="post">
                    <H1 class=" font-medium leading-tight text-xl mt-10 mb-2 text-gray-600 text-center">Create Formateur</H1>
                    <div class="relative z-0 mb-6 mt-10 w-full group">
                        <input type="text" name="firstname" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                        <label class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">First Name:</label>
                    </div>
                    <div class="relative z-0 mb-6 w-full group">
                        <input type="text" name="lastname" id="lastname1" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                        <label for="lastname1" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Last Name:</label>
                    </div>
                    <div class="relative z-0 mb-6 w-full group">
                        <input type="email" name="email" id="email1" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                        <label for="email1" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Email</label>
                    </div>
                    <div class="relative z-0 mb-6 w-full group">
                        <input type="password" name="password" id="password1" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                        <label for="password1" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Password</label>
                    </div>
                    <div class="w-full flex justify-end  py-7">
                        <input class=" inline-block px-6 py-2.5 bg-gray-800 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-900 hover:shadow-lg focus:bg-gray-900 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-900 active:shadow-lg transition duration-150 ease-in-out" type="submit" value="Create Formateur">
                    </div>
                    <input type="hidden" name="action" value="addFormateur">
                </form>
            </div>
        </div>


        <div class="modal" id="my-modal-3">
            <div class="modal-box px-14">
                <form action="../AdminServlet" method="post">
                    <H1 class=" font-medium leading-tight text-xl mt-10 mb-2 text-gray-600 text-center">Create Apprenant</H1>
                    <div class="relative z-0 mb-6 mt-10 w-full group">
                        <input type="text" name="firstname" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                        <label class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">First Name:</label>
                    </div>
                    <div class="relative z-0 mb-6 w-full group">
                        <input type="text" name="lastname" id="lastname" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                        <label for="lastname" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Last Name:</label>
                    </div>
                    <div class="relative z-0 mb-6 w-full group">
                        <input type="email" name="email" id="email" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                        <label for="email" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Email</label>
                    </div>
                    <div class="relative z-0 mb-6 w-full group">
                        <input type="password" name="password" id="password" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required>
                        <label for="password" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Password</label>
                    </div>
                    <div class="w-full flex justify-end  py-7">
                        <input class=" inline-block px-6 py-2.5 bg-gray-800 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-900 hover:shadow-lg focus:bg-gray-900 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-900 active:shadow-lg transition duration-150 ease-in-out" type="submit" value="Create Apprenant">
                    </div>
                    <input type="hidden" name="action" value="addApprenant">
                </form>
            </div>
        </div>


        <div class="modal" id="my-modal-4">
            <div class="modal-box">
                <form action="../AdminServlet" method="post">
                    <H1 class="font-medium leading-tight text-xl mt-0 mb-2 text-gray-600 text-center">Create Promo</H1>
                    <div class="relative z-0 mb-6 w-full group">
                        <input type="text" name="name" value="" class="block py-2.5 px-0 w-full text-sm text-gray-900 bg-transparent border-0 border-b-2 border-gray-300 appearance-none dark:text-white dark:border-gray-600 dark:focus:border-blue-500 focus:outline-none focus:ring-0 focus:border-blue-600 peer" placeholder=" " required />
                        <label for="" class="peer-focus:font-medium absolute text-sm text-gray-500 dark:text-gray-400 duration-300 transform -translate-y-6 scale-75 top-3 -z-10 origin-[0] peer-focus:left-0 peer-focus:text-blue-600 peer-focus:dark:text-blue-500 peer-placeholder-shown:scale-100 peer-placeholder-shown:translate-y-0 peer-focus:scale-75 peer-focus:-translate-y-6">Email address</label>
                    </div>
                    <input type="hidden" name="action" value="addPromo">
                    <input class="inline-block px-6 py-2.5 bg-gray-800 text-white font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-900 hover:shadow-lg focus:bg-gray-900 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-900 active:shadow-lg transition duration-150 ease-in-out" type="submit" value="submit"/>
                </form>
                <%--                    <button class="modal-action inline-block px-6 py-2 border-2 border-gray-800 text-gray-800 font-medium text-xs leading-tight uppercase rounded hover:bg-black hover:bg-opacity-5 focus:outline-none focus:ring-0 transition duration-150 ease-in-out">Cancel</button>--%>
            </div>
        </div>
    </div>

    <div class="w-full pr-60 pl-80">
    <%--    formateur Table--%>
        <div class="container p-[5rem] mx-auto dark:text-gray-100 bg-white rounded-xl shadow-[rgba(0,_0,_0,_0.24)_0px_3px_8px]" id="formateur">
            <h2 class="mb-4 text-2xl font-semibold leading-tight">Formateurs Table</h2>
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
                            <%if (formateur.getPromosByPromoId() != null) {%>
                            <p><%=formateur.getPromosByPromoId().getName()%></p>
                            <%} else {%>
                            <p>Not assigned</p>
                            <%}%>
                        </td>
                        <td class="px-3 py-2 text-center">

                            <form action="/AdminServlet" method="post" class="flex w-[16rem]">
                                <input type="hidden" name="action" value="assignFormateurToPromo">
                                <input type="hidden" name="formateurId" value="<%=formateur.getId()%>">
                                <select name="promoId" class="mr-4 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
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

    <%--    Apprenant Table--%>
        <div class="container p-[4rem] mx-auto dark:text-gray-100 mt-16 bg-white rounded-xl shadow-[rgba(0,_0,_0,_0.24)_0px_3px_8px]" id="Apprenant">
            <h2 class="mb-4 mt-[1rem] text-2xl font-semibold leading-tight">Apprenant Table</h2>
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

                                <form action="/AdminServlet" method="post" class="flex w-[16rem]">
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

    <%--    Promo Table--%>
        <div class="container p-[5rem] mx-auto dark:text-gray-100 mt-16 mb-16 bg-white rounded-xl shadow-[rgba(0,_0,_0,_0.24)_0px_3px_8px]" id="Promo">
        <h2 class="mb-4 text-2xl font-semibold leading-tight">Promos Table</h2>
        <div class="overflow-x-auto">
            <table class="w-full p-6 text-xs text-left whitespace-nowrap">
                <colgroup>
                    <col class="w-5">
                    <col class="w-5">
                </colgroup>
                <thead>
                <tr class="dark:bg-gray-700">
                    <th class="p-3">Name</th>
                </tr>
                </thead>
                <tbody class="border-y dark:bg-gray-900 dark:border-gray-700 ">


       <% ArrayList<Promos> promos = (ArrayList<Promos>) request.getAttribute("promos");


            for (Promos promo : promos) {%>

                <tr>
                    <td class="px-3 py-2">
                        <p><%=promo.getName()%></p>
                    </td>
                </tr>

            <%}%>
                </tbody>
            </table>
        </div>
    </div>
    </div>

    <div class=" flex justify-end items-end w-[15%] h-[70vh] top-[10vh] left-[0] fixed z-[1]">
        <div class=" rounded w-[50%] h-[45vh] mb-4 mr-4">
            <div class="flex flex-col justify-evenly items-center h-[100%] w-full">
                <a href="#formateur" class="border-4 border-gray-200 w-full py-6 text-center rounded-2xl bg-white hover:bg-gray-200 hover:border-gray-600">Formateurs</a>
                <a href="#Apprenant" class="border-4 border-gray-200 w-full py-6 text-center rounded-2xl bg-white hover:bg-gray-200 hover:border-gray-600">Apprenants</a>
                <a href="#Promo" class="border-4 border-gray-200 w-full py-6 text-center rounded-2xl bg-white hover:bg-gray-200 hover:border-gray-600"
                >Promos</a>
            </div>
        </div>
    </div>



</div>
<%@include file="../components/footer.jsp" %>
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
                }, 700, function(){

                    // Add hash (#) to URL when done scrolling (default click behavior)
                    window.location.hash = hash;
                });
            } // End if
        });
    });
</script>
</body>
</html>
