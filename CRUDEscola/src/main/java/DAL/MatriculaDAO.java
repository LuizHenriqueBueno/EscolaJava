
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MatriculaDAO
{
    public String mensagem;
    Conexao conexao = new Conexao();
    
    public void cadastrarMatricula(Matricula matricula)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "insert into pessoas "
                    + "(nome, rg, cpf) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            stmt.setString(1, matricula.getdescricao());
            stmt.setString(2, matricula.getano());
            stmt.setString(3, matricula.getvaga());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Matricula cadastrada !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro";
        }
    }
}
