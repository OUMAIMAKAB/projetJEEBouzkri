<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Flux Entrant</title>

    <!-- Bootstrap Core CSS -->
    <link  href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link  href="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link  href="<%=request.getContextPath() %>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link  href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
            <!-- /.navbar-static-side -->
        </nav>



        <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">  Modifier Flux Entrant</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                         Modifier Flux Entrant
	                        </div>
	                         <br /> <br />
	                 <c:if test="${exception != null}"> 
	                <div style="background-color: red;position: center;">                
	                   ${exception } 
	                 </div>
	                </c:if>
	                <br /> <br />
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                        	<c:url value="/fluxEntrant/enregistrerModification" var ="urlEnregistrerModificationFluxEntrant" />

	                        	 <f:form modelAttribute="fluxEntrant" action="${urlEnregistrerModificationFluxEntrant }"  role = "form">
									
									<f:hidden path="idFluxEntrant"/>
									
									
                                    
                                    <div class="form-group">
                                        <label>somme</label>
                                        <f:input path="somme" class="form-control" placeholder="somme" />
                                        <f:errors path="somme" style="color: red;"></f:errors>
                                    </div>								
								
                                    
                                      <div class="form_group">
                                       <label>id compte</label>
                                       <f:select class="form-control" path="compte.idCompte" items="${comptes }" itemLabel="idCompte" itemValue="idCompte" />
                                    </div>
                                    
                                    <div class="form_group">
                                       <label>Exercice</label>
                                       <f:select class="form-control" path="exercice.annee" items="${exercices }" itemLabel="annee" itemValue="annee" />
                                    </div>
                                    
                                    <div class="form_group">
                                       <label>Rubrique</label>
                                       <f:select class="form-control" path="rubrique.idRubrique" items="${rubriques }" itemLabel="libelle" itemValue="idRubrique" />
                                    </div>
                                    
                                    <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;enregistrer</i></button>
                                    	<a href="<c:url value="/fluxEntrant/" />" class="btn btn-danger"> annuler </a>
                                    </div>
								</f:form>
	                        	 
									                        
	                        </div>
	                        <!-- /.panel-body -->
	                    </div>
	                    <!-- /.panel -->
	                </div>
                <!-- /.col-lg-12 -->
            </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
        
        
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
