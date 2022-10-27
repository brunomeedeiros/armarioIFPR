package br.edu.ifpr.paranavai.armarios.dao;

import java.util.List;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;

public interface EstudanteDao {
    public List<Estudante> buscarTodos();
    public Estudante buscarPorId(Integer id);
    public Estudante inserir(Estudante estudante);
    public void atualizar(Estudante estudante);
    public void excluir(Estudante estudante);
}
