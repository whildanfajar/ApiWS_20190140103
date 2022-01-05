/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package netech.pwsc.neotechsparepart;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author whildan fajar
 */
@Entity
@Table(name = "sparepartmotor")
@NamedQueries({
    @NamedQuery(name = "Sparepartmotor.findAll", query = "SELECT s FROM Sparepartmotor s"),
    @NamedQuery(name = "Sparepartmotor.findByIdSparepart", query = "SELECT s FROM Sparepartmotor s WHERE s.idSparepart = :idSparepart"),
    @NamedQuery(name = "Sparepartmotor.findByNamaSparepart", query = "SELECT s FROM Sparepartmotor s WHERE s.namaSparepart = :namaSparepart"),
    @NamedQuery(name = "Sparepartmotor.findByHarga", query = "SELECT s FROM Sparepartmotor s WHERE s.harga = :harga"),
    @NamedQuery(name = "Sparepartmotor.findByJenis", query = "SELECT s FROM Sparepartmotor s WHERE s.jenis = :jenis")})
public class Sparepartmotor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sparepart")
    private Integer idSparepart;
    @Column(name = "nama_sparepart")
    private String namaSparepart;
    @Column(name = "harga")
    private String harga;
    @Column(name = "jenis")
    private String jenis;

    public Sparepartmotor() {
    }

    public Sparepartmotor(Integer idSparepart) {
        this.idSparepart = idSparepart;
    }

    public Integer getIdSparepart() {
        return idSparepart;
    }

    public void setIdSparepart(Integer idSparepart) {
        this.idSparepart = idSparepart;
    }

    public String getNamaSparepart() {
        return namaSparepart;
    }

    public void setNamaSparepart(String namaSparepart) {
        this.namaSparepart = namaSparepart;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSparepart != null ? idSparepart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sparepartmotor)) {
            return false;
        }
        Sparepartmotor other = (Sparepartmotor) object;
        if ((this.idSparepart == null && other.idSparepart != null) || (this.idSparepart != null && !this.idSparepart.equals(other.idSparepart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "netech.pwsc.neotechsparepart.Sparepartmotor[ idSparepart=" + idSparepart + " ]";
    }
    
}
