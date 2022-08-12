package co.edu.utp.misiontic2022.santiagorojas;

import co.edu.utp.misiontic2022.santiagorojas.view.ReportesView;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        var reportesView = new ReportesView();//Funciona
        var banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);


    //    var reportesView = new ReportesView();
    // reportesView. lideresQueMasGastan();

//     var reportesView = new ReportesView();//Funciona
// var limiteInferior = 50_000d;
// reportesView.totalAdeudadoPorProyectosSuperioresALimite(limiteInferior);
    }
}
