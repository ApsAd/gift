<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Add New Product</h1>  
       <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="pname"  /></td>  
         </tr>    
         <tr>    
          <td>Desc :</td>    
          <td><form:input path="pdesc" /></td>  
         </tr>   
         <tr>    
          <td>Category:</td>    
          <td><form:input path="category" /></td>  
         </tr>   
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    