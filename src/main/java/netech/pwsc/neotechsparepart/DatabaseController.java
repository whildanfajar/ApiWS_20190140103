/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netech.pwsc.neotechsparepart;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author whildan fajar
 */
@RestController
@RequestMapping(value="/sparepart")
public class DatabaseController {
    
    @Autowired
    RepositorySparepart repositorySparepart;
            
    @PostMapping(value = "/addsparepart")
    public Sparepartmotor addsparepart(@RequestBody Sparepartmotor Param)
    {
        repositorySparepart.save(Param);
        return Param;
    }
    
    @GetMapping(value = "/allsparepart")
    public List<Sparepartmotor> allsparepart()
    {
        return repositorySparepart.findAll();
    }
    
    @PutMapping(value = "/updatesparepart")
    public Sparepartmotor updatesparepart(@RequestBody Sparepartmotor Param)
    {
       return repositorySparepart.save(Param);
    }
    
    @DeleteMapping(value = "/hapussparepart")
    public List<Sparepartmotor> hapussparepart(@RequestParam int id)
    {
        repositorySparepart.deleteById(id);
        List<Sparepartmotor> sparepartlist = repositorySparepart.findAll();
        return sparepartlist;
    }
}
