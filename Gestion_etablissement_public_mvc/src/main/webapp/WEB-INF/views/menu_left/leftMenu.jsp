<div style="margin-top: 0px"class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
		
			<!-- 
			<c:url value="/home/" var="home" />
			<a href="${home}"></a>
			  -->
			    <c:url value="/accueil/" var="accueil" />
				<li><a href="${accueil}"><i class="fa fa-institution fa-fw"></i>
					Accueil</a></li>
					
			    <c:url value="/etablissement/" var="etablissement" />
				<li><a href="${etablissement}"><i class="fa fa-institution fa-fw"></i>
					Etablissements</a></li>
					
			
			    <c:url value="/compte/" var="compte" />
				<li><a href="${compte}"><i class="fa fa-institution fa-fw"></i>
					Comptes</a></li>
					
				<c:url value="/exercice/" var="exercice" />
				<li><a href="${exercice}"><i class="fa fa-institution fa-fw"></i>
					Exercices</a></li>
					
					<c:url value="/beneficaire/" var="beneficaire" />
				<li><a href="${beneficaire}"><i class="fa fa-institution fa-fw"></i>
					Beneficaires</a></li>
					
					<c:url value="/rubrique/" var="rubrique" />
				<li><a href="${rubrique}"><i class="fa fa-institution fa-fw"></i>
					Rubriques</a></li>
					
				<c:url value="/fluxEntrant/" var="fluxEntrant" />
				<li><a href="${fluxEntrant}"><i class="fa fa-institution fa-fw"></i>
					FluxEntrant</a></li>
				 
				 <c:url value="/creditOuvert/" var="creditOuvert" />
				<li><a href="${creditOuvert}"><i class="fa fa-institution fa-fw"></i>
					CreditOuverts</a></li>
					
				<c:url value="/modePaiement/" var="modePaiement" />
				<li><a href="${modePaiement}"><i class="fa fa-institution fa-fw"></i>
					Mode Paiements</a></li>
					
				<c:url value="/ordrePaiement/" var="ordrePaiement" />
				<li><a href="${ordrePaiement}"><i class="fa fa-institution fa-fw"></i>
					ordre Paiements</a></li>
					
				<c:url value="/utilisateur/" var="utilisateur" />
				<li><a href="${utilisateur}"><i class="fa fa-institution fa-fw"></i>
					Utilisateurs</a></li>
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>