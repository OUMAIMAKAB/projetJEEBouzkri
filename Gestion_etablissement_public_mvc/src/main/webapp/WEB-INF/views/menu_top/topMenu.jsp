<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; background-image:url("<%=request.getContextPath() %>/resources/images/arriere_plan1.jpg") ;">      
            
            
            <ul class="nav navbar-top-links navbar-right" ">
               
                    
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        
                        <c:url value="/j_spring_security_logout" var="logout" />
			            <li><a href="${logout }"><i class="fa fa-sign-out fa-fw"></i>Logout</a></li>
                        </li>
                    </ul>
            </nav>