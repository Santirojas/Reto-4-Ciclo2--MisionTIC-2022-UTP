package co.edu.utp.misiontic2022.santiagorojas.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.santiagorojas.model.vo.DeudasPorProyectoVo;
import co.edu.utp.misiontic2022.santiagorojas.util.JDBCUtilities;

public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> listar(Double limite) throws SQLException{
        ArrayList<DeudasPorProyectoVo> respuesta=new ArrayList<DeudasPorProyectoVo>();
        
        Connection conn=JDBCUtilities.getConnection();
        PreparedStatement stmt=null;
        ResultSet rset=null;
        String consulta="select  c.ID_Proyecto as id,sum(c.Cantidad*mc.Precio_Unidad )as VALOR  from Compra c  join MaterialConstruccion mc on(c.ID_MaterialConstruccion=mc.ID_MaterialConstruccion)where c.Pagado ='No'group by c.ID_Proyecto having valor>? order by valor desc ";
        try{
            stmt=conn.prepareStatement(consulta);
            stmt.setDouble(1,limite);
            rset=stmt.executeQuery();
            while(rset.next()){
                DeudasPorProyectoVo vo=new DeudasPorProyectoVo();
                vo.setId(rset.getInt("id"));
                vo.setValor(rset.getDouble("valor"));
                respuesta.add(vo);
            }
            
        }
        finally{
            if(rset!=null){
                rset.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return respuesta;

    }
    
}
