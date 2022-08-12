package co.edu.utp.misiontic2022.santiagorojas.model.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.utp.misiontic2022.santiagorojas.model.vo.ProyectoBancoVo;
import co.edu.utp.misiontic2022.santiagorojas.util.JDBCUtilities;

public class ProyectoBancoDao {

    public List<ProyectoBancoVo> listar(String banco) throws SQLException{
        ArrayList<ProyectoBancoVo> respuesta=new ArrayList<ProyectoBancoVo>();
        
        Connection conn=JDBCUtilities.getConnection();
        PreparedStatement stmt=null;
        ResultSet rset=null;
        String consulta="select  p.id_proyecto as ID,p.constructora, p.ciudad, p.Clasificacion, t.Estrato ,l.Nombre||' '|| l.Primer_Apellido ||' '||l.Segundo_Apellido as LIDER  from proyecto p  join Tipo t on(t.ID_Tipo=p.ID_Tipo) join Lider l on(l.ID_Lider=p.ID_Lider)where p.Banco_Vinculado=? order by p.Fecha_Inicio desc,p.ciudad asc,p.Constructora asc  ";
        try{
            stmt=conn.prepareStatement(consulta);
            stmt.setString(1,banco);
            rset=stmt.executeQuery();
            while(rset.next()){
                ProyectoBancoVo vo=new ProyectoBancoVo();
                vo.setId(rset.getInt("id"));
                vo.setConstructora(rset.getString("constructora"));
                vo.setCiudad(rset.getString("ciudad"));
                vo.setClasificacion(rset.getString("clasificacion"));
                vo.setEstrato(rset.getInt("estrato"));
                vo.setLider(rset.getString("lider"));
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
