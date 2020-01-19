/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author franc
 */
public class Pr4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("pr4PU");
        EntityManager em = emf.createEntityManager();
        em.close();
        emf.close();
        // TODO code application logic here
    }
    
}
/*
1)Si es el esquema que me esperaba
2)La relación entre articulo y autor si se ha creado de forma correcta
*/