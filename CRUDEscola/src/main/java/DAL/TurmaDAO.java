
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TurmaDAO
{
    public String mensagem;
    Conexao conexao = new Conexao();
    
    public void cadastrarTurma(Turma turma)
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
            stmt.setString(1, turma.getidAluno());
            stmt.setString(2, turma.getidTurma());
            stmt.setString(3, turma.getidMatricula());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Turma cadastrada !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro";
        }
    }
}
