package co.edu.utp.misiontic2022.santiagorojas.controller;

import java.sql.SQLException;
import java.util.List;

import co.edu.utp.misiontic2022.santiagorojas.model.dao.ComprasDeLiderDao;
import co.edu.utp.misiontic2022.santiagorojas.model.dao.DeudasPorProyectoDao;
import co.edu.utp.misiontic2022.santiagorojas.model.dao.ProyectoBancoDao;
import co.edu.utp.misiontic2022.santiagorojas.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.santiagorojas.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.santiagorojas.model.vo.ProyectoBancoVo;

public class ReportesController {
    private ComprasDeLiderDao comprasDeLiderDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ProyectoBancoDao proyectoBancoDao;


    public ReportesController() {
        proyectoBancoDao=new ProyectoBancoDao();
        deudasPorProyectoDao=new DeudasPorProyectoDao();    
        comprasDeLiderDao=new ComprasDeLiderDao();  

    }

    public List<ProyectoBancoVo> listarProyectosPorBanco(String banco) throws SQLException {
       return proyectoBancoDao.listar(banco);
    }
    public List<DeudasPorProyectoVo> listarTotalAdeudadoProyectos(Double limite)throws SQLException {
        return deudasPorProyectoDao.listar(limite);
    }
    public List<ComprasDeLiderVo> listarLideresQueMasGastan() throws SQLException {
        return comprasDeLiderDao.listar();
    }
}
