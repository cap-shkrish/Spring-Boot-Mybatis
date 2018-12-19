<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        
        <form:errors path="employee.*"/>        
        <form:form method="POST" action="/employeeView" modelAttribute="employee">       
             <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="contactNumber">Contact Number</form:label></td>
                    <td><form:input path="contactNumber"/></td>
                    
                </tr>
                  
               <tr>
                    <td><form:label path="employeeDOB">Student DOB</form:label></td>
                    <td><form:input path="employeeDOB"/></td>
                </tr>
               
               <tr>
                    <td><form:label path="">Employee State</form:label></td>
               <td>
               
               <form:select path="employeeSkillsValue">
               		<form:option value="0" label="Select One" />
    				<form:options items="${employee.employeeSkills}"/>
				</form:select>
				</td>
				</tr>
				<!--  
				<tr>
				<form:select path="employeeSkills">
               		<form:option value="0" label="Select One" />
               		<form:option value="1" label="Select two" />
               		<form:option value="2" label="Select three" />
               		<form:option value="3" label="Select four" />
				</form:select>	
				</tr>
				-->
                
                
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
                
            </table>
        </form:form>
        
	<div align="center">
		<h1>Hello Index Page</h1>
		<a href="/index">Go to Index Page</a>
	</div>
        
    </body>
</html>

