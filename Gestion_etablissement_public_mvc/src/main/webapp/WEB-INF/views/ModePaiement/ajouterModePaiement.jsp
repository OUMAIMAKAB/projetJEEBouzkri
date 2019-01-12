<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Mode Paiement</title>

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
                        <h1 class="page-header">  Nouveau Mode Paiement</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                         Nouveau Mode Paiement
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
	                        	<c:url value="/modePaiement/enregistrer" var ="urlEnregistrerModePaiement" />

	                        	 <f:form modelAttribute="modePaiement" action="${urlEnregistrerModePaiement}"  role = "form">
									 
                                     
									<div class="form-group">
                                        <label>idModePaiement</label>
                                        <f:input path="idModePaiement" class="form-control" placeholder="idModePaiement" />
                                        <f:errors path="idModePaiement" style="color: red;"></f:errors>
                                    </div>	
                                
                                     <div class="form-group">
                                        <label>dateEmission</label>
                                        <f:input path="dateEmission" type="date" class="form-control" placeholder="dateEmission" />
                                        <f:errors path="dateEmission" type="date" style="color: red;"></f:errors>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>dateDecaissement</label>
                                        <f:input path="dateDecaissement" type="date" class="form-control" placeholder="dateDecaissement" />
                                        <f:errors path="dateDecaissement" type="date" style="color: red;"></f:errors>
                                    </div>
                              
                               
                               
                                   
                                   
                                    <div class="form-group">
                                        <label>type mode Paiement </label>
                                        <f:select class="form-control" path="type" items="${typesMode }" />
                                    </div>						
                                    
                                    
                                    
                                    <div class="form-group">
                                        <label>montant</label>
                                        <f:input path="montant" class="form-control" placeholder="montant" />
                                        <f:errors path="montant" style="color: red;"></f:errors>
                                    </div>	
                                    	
								    
                                      <div class="form_group">
                                       <label>id compte</label>
                                       <f:select class="form-control" path="compte.idCompte" items="${comptes }" itemLabel="idCompte" itemValue="idCompte" />
                                    </div>
                                    
                                    
                                    
                                    <div class="form_group">
                                       <label>Bénéficiaire</label>
                                       <f:select class="form-control" path="beneficaire.idBeneficaire" items="${beneficaires }" itemLabel="nom" itemValue="idBeneficaire" />
                                    </div>
                                    
                                    <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;enregistrer</i></button>
                                    	<a href="<c:url value="/modePaiement/" />" class="btn btn-danger"> annuler </a>
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
