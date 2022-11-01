<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 29/10/2022
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="https://cdn.tailwindcss.com"></script>
    <title>Login Page</title>
</head>
<body>

<!-- component -->
<div class="w-full h-[100vh] flex items-center justify-evenly">
  <div class="  flex flex-col justify-center w-1/2">
    <div class="relative py-3 sm:max-w-xl sm:mx-auto">
      <div
              class="absolute inset-0 bg-gradient-to-r from-red-300 to-red-600 shadow-lg transform -skew-y-6 sm:skew-y-0 sm:-rotate-6 sm:rounded-3xl">
      </div>
      <form action="../AuthServlet" method="post" class="relative px-4 py-10 bg-white shadow-lg sm:rounded-3xl sm:p-20">
        <div class="max-w-md mx-auto">
          <div>
            <h1 class="text-2xl font-semibold text-center">Login</h1>
          </div>
          <div class="divide-y divide-gray-200">
            <div class="py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7">
              <div class="relative">
                <select name="role" id="role" class="peer placeholder-transparent h-10 w-full border-b-2 border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600">
                  <option value="" disabled selected>chose one...</option>
                  <option value="admin">Admin</option>
                  <option value="apprenant">Apprenant</option>
                  <option value="formateur">Formateur</option>
                </select>
                <label for="role" class="absolute left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm">You are</label>
              </div>
              <div class="relative">
                <input autocomplete="off" id="email" name="email" type="text" class="peer placeholder-transparent h-10 w-full border-b-2 border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600" placeholder="Email address" />
                <label for="email" class="absolute left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm">Email Address</label>
              </div>
              <div class="relative">
                <input autocomplete="off" id="password" name="password" type="password" class="peer placeholder-transparent h-10 w-full border-b-2 border-gray-300 text-gray-900 focus:outline-none focus:borer-rose-600" placeholder="Password" />
                <label for="password" class="absolute left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm">Password</label>
              </div>
              <div class="relative">
                <button class="bg-blue-500 text-white rounded-md px-2 py-1">Submit</button>
              </div>
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
  <div class="w-1/2 h-full flex items-center" style="">
    <img src="https://www.ma-sphere.eu/wp-content/uploads/2016/04/LOGO-SIMPLON.png" alt="" class="w-full object-cover">
  </div>
</div>


</body>
</html>
