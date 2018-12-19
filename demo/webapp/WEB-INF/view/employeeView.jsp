<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<body>
    <h2>Submitted Employee Information using addObject model object</h2>
    <h2>${message }</h2>
    <h2>Using Controller Model Attibute  ${message2}</h2>
    
    <form:errors path="employee.*"/>
    
    
    <table>
        <tr>
            <td>Name :</td>
            <td>${employee.name}</td>
        </tr>
        <tr>
            <td>ID :</td>
            <td>${employee.id}</td>
        </tr>
        <tr>
            <td>Contact Number :</td>
            <td>${employee.contactNumber}</td>
        </tr>
                <tr>
            <td>Employee DOB :</td>
            <td>${employee.employeeDOB}</td>
        </tr>
        <tr>
            <td>Employee Skills :</td>
            <td>${employee.employeeSkillsValue}</td>
        </tr>
        
    </table>
</body>
<!-- 
<body>
    <h2>Submitted Employee Information using addAttribute from controller</h2>
    <table>
        <tr>
            <td>Name :</td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>ID :</td>
            <td>${id}</td>
        </tr>
        <tr>
            <td>Contact Number :</td>
            <td>${contactNumber}</td>
        </tr>
    </table>
</body>

 -->