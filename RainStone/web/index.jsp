<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>    
        <script type="text/javascript" src="js/bootstrap.js"></script>    
        <script type="text/javascript" src="js/bootstrap.min.js"></script>  
        <script type="text/javascript" src="js/bootstrap-transition.js"></script>  
        <script type="text/javascript" src="js/bootstrap-tabs.js"></script>  
        <link href="css/bootstrap-responsive.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/PageCSS.css" rel="stylesheet" media="screen">
        <link rel="icon" type="image/png" href="img/LogoSLCL.png" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>RainStone - Inicio</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <div class="navbar-header">
                            <a class="navbar-brand" href="Initializer">RainStone</a>
                        </div>
                    </div><!-- /.container-fluid -->
                </nav>
            </div>

            <div id="content">
                <h3>MONITORAMENTO DA NUVEM</h3>
                <div id="hostsFisicos">
                    <c:forEach var="i" begin="1" end="${qtdeHosts}"> 
                        <c:forEach var="item" items="${listHosts}">
                            <div style="float: left; margin: 7px;">
                                <h5 style="text-align: center"><b>NÓ FISICO Nº ${i}</b></h5>
                                <h5 style="text-align: center; color: gray"><c:out value="${item.nome}" /></h5>
                                <img src="images/ic_computer.ico" alt="Smiley face" height="100" width="100"><br />

                                <p><b>ID:</b> <c:out value="${item.id}" /></p>
                                <p><b>NOME:</b> <c:out value="${item.nome}" /> </p>
                                <p><b>MEMÓRIA TOTAL:</b> <c:out value="${item.memoriaTotal}" /> </p>
                                <p><b>MEMÓRIA USADA:</b> <c:out value="${item.memoriaUsada}" /> </p>
                                <p><b>VELOCIDADE DA CPU:</b> <c:out value="${item.CPUSpeed}" /> </p>
                            </c:forEach>
                        </div>
                    </c:forEach>
                </div>

                <div id="virtualMachine" style="clear: both">
                    <br /><br /><br />
                    <h3>INSTANCIAR NOVO CLUSTER VIRTUAL</h3>

                    <c:forEach var="j" begin="1" end="${qtdeHosts}">
                        <div style="float: left; margin: 7px;">
                            <h5><b>NÓ FISICO Nº ${j}</b></h5>
                            <img src="images/ic_computer.ico" alt="Smiley face" height="100" width="100"><br />
                            <input type="radio" name="opt_master" value="MASTER">MASTER<br />
                            <select id="temp_master" name="temp_master">
                                <option>Selecione...</option>
                                <option>Item 02</option>
                            </select> <br />
                            <input type="checkbox" name="opt_slave" value="SLAVE">SLAVE<br />
                            <select id="temp_slave" name="temp_slave">
                                <option>Selecione...</option>
                                <option>Item 02</option>
                            </select> <br /><br />
                            <label > Qtde de VMS: <br />
                                <input type="text" name="opt_vm" class="form-control" value="" /></label>
                        </div>
                    </c:forEach>
                </div>

                <div style="clear: both;">
                    <button type="button" class="btn btn-default navbar-btn">Instanciar Cluster Virtual</button>
                </div>

            </div>
            <div id="sidebar">
            </div>

            <div id="footer">
            </div>
        </div>

    </body>
</html>