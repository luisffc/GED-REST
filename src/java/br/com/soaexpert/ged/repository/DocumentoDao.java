/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.soaexpert.ged.repository;

import br.com.soaexpert.ged.domain.Documento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author root
 */
public class DocumentoDao {

    private static HashMap<Long, Documento> content = new HashMap<Long, Documento>();
    private static AtomicLong count = new AtomicLong();

    public Long save(Documento documento){
        Long id = count.incrementAndGet();
        documento.setId(id);
        content.put(documento.getId(), documento);
        return id;
    }

    public Documento findById(Long id){
        return content.get(id);
    }

    public ArrayList<Documento> findAll(){
        ArrayList<Documento> docList = new ArrayList<Documento>();
        docList.addAll(content.values());
        return docList;
    }

    public void remove(Documento documento){
        System.out.println("deletando key:"+documento.getId());
        content.remove(documento.getId());
    }

    public static void main(String... args){
        DocumentoDao dao = new DocumentoDao();
        
        Documento doc1 = new Documento();
        doc1.setId(2L);
        dao.save(doc1);

        ArrayList<Documento> docs = dao.findAll();

        for(Documento doc : docs){
            System.out.println(doc.getId());
        }
    }

}
