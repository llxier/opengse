
<!-- This File is generated automatically by jsp2XML converter tool --> 
<!-- Written By Ramesh Mandava/Santosh Singh -->
<jsp:root
xmlns:jsp="http://java.sun.com/JSP/Page" version="1.2"
>

<jsp:text><![CDATA[<html>
<title>negativeForwardIllegalArg</title>
<body>
]]></jsp:text>

<jsp:scriptlet>

<![CDATA[
/*
 Name : negativeForwardIllegalArg
 Description : Checking for the IllegalArgumentException.Here, the buffer is set to none and then the forward method is called with a mis argument, to generate this exception.
*/

]]>

</jsp:scriptlet>

<jsp:text><![CDATA[
]]></jsp:text>

<jsp:scriptlet>

<![CDATA[
try{
    pageContext.forward("/tests/engine/PageContext/Missing.jsp");
   }catch(Exception e){
       out.println(e);
   }

]]>

</jsp:scriptlet>

<jsp:text><![CDATA[
</body>
</title>
]]></jsp:text>

</jsp:root>