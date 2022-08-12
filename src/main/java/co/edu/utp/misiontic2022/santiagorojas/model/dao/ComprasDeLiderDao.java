package co.edu.utp.misiontic2022.santiagorojas.model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.santiagorojas.model.vo.ComprasDeLiderVo;
import co.edu.utp.misiontic2022.santiagorojas.util.JDBCUtilities;

public class ComprasDeLiderDao {
    public List<ComprasDeLiderVo> listar() throws SQLException{
        ArrayList<ComprasDeLiderVo> respuesta=new ArrayList<ComprasDeLiderVo>();
        
        Connection conn=JDBCUtilities.getConnection();
        Statement stmt=null;
        ResultSet rset=null;
        String consulta="select l.Nombre||' '|| l.Primer_Apellido ||' '||l.Segundo_Apellido as LIDER,sum(c.Cantidad*mc.Precio_Unidad )as VALOR  from lider l join proyecto p on(p.id_lider=l.id_lider)  join compra c on(p.ID_Proyecto=c.id_proyecto) join MaterialConstruccion mc on(mc.ID_MaterialConstruccion=c.id_materialconstruccion) group by LIDER order by valor desc LIMIT 10 ;";
        try{
            stmt=conn.createStatement();
            rset=stmt.executeQuery(consulta);
            while(rset.next()){
                ComprasDeLiderVo vo=new ComprasDeLiderVo();
                vo.setLider(rset.getString("lider"));
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
