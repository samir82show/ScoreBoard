/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sawad
 */
@Entity
@Table(name = "school_match")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolMatch.findAll", query = "SELECT s FROM SchoolMatch s")
    , @NamedQuery(name = "SchoolMatch.findById", query = "SELECT s FROM SchoolMatch s WHERE s.id = :id")
    , @NamedQuery(name = "SchoolMatch.findByScore1", query = "SELECT s FROM SchoolMatch s WHERE s.score1 = :score1")
    , @NamedQuery(name = "SchoolMatch.findByScore2", query = "SELECT s FROM SchoolMatch s WHERE s.score2 = :score2")
    , @NamedQuery(name = "SchoolMatch.findByStatus", query = "SELECT s FROM SchoolMatch s WHERE s.status = :status")
    , @NamedQuery(name = "SchoolMatch.findByTeam1", query = "SELECT s FROM SchoolMatch s WHERE s.team1 = :team1")
    , @NamedQuery(name = "SchoolMatch.findByTeam2", query = "SELECT s FROM SchoolMatch s WHERE s.team2 = :team2")})
public class SchoolMatch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "score1")
    private BigInteger score1;
    @Column(name = "score2")
    private BigInteger score2;
    @Column(name = "status")
    private Integer status;
    @Size(max = 255)
    @Column(name = "team1")
    private String team1;
    @Size(max = 255)
    @Column(name = "team2")
    private String team2;

    public SchoolMatch() {
    }

    public SchoolMatch(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getScore1() {
        return score1;
    }

    public void setScore1(BigInteger score1) {
        this.score1 = score1;
    }

    public BigInteger getScore2() {
        return score2;
    }

    public void setScore2(BigInteger score2) {
        this.score2 = score2;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchoolMatch)) {
            return false;
        }
        SchoolMatch other = (SchoolMatch) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SchoolMatch{" + "id=" + id + ", score1=" + score1 + ", score2=" + score2 + ", status=" + status + ", team1=" + team1 + ", team2=" + team2 + '}';
    }

    
}
