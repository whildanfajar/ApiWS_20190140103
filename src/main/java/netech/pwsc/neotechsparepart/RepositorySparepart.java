/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netech.pwsc.neotechsparepart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author whildan fajar
 */
@Repository
public interface RepositorySparepart extends JpaRepository<Sparepartmotor, Integer>{

}
