package br.edu.ifpr.paranavai.armarios.dao;

import br.edu.ifpr.paranavai.armarios.conexao.HibernateUtil;
import br.edu.ifpr.paranavai.armarios.modelo.Estudante;
import java.util.List;
import org.hibernate.Session;

public class EstudanteDaoImpl implements EstudanteDao {

    private Session sessao;

    public EstudanteDaoImpl() {
        this.sessao = HibernateUtil.getSession();
    }

    @Override
    public List<Estudante> buscarTodos() {
        List<Estudante> estudante = null;
        try {
            sessao.beginTransaction();
            estudante = (List<Estudante>) this.sessao.createQuery("from Estudante").list();
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudante;
    }
    
    @Override
    public Estudante buscarPorId(Integer id) {
        Estudante estudante = null;
        try {
            sessao.beginTransaction();
            estudante = (Estudante) sessao.get(Estudante.class, id);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudante;
    }

    public Estudante inserir(Estudante estudante) {
        try {
            sessao.beginTransaction();
            sessao.persist(estudante);
            sessao.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudante;
    }

    @Override
    public void atualizar(Estudante estudante) {
        try {
            sessao.beginTransaction();
            sessao.update(estudante);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(Estudante estudante) {
        try {
            sessao.beginTransaction();
            sessao.delete(estudante);
            sessao.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
