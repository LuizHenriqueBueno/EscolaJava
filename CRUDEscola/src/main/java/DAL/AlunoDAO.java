
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class AlunoDAO
{
    public String mensagem;
    Conexao conexao = new Conexao();
    
    public void cadastrarAluno(Aluno aluno)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            String instrucaoSql = "insert into pessoas "
                    + "(nome, dataNacimento, cpf) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = 
                    con.prepareStatement(instrucaoSql);
            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getdataNacimento());
            stmt.setString(3, aluno.getCpf());
            stmt.execute();
            conexao.desconectar();
            this.mensagem = "Aluno cadastrada !!!!!!";
        }
        catch (Exception e)
        {
            this.mensagem = "Erro no cadastro";
        }
    }
    
    
}
