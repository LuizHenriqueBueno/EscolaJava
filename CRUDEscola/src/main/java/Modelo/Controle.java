
package Modelo;

import java.util.List;


public class Controle
{
    public void cadastrarAluno(List<String> listaDadosAluno)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDadosAluno(listaDadosAluno);
        this.mensagem = validacao.mensagem;
        if (this.mensagem.equals(""))
        {
            Aluno aluno = new Aluno();
            aluno.setNome(listaDadosAluno.get(1));
            aluno.setData(listaDadosAluno.get(2));
            aluno.setCpf(listaDadosAluno.get(3));
            AlunoDAO alunoDAO = new AlunoDAO();
            alunoDAO.cadastrarAluno(aluno);
            this.mensagem = alunoDAO.mensagem;
        }
    }
    
    public void cadastrarTurma(List<String> listaDadosTurma)
    {
        this.mensagem = "";
        Validacao validacao = new Validacao();
        validacao.validarDadosTurma(listaDadosTurma);
        this.mensagem = validacao.mensagem;
        if (this.mensagem.equals(""))
        {
            Turma turma = new Turma();
            turma.setDescricao(listaDadosTurma.get(1));
            turma.setAno(listaDadosTurma.get(2));
            turma.setVagas(listaDadosTurma.get(3));
            TurmaDAO turmaDAO = new TurmaDAO();
            pessoaDAO.cadastrarPessoa(turma);
            this.mensagem = TurmaDAO.mensagem;
        }
    }
    
}

