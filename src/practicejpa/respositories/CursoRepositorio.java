/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicejpa.respositories;

import java.util.List;
import practicejpa.entities.Curso;
import practicejpa.enums.DiaDeLaSemana;

/**
 *
 * @author Fernando
 */
public class CursoRepositorio extends RepositorioJPA<Curso>{

    public CursoRepositorio() {
        super();
    }
    
    public void crear(Curso curso) {
        super.create(curso);
    }
    
    public void editar(Curso curso) {
        super.update(curso);
    }
    
    public void borrar(Long id) {
        Curso curso = em.find(Curso.class, id);
        super.delete(curso);
    }

    public List<Curso> listarCursos() {
        super.conect();
        //List<Curso> cursos = em.createNamedQuery("SELECT c FROM Curso c", Curso.class).getResultList();
        List<Curso> cursos = em.createNamedQuery("Curso.listarCursos").getResultList();
        super.disconect();
        return cursos;
    }
    
    public Curso findById(Long id) {
        super.conect();
        Curso curso = em.createNamedQuery("Curso.findById",Curso.class)
                .setParameter("id", id).getSingleResult();
        super.disconect();
        return curso;
    }
    
    public List<Curso> buscarPorNombre(String nombre) {
        super.conect();
        List<Curso> cursos =  em.createNamedQuery("Curso.buscarPorNombre",Curso.class)
                .setParameter("nombre", nombre).getResultList();
        super.disconect();
        return cursos;
    }
    
    public List<Curso> listarCursosPorDia(DiaDeLaSemana dia) {
        super.conect();
        List<Curso> cursos = em.createNamedQuery("Curso.buscarPorDia",Curso.class)
                .setParameter("dia", dia.toString()).getResultList();
        super.disconect();
        return cursos;
    }
    
}
